package component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import common.CommonMethod;
import common.MyColor;

public class MyButton2 extends JButton {//���� ���� �⺻ ��ư�Դϴ�.
	public MyButton2(String string, String size) {
		setText(string); //�Ķ���ͷ� ���� ���� ����
		setBackground(MyColor.mainColor); //��ư ����Դϴ�
		setForeground(MyColor.subColor); //��ư �� �Դϴ�
		setFocusPainted(false); //��Ŀ���Ǹ� ȿ���� �����ϴ�.
		setFont(CommonMethod.myfont(size)); //��ư�� ũ�⸦ ����
		setBorder(new EmptyBorder(5,3,5,3)); //�µθ��� ���� ��ư�Դϴ�
	}
}
