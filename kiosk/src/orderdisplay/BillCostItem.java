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
	
	boolean langFlag = new SetLanguage().getLang();//언어 플래그
	
	BillCostItem(String titleText, String totalText){//하단 영수증에 작은 화면
		setBackground(MyColor.subColor);
		setLayout(new GridLayout(1, 2));
		
		JLabel title = new JLabel(titleText);
		title.setFont(CommonMethod.myfont("중간"));
		title.setBorder(BorderFactory.createEmptyBorder(5 , 10 , 5 , 10));
		JLabel total = new JLabel(totalText);
		total.setFont(CommonMethod.myfont("굵게중간"));
		total.setBorder(BorderFactory.createEmptyBorder(5 , 10 , 5 , 10));
		
		add(title);
		add(total);
		setMaximumSize(new Dimension(620, 45));
		setPreferredSize(new Dimension(620, 45));
	}
	
	BillCostItem(String totalText){//하단 영수증에 큰 화면
		setBackground(MyColor.subColor);
		setLayout(new GridLayout(1, 2));
		
		JLabel title = new JLabel(langFlag ? "Payment amount" : "결제 금액");
		title.setFont(CommonMethod.myfont("중간크게"));
		title.setBorder(BorderFactory.createEmptyBorder(5 , 10 , 5 , 10));
		JLabel total = new JLabel(totalText);
		total.setForeground(Color.RED);
		total.setFont(CommonMethod.myfont("굵게중간크게"));
		total.setBorder(BorderFactory.createEmptyBorder(5 , 10 , 5 , 10));
		
		add(title);
		add(total);
		setMaximumSize(new Dimension(620, 55));
		setPreferredSize(new Dimension(620, 55));
	}
}
