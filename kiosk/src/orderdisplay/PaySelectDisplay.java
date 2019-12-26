package orderdisplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import common.CommonMethod;
import common.MyColor;
import common.SetLanguage;
import component.MyBorderButton2;
import discountDialog.DiscountPointDialog;
import main.Main;

public class PaySelectDisplay extends JPanel {
	
	JRadioButton takeIn;
	JRadioButton takeOut;
	boolean takeOutChecked = true;
	boolean langFlag = new SetLanguage().getLang();//언어 플래그
	
	public PaySelectDisplay(Main root, BillDisplay billDisplay) {
		setBackground(MyColor.subColor);
		setBorder(BorderFactory.createEmptyBorder(30 , 30 , 30 , 30));
		
		ButtonGroup g = new ButtonGroup(); // 버튼 그룹 객체 생성

		takeIn = new JRadioButton(langFlag ? "eat-in" : "매장 식사", true);
		takeOut = new JRadioButton(langFlag ? "take out" : "포장");
		takeIn.setFont(CommonMethod.myfont("중간 작게"));
		takeOut.setFont(CommonMethod.myfont("중간 작게"));
		takeIn.setBackground(MyColor.subColor);
		takeOut.setBackground(MyColor.subColor);
		takeIn.addItemListener(new RadioListener());
		takeOut.addItemListener(new RadioListener());
		g.add(takeIn);
		g.add(takeOut);
		
		MyBorderButton2 point1 = new MyBorderButton2(langFlag ? "Use Point" : "Point 사용", "중간 작게");
		point1.addActionListener(new ActionListener() {//포인트 사용 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				billDisplay.getDiscountPointDialog();
			}
		});
		MyBorderButton2 point2 = new MyBorderButton2(langFlag ? "Affiliate Discount" :"제휴사 할인", "중간 작게");
		point2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				billDisplay.getMemberShipDiscountDialog();
			}
		});
		MyBorderButton2 point3 = new MyBorderButton2(langFlag ? "Discount / Discount accrual" :"할인 / 적립 할인", "중간 작게");
		point3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				billDisplay.getEventDiscountDialog();
			}
		});
		MyBorderButton2 pay1 = new MyBorderButton2(langFlag ? "Credit card / Samsung / LG Pay" :"신용카드  / 삼성 / Lg페이",langFlag ? "작게" : "중간 작게");
		pay1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				billDisplay.getCardDialog(takeOutChecked);
			}
		});
		MyBorderButton2 pay2 = new MyBorderButton2(langFlag ? "mobile coupons/barcodes" :"모바일 쿠폰 / 바코드", "중간 작게");
		pay2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				billDisplay.getBarcodeDialog(takeOutChecked);
			}
		});
		MyBorderButton2 pay3 = new MyBorderButton2(langFlag ? "Kakao / Alipay" : "카카오 / 알리페이","중간 작게");
		MyBorderButton2 pay4 = new MyBorderButton2("PAYCO","중간 작게");

		add(new PayItem(langFlag ? "Packing" : "포장선택"));
		add(takeIn);
		add(takeOut);
		add(new PayItem(langFlag ? "Discounts / accruals" : "할인 / 적립"));
		add(point1);
		add(point2);
		add(point3);
		add(new PayItem(langFlag ? "Payment" : "결제"));
		add(pay1);
		add(pay2);
		add(pay3);
		add(pay4);
		setPreferredSize(new Dimension(300, 0));
	}
	
    class RadioListener implements ItemListener{//테이크아웃 레디오버튼 리스너
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange()==ItemEvent.DESELECTED){
                return;
            }
            if(takeIn.isSelected()){
            	takeOutChecked = true;
            }
            else if(takeOut.isSelected()){
            	takeOutChecked = false;
            }
            else{
            }
        }
    }
}
