package component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import common.CommonMethod;
import common.MyColor;

public class MyButton extends JButton {//제가 만든 기본 버튼입니다.
	public MyButton(String string, String size) {
		setText(string); //파라미터로 받은 글자 전달
		setBackground(MyColor.subColor); //버튼 배경입니다
		setForeground(MyColor.mainColor); //버튼 색 입니다subColor
		setFocusPainted(false); //포커스되면 효과를 날립니다.
		setFont(CommonMethod.myfont(size)); //버튼의 크기를 정함
		setBorder(new EmptyBorder(5,3,5,3)); //태두리가 없는 버튼입니다
		
		addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(MyColor.subColor); //버튼 배경입니다
				setForeground(MyColor.mainColor); //버튼 색 입니다subColor
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(MyColor.mainColor); //버튼 배경입니다
				setForeground(MyColor.subColor); //버튼 색 입니다subColor
			}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
	}
}