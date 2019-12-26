package discountDialog;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import common.CommonMethod;
import common.MyColor;
import common.SetLanguage;
import component.MyBorderButton2;
import orderdisplay.BillDisplay;

public class DiscountPointDialog extends JDialog {
	
	int point = 0;
	TextField textfiled = null;
	BillDisplay parent = null;
	static boolean langFlag = new SetLanguage().getLang();//언어 플래그
	
	public DiscountPointDialog(JFrame frame, BillDisplay parent) {
		super(frame,langFlag ? "Use Point" : "Point 사용");
		this.point = parent.point; //포인트가 다이얼로그에서 생길때마다 사라지면 안되므로
		this.parent = parent;
		
		setLayout(new FlowLayout());
		setBackground(MyColor.mainColor);
		JLabel tf = new JLabel();
		tf.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		textfiled = new TextField("", 20);
		tf.setText(langFlag ? "MyPoint" : "내 포인트 : "+point);
		tf.setFont(CommonMethod.myfont("중간작게"));
		MyBorderButton2 btn = new MyBorderButton2(langFlag ? "Use Points" :"포인트 사용하기", "중간작게");
		btn.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		btn.setPreferredSize(new Dimension(200, 40));
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//포인트 사용하기 위해 할인 할 함수 클릭
				parent.discountPointDialogOnclickHandler();
				point = point - Integer.parseInt(textfiled.getText());
				tf.setText(langFlag ? "MyPoint" :"내 포인트 : "+point);
				textfiled.setText("");
			}
		});
		
		setLocation(400, 300);
		add(tf);
		add(textfiled);
		add(btn);
		setSize(300, 160);
	}
	
	public int textFieldValue() {
		return Integer.parseInt(textfiled.getText());
	}
}
