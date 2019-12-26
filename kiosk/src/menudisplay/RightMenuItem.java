package menudisplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import common.CommonMethod;
import common.MenuStructor;
import common.MyColor;
import common.SetLanguage;
import component.MyBorderButton;
import component.MyButton;
import component.MyButton2;

public class RightMenuItem extends JPanel {

	boolean langFlag = new SetLanguage().getLang();//언어 플래그
	
	public RightMenuItem(MenuStructor item) {
		JLabel title = new JLabel();
		title.setText(item.getMenuTitle());
		title.setFont(CommonMethod.myfont(langFlag ? "중간작게" : "중간"));
		title.setForeground(Color.DARK_GRAY);
		title.setVerticalAlignment(JLabel.CENTER);
		
		JLabel total = new JLabel();
		total.setText(Integer.toString(item.getMenuCount()));
		total.setFont(CommonMethod.myfont(langFlag ? "중간작게" : "중간"));
		total.setForeground(Color.DARK_GRAY);
		total.setVerticalAlignment(JLabel.CENTER);
		
		setBackground(MyColor.subColor);
		
		add(title);
		add(total);
	    setMaximumSize(new Dimension(200, 30));
	    setPreferredSize(new Dimension(200, 30));
		setVisible(true);
	}
	
	public RightMenuItem(int i, RightMenuDisplay parent) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel jb = new JLabel();
		jb.setText(langFlag ? i + 1 + " st bowl" : i + 1 + " 번째 그릇");
		jb.setFont(CommonMethod.myfont(langFlag ? "중간작게" : "중간"));
		jb.setForeground(Color.DARK_GRAY);
		jb.setVerticalAlignment(JLabel.CENTER);
		
		MyButton exitBtn = new MyButton("x", "중간작게");
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.totalarr.remove(i);
				parent.refleshDisplay();
			}
		});
		setBackground(MyColor.subColor);
		
		add(jb);
		add(exitBtn);
	    setMaximumSize(new Dimension(200, 30));
	    setPreferredSize(new Dimension(200, 30));
		setVisible(true);
	}
	
	public RightMenuItem(int total) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel totallabel = new JLabel();
		totallabel.setText(langFlag ? "Total : "+total+ "Won" : "총 금액 : "+total+ "원");
		totallabel.setFont(CommonMethod.myfont(langFlag ? "중간작게" : "중간"));
		totallabel.setForeground(Color.DARK_GRAY);
		totallabel.setVerticalAlignment(JLabel.CENTER);
		
		setBackground(MyColor.subColor);
		
		add(totallabel);
	    setMaximumSize(new Dimension(200, 30));
	    setPreferredSize(new Dimension(200, 30));
		setVisible(true);
	}
}
