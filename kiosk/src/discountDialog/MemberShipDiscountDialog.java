package discountDialog;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import orderdisplay.BillDisplay;

public class MemberShipDiscountDialog extends JDialog {
	public MemberShipDiscountDialog(JFrame frame, BillDisplay parent) {
		super(frame, "제휴사 할인");
		setLocation(400, 300);
		setLayout(new GridLayout(2,2));
		
		JButton btn1 = new JButton(new ImageIcon("images/membership/member1.png"));
		JButton btn2 = new JButton(new ImageIcon("images/membership/member2.png"));
		JButton btn3 = new JButton(new ImageIcon("images/membership/member3.png"));
		JButton btn4 = new JButton(new ImageIcon("images/membership/member4.png"));
		
		btn1.addActionListener(new ActionListener() {
			@Override //5프로 할인
			public void actionPerformed(ActionEvent e) {
				parent.memeberShipDiscountHandler(5);
			}
		});
		btn2.addActionListener(new ActionListener() {
			@Override //10프로 할인
			public void actionPerformed(ActionEvent e) {
				parent.memeberShipDiscountHandler(10);
			}
		});
		btn3.addActionListener(new ActionListener() {
			@Override //30프로 할인
			public void actionPerformed(ActionEvent e) {
				parent.memeberShipDiscountHandler(30);
			}
		});
		btn4.addActionListener(new ActionListener() {
			@Override //20프로 할인
			public void actionPerformed(ActionEvent e) {
				parent.memeberShipDiscountHandler(20);
			}
		});
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		
		setSize(500, 500);
	}
}
