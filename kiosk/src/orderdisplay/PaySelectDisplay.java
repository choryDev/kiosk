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
	boolean langFlag = new SetLanguage().getLang();//��� �÷���
	
	public PaySelectDisplay(Main root, BillDisplay billDisplay) {
		setBackground(MyColor.subColor);
		setBorder(BorderFactory.createEmptyBorder(30 , 30 , 30 , 30));
		
		ButtonGroup g = new ButtonGroup(); // ��ư �׷� ��ü ����

		takeIn = new JRadioButton(langFlag ? "eat-in" : "���� �Ļ�", true);
		takeOut = new JRadioButton(langFlag ? "take out" : "����");
		takeIn.setFont(CommonMethod.myfont("�߰� �۰�"));
		takeOut.setFont(CommonMethod.myfont("�߰� �۰�"));
		takeIn.setBackground(MyColor.subColor);
		takeOut.setBackground(MyColor.subColor);
		takeIn.addItemListener(new RadioListener());
		takeOut.addItemListener(new RadioListener());
		g.add(takeIn);
		g.add(takeOut);
		
		MyBorderButton2 point1 = new MyBorderButton2(langFlag ? "Use Point" : "Point ���", "�߰� �۰�");
		point1.addActionListener(new ActionListener() {//����Ʈ ��� ��ư
			@Override
			public void actionPerformed(ActionEvent e) {
				billDisplay.getDiscountPointDialog();
			}
		});
		MyBorderButton2 point2 = new MyBorderButton2(langFlag ? "Affiliate Discount" :"���޻� ����", "�߰� �۰�");
		point2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				billDisplay.getMemberShipDiscountDialog();
			}
		});
		MyBorderButton2 point3 = new MyBorderButton2(langFlag ? "Discount / Discount accrual" :"���� / ���� ����", "�߰� �۰�");
		point3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				billDisplay.getEventDiscountDialog();
			}
		});
		MyBorderButton2 pay1 = new MyBorderButton2(langFlag ? "Credit card / Samsung / LG Pay" :"�ſ�ī��  / �Ｚ / Lg����",langFlag ? "�۰�" : "�߰� �۰�");
		pay1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				billDisplay.getCardDialog(takeOutChecked);
			}
		});
		MyBorderButton2 pay2 = new MyBorderButton2(langFlag ? "mobile coupons/barcodes" :"����� ���� / ���ڵ�", "�߰� �۰�");
		pay2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				billDisplay.getBarcodeDialog(takeOutChecked);
			}
		});
		MyBorderButton2 pay3 = new MyBorderButton2(langFlag ? "Kakao / Alipay" : "īī�� / �˸�����","�߰� �۰�");
		MyBorderButton2 pay4 = new MyBorderButton2("PAYCO","�߰� �۰�");

		add(new PayItem(langFlag ? "Packing" : "���弱��"));
		add(takeIn);
		add(takeOut);
		add(new PayItem(langFlag ? "Discounts / accruals" : "���� / ����"));
		add(point1);
		add(point2);
		add(point3);
		add(new PayItem(langFlag ? "Payment" : "����"));
		add(pay1);
		add(pay2);
		add(pay3);
		add(pay4);
		setPreferredSize(new Dimension(300, 0));
	}
	
    class RadioListener implements ItemListener{//����ũ�ƿ� �������ư ������
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
