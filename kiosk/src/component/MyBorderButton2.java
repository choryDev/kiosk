package component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.border.Border;

import common.CommonMethod;
import common.MyColor;

public class MyBorderButton2 extends JButton {
	public MyBorderButton2(String string, String size) {

		setText(string);
		setBackground(MyColor.subColor);
		setForeground(MyColor.mainColor);
		setFocusPainted(false);
		setBorder(new RoundedBorder(10));
		setFont(CommonMethod.myfont(size));
		setPreferredSize(new Dimension(280, 40));
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