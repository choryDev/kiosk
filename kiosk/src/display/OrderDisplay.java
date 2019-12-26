package display;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import common.MyColor;
import common.SetLanguage;
import component.MyBorderButton;
import main.Main;
import orderdisplay.OrderMainDisplay;

public class OrderDisplay extends JPanel {
	Main root;
	boolean langFlag = new SetLanguage().getLang();//언어 플래그
	public OrderDisplay(Main root){
		setBackground(MyColor.mainColor);
		setLayout(new BorderLayout());
		this.root = root;
		
		OrderMainDisplay maindisplay = new OrderMainDisplay(root);// 주문하기 윗 화면
		
		JPanel footer = new JPanel();
		footer.setBackground(MyColor.mainColor);

		add(maindisplay, "Center");
		add(footer, "South");
		
		footer.setLayout(new FlowLayout(FlowLayout.RIGHT));
		MyBorderButton cancelBtn = new MyBorderButton(langFlag ? "Previous" : "이전으로", "중간크게");

		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				root.changeMainDisplay();
				}
			});
		
		footer.add(cancelBtn);
		}
}
