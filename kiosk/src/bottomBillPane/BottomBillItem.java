package bottomBillPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import common.CommonMethod;
import common.MenuStructor;
import common.MyColor;
import common.SetLanguage;
import component.MyButton;
import component.MyButton2;

public class BottomBillItem extends JPanel {
	
	JLabel title = new JLabel();
	JLabel price = new JLabel();
	JLabel total = new JLabel();
	JLabel labeloption = new JLabel();
	JPanel paneoption = new JPanel();
	BottomBillDisplay parent;
	boolean langFlag = new SetLanguage().getLang();//언어 플래그
	
	public BottomBillItem(MenuStructor getItem, BottomBillDisplay parent) {
	this.parent = parent;
	setLayout(new GridLayout(1, 4));
	setBackground(MyColor.mainColor);
	
	MatteBorder border = new MatteBorder(5,10,0,10,MyColor.mainColor);
    setBorder(border);
    
	title.setFont(CommonMethod.myfont(langFlag ? "중간작게" : "중간"));
	price.setFont(CommonMethod.myfont(langFlag ? "중간작게" : "중간"));
	total.setFont(CommonMethod.myfont(langFlag ? "중간작게" : "중간"));
	labeloption.setFont(CommonMethod.myfont(langFlag ? "중간작게" : "중간"));
	labeloption.setHorizontalAlignment(JLabel.CENTER);
	paneoption.setLayout(new GridLayout(1, 4));
	paneoption.setBackground(MyColor.mainColor);
	MyButton2 addBtn = new MyButton2("+", "크게");	
	MyButton2 minusBtn = new MyButton2("-", "크게");
	
	addBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			getItem.addMenu();
			removeAll();
			title.setText(getItem.getMenuTitle());
			price.setText(""+getItem.getMenuPrice());
			labeloption.setText(""+getItem.getMenuCount());
			total.setText(""+getItem.getMenuTotal());
			refleshMenu();
		}
	});
	
	minusBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(getItem.minusMenu()) {//마지막 객수가 1개인지 판단 1밑이면 삭제
				removeAll();
				title.setText(getItem.getMenuTitle());
				price.setText(""+getItem.getMenuPrice());
				labeloption.setText(""+getItem.getMenuCount());
				total.setText(""+getItem.getMenuTotal());
				refleshMenu();//메뉴 아이템의 화면 새로고침
			}else {
				parent.billObject.delete1UnderBill(getItem);
				parent.refleshDisplay();//부모 화면을 새로 고침
			}
		}
	});
	
	title.setText(getItem.getMenuTitle());
	price.setText(""+getItem.getMenuPrice());
	labeloption.setText(""+getItem.getMenuCount());
	total.setText(""+getItem.getMenuTotal());
	
	paneoption.add(addBtn);
	paneoption.add(labeloption);
	paneoption.add(minusBtn);
	
	add(title);
	add(price);
	add(paneoption);
	add(total);
	//상위 layout이 아이템 갯수에 따라 이 컴포넌트의 크기가 계속 바뀌어서 크기를 고정시켜 주기 위해서
    setMaximumSize(new Dimension(590, 40));
    setMinimumSize(new Dimension(590, 40));
    setPreferredSize(new Dimension(590, 40));
	}
	
	public BottomBillItem() {
		
	setLayout(new GridLayout(1, 4));
	setBackground(MyColor.mainColor);

	MatteBorder border = new MatteBorder( 5, 10, 5, 140, MyColor.mainColor);
    setBorder(border);
	
	paneoption.setLayout(new GridLayout(1, 4));
	paneoption.setBackground(MyColor.mainColor);
	paneoption.add(new JLabel());
	paneoption.add(labeloption);
	labeloption.setHorizontalAlignment(JLabel.CENTER);
	paneoption.add(new JLabel());
	title.setText(langFlag ? "Title" : "제목");
	price.setText(langFlag ? "Price" : "가격");
	total.setText(langFlag ? "a lump sum" : "총 금액");
	labeloption.setText(langFlag ? "opt" : "옵션");
	title.setFont(CommonMethod.myfont(langFlag ? "중간작게" : "중간"));
	price.setFont(CommonMethod.myfont(langFlag ? "중간작게" : "중간"));
	labeloption.setFont(CommonMethod.myfont(langFlag ? "중간작게" : "중간"));
	total.setFont(CommonMethod.myfont(langFlag ? "중간작게" : "중간"));
	
	add(title);
	add(price);
	add(paneoption);
	add(total);
	}
	
	public void refleshMenu() {
		add(title);
		add(price);
		add(paneoption);
		add(total);
		revalidate();
		repaint();
	}
}