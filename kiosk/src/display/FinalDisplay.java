package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import billTxt.BillTxt;
import common.CommonMethod;
import common.MyColor;
import common.SetLanguage;
import component.MyBorderButton;
import main.Main;

public class FinalDisplay extends JPanel {
	Main root;
	public FinalDisplay(Main root){
		int ordernum = (int)(Math.random() * 600);
		new BillTxt(ordernum, root);
		
		setBackground(MyColor.subColor);
		setLayout(new GridLayout(3, 1));
		this.root = root; //ȭ�� ������ ���� �θ�ü �޾ƿ�
		JPanel header = new JPanel();
		header.setBackground(MyColor.subColor);
		ImageIcon mainimg = CommonMethod.changeImgSize("images/logoReverse.png", 417, 121); //�̹��� ũ�� �ٲ��ֱ� ���� �Լ�
		JLabel logolabel = new JLabel(mainimg);
		header.setLayout(new BorderLayout());
		header.add(logolabel, BorderLayout.CENTER);
		header.setLocation(100, 300);
		
		JPanel body = new JPanel();
		JLabel title = new JLabel(
				(new SetLanguage().getLang() ? "Order Number" : "�ֹ���ȣ ") +Integer.toString(ordernum));//�ֹ���ȣ
		JPanel footer = new JPanel();
		footer.setLayout(new GridLayout(2, 1));
		JLabel info = new JLabel("�������� ������ src ���� ���� �ֽ��ϴ�.");
		body.setBackground(MyColor.subColor);
		footer.setBackground(MyColor.subColor);
		title.setFont(CommonMethod.myfont("ũ��"));
		title.setHorizontalAlignment(JLabel.CENTER);
		info.setFont(CommonMethod.myfont("�߰�ũ��"));
		info.setHorizontalAlignment(JLabel.CENTER);
		body.setLayout(new GridLayout(3, 1));
		
		body.add(title);
		body.add(info);
		
		add(header);
		add(body);
		}
}
