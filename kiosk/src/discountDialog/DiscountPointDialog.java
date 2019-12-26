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
	static boolean langFlag = new SetLanguage().getLang();//��� �÷���
	
	public DiscountPointDialog(JFrame frame, BillDisplay parent) {
		super(frame,langFlag ? "Use Point" : "Point ���");
		this.point = parent.point; //����Ʈ�� ���̾�α׿��� ���涧���� ������� �ȵǹǷ�
		this.parent = parent;
		
		setLayout(new FlowLayout());
		setBackground(MyColor.mainColor);
		JLabel tf = new JLabel();
		tf.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		textfiled = new TextField("", 20);
		tf.setText(langFlag ? "MyPoint" : "�� ����Ʈ : "+point);
		tf.setFont(CommonMethod.myfont("�߰��۰�"));
		MyBorderButton2 btn = new MyBorderButton2(langFlag ? "Use Points" :"����Ʈ ����ϱ�", "�߰��۰�");
		btn.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		btn.setPreferredSize(new Dimension(200, 40));
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//����Ʈ ����ϱ� ���� ���� �� �Լ� Ŭ��
				parent.discountPointDialogOnclickHandler();
				point = point - Integer.parseInt(textfiled.getText());
				tf.setText(langFlag ? "MyPoint" :"�� ����Ʈ : "+point);
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
