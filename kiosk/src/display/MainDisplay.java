package display;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import common.MyColor;
import main.Main;
import menudisplay.MainMenuDisplay;
import menudisplay.RightMenuDisplay;

public class MainDisplay extends JPanel {
	Main root;
	public MainDisplay(Main root) {
		this.root = root;
		
		setBackground(MyColor.mainColor);
		setLayout(new BorderLayout());
		
		RightMenuDisplay rigfht_dis = new RightMenuDisplay(root);
		MainMenuDisplay bibm_dis = new MainMenuDisplay(root, rigfht_dis);

		add(bibm_dis, "Center");
		add(rigfht_dis, "East");

		setSize(920, 800);
	}
}
