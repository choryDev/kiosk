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
	
	JPanel scrollPaneBase = new JPanel(); //��ũ�� �� �ȿ� �� �ǳ�
	JScrollPane scrollPane = new JScrollPane(scrollPaneBase);
	public static ArrayList<ArrayList<MenuStructor>> totalarr = null;
	JPanel paneBill = new JPanel(); //�ϴ� ��Ż ������
	boolean langFlag = new SetLanguage().getLang();//��� �÷���
	
	DiscountPointDialog discountPointDialog = null;
	MemberShipDiscountDialog memberShipDiscountDialog = null;
	EventDiscountDialog eventDiscountDialog = null;
	CardDialog cardDialog = null;
	BarcodeDialog barcodeDialog = null;
	
	public int point = 3000;//����Ʈ
	int orderprice = 0;		//�ֹ� �ݾ�
	int discount = 0;		//���� �ݾ�
	String discountAlert = "";//���� �˸�
	int total = 0;			//�Ѿ�
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
	
	public void mainBillDisplay() {//�׸� �ȿ� �޴��� �����ֿ��� �ؼ� 2�� �迭
		for(int i = 0; i < totalarr.size(); i++) {
			int totalprice = 0;//�� �׸��� �� �ݾ�
			scrollPaneBase.add(new BillItem(i));
			for(int j = 0; j < totalarr.get(i).size(); j++) {
				scrollPaneBase.add(new BillItem(totalarr.get(i).get(j)));//�׸� ���� �޴�
				totalprice = totalprice + totalarr.get(i).get(j).getMenuPrice();//�� �޴����� 
			}
			scrollPaneBase.add(new BillItem(totalprice, true));//�ѱ׸� ����
			orderprice = orderprice + totalprice; //��� �޴� �� ����
		}
	}
	
	public void bottomBillDisplay() {//�ϴܿ� �� ��� ȭ��
		paneBill.add(new BillCostItem(langFlag ? "Order amount" : "�ֹ� �ݾ�", Integer.toString(orderprice)));
		paneBill.add(new BillCostItem(langFlag ? "discount amount" : "���� �ݾ�", discount + discountAlert));
		paneBill.add(new BillCostItem(Integer.toString(total)));
		paneBill.add(new BillCostItem(langFlag ? "Amount paid" :"������ �ݾ�", Integer.toString(0)));
	}
	
	public void getDiscountPointDialog() {//����Ʈ ���� ���̾�α� ��ü ����
		discountPointDialog = new DiscountPointDialog(root, this);
		discountPointDialog.setVisible(true);
	}
	
	public void getMemberShipDiscountDialog() {//����Ʈ ���� ���̾�α� ��ü ����
		memberShipDiscountDialog = new MemberShipDiscountDialog(root, this);
		memberShipDiscountDialog.setVisible(true);
	}
	
	public void getEventDiscountDialog() {//����Ʈ ���� ���̾�α� ��ü ����
		eventDiscountDialog = new EventDiscountDialog(root, this);
		eventDiscountDialog.setVisible(true);
	}
	
	public void getBarcodeDialog(boolean takeOutChecked) {//���ڵ� ���̾�α� ��ü ����
		barcodeDialog = new BarcodeDialog(root, this, takeOutChecked);
		barcodeDialog.setVisible(true);
		barcodeDialog.th.start();
	}
	
	public void getCardDialog(boolean takeOutChecked) {//ī�� ���̾�α� ��ü ����
		cardDialog = new CardDialog(root, this, takeOutChecked);
		cardDialog.setVisible(true);
		cardDialog.th.start();
	}
	
	public void discountPointDialogOnclickHandler() {//����Ʈ ������ �ϴ� ��ư�� ���� �޽��
		discount = discountPointDialog.textFieldValue();//����Ʈ ���� �ؽ�Ʈ�ʵ� �� ȣ��
		total = orderprice - discount; //��ü���� ���� �ݾ� ����
		point = point - discount; //���� ����Ʈ
		paneBill.removeAll(); //������Ʈ ����� ���� ����
		bottomBillDisplay();
		repaint();
		revalidate();
	}
	
	public void memeberShipDiscountHandler(int percent) {//�ɹ��� ���� ���� �Լ�
		discount = (orderprice/100) * percent; 
		total = orderprice - discount; //��ü���� ���� �ݾ� ����
		discountAlert = " => "+ percent + (langFlag ? "% Discount" : "% ���εǾ����ϴ�");
		paneBill.removeAll(); //������Ʈ ����� ���� ����
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
