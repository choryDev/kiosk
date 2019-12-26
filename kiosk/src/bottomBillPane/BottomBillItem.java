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
	boolean langFlag = new SetLanguage().getLang();//��� �÷���
	
	public BottomBillItem(MenuStructor getItem, BottomBillDisplay parent) {
	this.parent = parent;
	setLayout(new GridLayout(1, 4));
	setBackground(MyColor.mainColor);
	
	MatteBorder border = new MatteBorder(5,10,0,10,MyColor.mainColor);
    setBorder(border);
    
	title.setFont(CommonMethod.myfont(langFlag ? "�߰��۰�" : "�߰�"));
	price.setFont(CommonMethod.myfont(langFlag ? "�߰��۰�" : "�߰�"));
	total.setFont(CommonMethod.myfont(langFlag ? "�߰��۰�" : "�߰�"));
	labeloption.setFont(CommonMethod.myfont(langFlag ? "�߰��۰�" : "�߰�"));
	labeloption.setHorizontalAlignment(JLabel.CENTER);
	paneoption.setLayout(new GridLayout(1, 4));
	paneoption.setBackground(MyColor.mainColor);
	MyButton2 addBtn = new MyButton2("+", "ũ��");	
	MyButton2 minusBtn = new MyButton2("-", "ũ��");
	
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
			if(getItem.minusMenu()) {//������ ������ 1������ �Ǵ� 1���̸� ����
				removeAll();
				title.setText(getItem.getMenuTitle());
				price.setText(""+getItem.getMenuPrice());
				labeloption.setText(""+getItem.getMenuCount());
				total.setText(""+getItem.getMenuTotal());
				refleshMenu();//�޴� �������� ȭ�� ���ΰ�ħ
			}else {
				parent.billObject.delete1UnderBill(getItem);
				parent.refleshDisplay();//�θ� ȭ���� ���� ��ħ
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
	//���� layout�� ������ ������ ���� �� ������Ʈ�� ũ�Ⱑ ��� �ٲ� ũ�⸦ �������� �ֱ� ���ؼ�
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
	title.setText(langFlag ? "Title" : "����");
	price.setText(langFlag ? "Price" : "����");
	total.setText(langFlag ? "a lump sum" : "�� �ݾ�");
	labeloption.setText(langFlag ? "opt" : "�ɼ�");
	title.setFont(CommonMethod.myfont(langFlag ? "�߰��۰�" : "�߰�"));
	price.setFont(CommonMethod.myfont(langFlag ? "�߰��۰�" : "�߰�"));
	labeloption.setFont(CommonMethod.myfont(langFlag ? "�߰��۰�" : "�߰�"));
	total.setFont(CommonMethod.myfont(langFlag ? "�߰��۰�" : "�߰�"));
	
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