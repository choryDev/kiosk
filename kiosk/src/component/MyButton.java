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

public class MyButton extends JButton {//���� ���� �⺻ ��ư�Դϴ�.
	public MyButton(String string, String size) {
		setText(string); //�Ķ���ͷ� ���� ���� ����
		setBackground(MyColor.subColor); //��ư ����Դϴ�
		setForeground(MyColor.mainColor); //��ư �� �Դϴ�subColor
		setFocusPainted(false); //��Ŀ���Ǹ� ȿ���� �����ϴ�.
		setFont(CommonMethod.myfont(size)); //��ư�� ũ�⸦ ����
		setBorder(new EmptyBorder(5,3,5,3)); //�µθ��� ���� ��ư�Դϴ�
		
		addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(MyColor.subColor); //��ư ����Դϴ�
				setForeground(MyColor.mainColor); //��ư �� �Դϴ�subColor
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(MyColor.mainColor); //��ư ����Դϴ�
				setForeground(MyColor.subColor); //��ư �� �Դϴ�subColor
			}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
	}
}