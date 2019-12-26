package orderdisplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.CommonMethod;
import common.MyColor;
import common.SetLanguage;

public class BillCostItem extends JPanel{
	
	boolean langFlag = new SetLanguage().getLang();//��� �÷���
	
	BillCostItem(String titleText, String totalText){//�ϴ� �������� ���� ȭ��
		setBackground(MyColor.subColor);
		setLayout(new GridLayout(1, 2));
		
		JLabel title = new JLabel(titleText);
		title.setFont(CommonMethod.myfont("�߰�"));
		title.setBorder(BorderFactory.createEmptyBorder(5 , 10 , 5 , 10));
		JLabel total = new JLabel(totalText);
		total.setFont(CommonMethod.myfont("�����߰�"));
		total.setBorder(BorderFactory.createEmptyBorder(5 , 10 , 5 , 10));
		
		add(title);
		add(total);
		setMaximumSize(new Dimension(620, 45));
		setPreferredSize(new Dimension(620, 45));
	}
	
	BillCostItem(String totalText){//�ϴ� �������� ū ȭ��
		setBackground(MyColor.subColor);
		setLayout(new GridLayout(1, 2));
		
		JLabel title = new JLabel(langFlag ? "Payment amount" : "���� �ݾ�");
		title.setFont(CommonMethod.myfont("�߰�ũ��"));
		title.setBorder(BorderFactory.createEmptyBorder(5 , 10 , 5 , 10));
		JLabel total = new JLabel(totalText);
		total.setForeground(Color.RED);
		total.setFont(CommonMethod.myfont("�����߰�ũ��"));
		total.setBorder(BorderFactory.createEmptyBorder(5 , 10 , 5 , 10));
		
		add(title);
		add(total);
		setMaximumSize(new Dimension(620, 55));
		setPreferredSize(new Dimension(620, 55));
	}
}
