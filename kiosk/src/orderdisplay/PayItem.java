package orderdisplay;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.CommonMethod;
import common.MyColor;

public class PayItem extends JPanel {
	
	public PayItem(String title) {
		
		ImageIcon image = new ImageIcon("images/reddot.jpg");
		JLabel imageicon = new JLabel(image);
		JLabel titlelabel = new JLabel(title);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		titlelabel.setVerticalAlignment(JLabel.CENTER);
		
		titlelabel.setFont(CommonMethod.myfont("중간 작게"));
		
		setBackground(MyColor.subColor);
		
		add(imageicon);
		add(titlelabel);
	    setMaximumSize(new Dimension(300, 25));
	    setPreferredSize(new Dimension(300, 25));
		setVisible(true);
	}
}
