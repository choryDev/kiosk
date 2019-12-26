package bottomBillPane;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import common.CommonMethod;
import common.MyColor;

public class AletDialog extends JDialog {
	JLabel tf = new JLabel();
	
	public AletDialog(JFrame frame, String title) {
		super(frame, title);
		setBackground(MyColor.subColor);
		tf.setText(title);
		tf.setFont(CommonMethod.myfont("Áß°£"));
		
		setLocation(400, 300);
		setLayout(new FlowLayout());
		add(tf);
		setSize(400, 100);
	}
}
