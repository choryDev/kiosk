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
		this.root = root; //화면 변경을 위해 부모객체 받아옴
		JPanel header = new JPanel();
		header.setBackground(MyColor.subColor);
		ImageIcon mainimg = CommonMethod.changeImgSize("images/logoReverse.png", 417, 121); //이미지 크기 바꿔주기 위한 함수
		JLabel logolabel = new JLabel(mainimg);
		header.setLayout(new BorderLayout());
		header.add(logolabel, BorderLayout.CENTER);
		header.setLocation(100, 300);
		
		JPanel body = new JPanel();
		JLabel title = new JLabel(
				(new SetLanguage().getLang() ? "Order Number" : "주문번호 ") +Integer.toString(ordernum));//주문번호
		JPanel footer = new JPanel();
		footer.setLayout(new GridLayout(2, 1));
		JLabel info = new JLabel("영수증은 폴더로 src 들어가서 보면 있습니다.");
		body.setBackground(MyColor.subColor);
		footer.setBackground(MyColor.subColor);
		title.setFont(CommonMethod.myfont("크게"));
		title.setHorizontalAlignment(JLabel.CENTER);
		info.setFont(CommonMethod.myfont("중간크게"));
		info.setHorizontalAlignment(JLabel.CENTER);
		body.setLayout(new GridLayout(3, 1));
		
		body.add(title);
		body.add(info);
		
		add(header);
		add(body);
		}
}
