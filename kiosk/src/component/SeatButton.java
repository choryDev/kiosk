package component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.border.Border;

import common.CommonMethod;
import common.MyColor;

public class SeatButton extends JButton {
	boolean flag = false;
	
	public SeatButton(String string, String size) {
		setText(string);
		setBackground(MyColor.subColor);
		setForeground(MyColor.mainColor);
		setFocusPainted(false);
		setBorder(new RoundedBorder(10));
		setFont(CommonMethod.myfont(size));
		setPreferredSize(new Dimension(140, 40));
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(flag) {
					flag = false;
					setBackground(MyColor.subColor);
					setForeground(MyColor.mainColor);
				}else {
					flag = true;
					setBackground(MyColor.mainColor);
					setForeground(MyColor.subColor);
				}
			}
		});
	}
	
	private static class RoundedBorder implements Border {

	    private int radius;

	    RoundedBorder(int radius) {
	        this.radius = radius;
	    }

	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	    }

	    public boolean isBorderOpaque() {
	        return true;
	    }

	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
	    }
	}
}