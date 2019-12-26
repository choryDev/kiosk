package orderdisplay;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import main.Main;

public class OrderMainDisplay extends JPanel {
	
	public OrderMainDisplay(Main root){
		setLayout(new BorderLayout());
		BillDisplay billDisplay = new BillDisplay(root);
		PaySelectDisplay payDisplay = new PaySelectDisplay(root, billDisplay);
		
		add(billDisplay, "Center");
		add(payDisplay, "East");
	}
}
