package menudisplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Currency;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import bottomBillPane.BottomBillDisplay;
import common.BillObject;
import common.CommonMethod;
import common.MenuStructor;
import common.MyColor;

public class MenuItemDisplay extends JPanel {
	public MenuItemDisplay(MenuStructor getItem, BottomBillDisplay billPane) {
		
		setLayout(new BorderLayout());
		
		ImageIcon mainimg = new ImageIcon(getItem.getMenuImg());
		JPanel descripPanel = new JPanel();
		
		JLabel image = new JLabel(mainimg);
		JLabel title = new JLabel("SOUTH", SwingConstants.CENTER);
		JLabel price = new JLabel("CENTER", SwingConstants.CENTER);
		BillObject billObject = new BillObject();
		
		descripPanel.setBackground(MyColor.subColor);
		descripPanel.setPreferredSize(new Dimension(160, 60));
		descripPanel.setLayout(new GridLayout(2, 1));
		
		title.setText(getItem.getMenuTitle());
		price.setText(""+getItem.getMenuPrice());
		title.setFont(CommonMethod.myfont("�߰�"));
		price.setFont(CommonMethod.myfont("�۰�"));
		title.setForeground(Color.DARK_GRAY);
		price.setForeground(Color.DARK_GRAY);
		
		descripPanel.add(title);
		descripPanel.add(price);
		
		add(image, "Center");
		add(descripPanel, "South");
		this.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				title.setFont(CommonMethod.myfont("�߰�"));
				price.setFont(CommonMethod.myfont("�۰�"));
				setBackground(MyColor.subColor);
				descripPanel.setBackground(MyColor.subColor);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				title.setFont(CommonMethod.myfont("�߰�ũ��"));
				price.setFont(CommonMethod.myfont("�߰��۰�"));
				setBackground(MyColor.subColor2);
				descripPanel.setBackground(MyColor.subColor2);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				//billObject.addBill(getItem);
				billPane.changeDisplay(getItem);
			}
		});
		
		setBackground(MyColor.subColor);
		setPreferredSize(new Dimension(173, 224));
		setVisible(true);
	}
}