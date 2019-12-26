package orderdisplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.security.PublicKey;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import common.BillObject;
import common.MenuStructor;
import common.MyColor;
import common.SetLanguage;
import discountDialog.DiscountPointDialog;
import discountDialog.EventDiscountDialog;
import discountDialog.MemberShipDiscountDialog;
import main.Main;
import menudisplay.RightMenuItem;
import payDialog.BarcodeDialog;
import payDialog.CardDialog;

public class BillDisplay extends JPanel {
	
	JPanel scrollPaneBase = new JPanel(); //스크롤 펜 안에 들어갈 판넬
	JScrollPane scrollPane = new JScrollPane(scrollPaneBase);
	public static ArrayList<ArrayList<MenuStructor>> totalarr = null;
	JPanel paneBill = new JPanel(); //하단 토탈 영수증
	boolean langFlag = new SetLanguage().getLang();//언어 플래그
	
	DiscountPointDialog discountPointDialog = null;
	MemberShipDiscountDialog memberShipDiscountDialog = null;
	EventDiscountDialog eventDiscountDialog = null;
	CardDialog cardDialog = null;
	BarcodeDialog barcodeDialog = null;
	
	public int point = 3000;//포인트
	int orderprice = 0;		//주문 금액
	int discount = 0;		//할인 금액
	String discountAlert = "";//할인 알림
	int total = 0;			//총액
	Main root;
	
	public BillDisplay(Main root) {
		this.totalarr = root.billObject.totalarr;
		this.root = root;
		
		setBackground(MyColor.mainColor);
		scrollPaneBase.setLayout(new BoxLayout(scrollPaneBase, BoxLayout.Y_AXIS));
		scrollPaneBase.setBackground(MyColor.subColor);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mainBillDisplay();
		bottomBillDisplay();
		add(new BillItem());
		add(scrollPane);
		add(paneBill);
		scrollPane.setPreferredSize(new Dimension(620, 400));
		paneBill.setPreferredSize(new Dimension(620, 210));
		paneBill.setBackground(MyColor.mainColor);
		setBackground(MyColor.mainColor);
	}
	
	public void mainBillDisplay() {//그릇 안에 메뉴를 보여주여야 해서 2중 배열
		for(int i = 0; i < totalarr.size(); i++) {
			int totalprice = 0;//한 그릇의 총 금액
			scrollPaneBase.add(new BillItem(i));
			for(int j = 0; j < totalarr.get(i).size(); j++) {
				scrollPaneBase.add(new BillItem(totalarr.get(i).get(j)));//그릇 안의 메뉴
				totalprice = totalprice + totalarr.get(i).get(j).getMenuPrice();//각 메뉴가격 
			}
			scrollPaneBase.add(new BillItem(totalprice, true));//한그릇 총합
			orderprice = orderprice + totalprice; //모든 메뉴 총 가격
		}
	}
	
	public void bottomBillDisplay() {//하단에 총 계산 화면
		paneBill.add(new BillCostItem(langFlag ? "Order amount" : "주문 금액", Integer.toString(orderprice)));
		paneBill.add(new BillCostItem(langFlag ? "discount amount" : "할인 금액", discount + discountAlert));
		paneBill.add(new BillCostItem(Integer.toString(total)));
		paneBill.add(new BillCostItem(langFlag ? "Amount paid" :"결제한 금액", Integer.toString(0)));
	}
	
	public void getDiscountPointDialog() {//포인트 할인 다이얼로그 객체 생성
		discountPointDialog = new DiscountPointDialog(root, this);
		discountPointDialog.setVisible(true);
	}
	
	public void getMemberShipDiscountDialog() {//포인트 할인 다이얼로그 객체 생성
		memberShipDiscountDialog = new MemberShipDiscountDialog(root, this);
		memberShipDiscountDialog.setVisible(true);
	}
	
	public void getEventDiscountDialog() {//포인트 할인 다이얼로그 객체 생성
		eventDiscountDialog = new EventDiscountDialog(root, this);
		eventDiscountDialog.setVisible(true);
	}
	
	public void getBarcodeDialog(boolean takeOutChecked) {//바코드 다이얼로그 객체 생성
		barcodeDialog = new BarcodeDialog(root, this, takeOutChecked);
		barcodeDialog.setVisible(true);
		barcodeDialog.th.start();
	}
	
	public void getCardDialog(boolean takeOutChecked) {//카드 다이얼로그 객체 생성
		cardDialog = new CardDialog(root, this, takeOutChecked);
		cardDialog.setVisible(true);
		cardDialog.th.start();
	}
	
	public void discountPointDialogOnclickHandler() {//포인트 할인을 하는 버튼을 누른 메써드
		discount = discountPointDialog.textFieldValue();//포인트 할인 텍스트필드 값 호출
		total = orderprice - discount; //전체에서 할인 금액 빼기
		point = point - discount; //남은 포인트
		paneBill.removeAll(); //컴포넌트 지우고 새로 생성
		bottomBillDisplay();
		repaint();
		revalidate();
	}
	
	public void memeberShipDiscountHandler(int percent) {//맴버쉽 가격 할인 함수
		discount = (orderprice/100) * percent; 
		total = orderprice - discount; //전체에서 할인 금액 빼기
		discountAlert = " => "+ percent + (langFlag ? "% Discount" : "% 할인되었습니다");
		paneBill.removeAll(); //컴포넌트 지우고 새로 생성
		bottomBillDisplay();
		repaint();
		revalidate();
	}
	
	public void changeFianlDisplay() {
		root.changeFinalDisplay();
	}
	
	public void changeSeatDisplay() {
		root.changeSeatDisplay();
	}
}
