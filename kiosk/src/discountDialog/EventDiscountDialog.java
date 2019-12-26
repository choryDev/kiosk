package discountDialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import common.CommonMethod;
import common.MyColor;
import component.MyBorderButton2;
import orderdisplay.BillDisplay;

public class EventDiscountDialog extends JDialog {
	public EventDiscountDialog(JFrame frame, BillDisplay parent) {
		super(frame, "할인 / 적립 할인");
		JButton btn = new JButton(new ImageIcon("images/membership/oKCashBag.jpg"));
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.memeberShipDiscountHandler(5);
				setVisible(false);
			}
		});
		setLocation(200, 100);
		add(btn);
		setSize(450, 550);
	}
}
