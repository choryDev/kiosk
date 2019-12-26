package common;

import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CommonMethod {
	
	public static ImageIcon changeImgSize(String imgpath, int width,int height){
		//ImageIcon �̹��� ũ�� �׳� �ٲ� �� ���� �̹��� ũ�� �ٲ� �Լ�
		//��ü�� ���� �ʿ䰡 ���� �ٷ� �Ἥ �̹��� ũ�⸸ �ٲٱ� ���� static���� ����
		//�Ķ����(Object imgpath, int width,int height) �̹������ imgpath, �ٲ� ���� width, �ٲ� ���� height
		ImageIcon imgicon = new ImageIcon(imgpath);
		Image img = imgicon.getImage();  //ImageIcon�� Image�� ��ȯ.
		Image newimg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimgicon = new ImageIcon(newimg); //Image�� ImageIcon ����
		return newimgicon;
	}
	
	public static Font myfont(String fontsize) {
		Font customFont = null;
		
		try {
			switch(fontsize) {
			case "����" : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN TIRE_Regular.ttf")).deriveFont(60f);
			 	break;
			case "ũ��" : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN TIRE_Regular.ttf")).deriveFont(30f);
			 	break;
			case "�߰�ũ��" : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN TIRE_Regular.ttf")).deriveFont(25f);
				break;
			case "�߰�" : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN TIRE_Regular.ttf")).deriveFont(20f);
				break;
			case "�߰��۰�" : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN TIRE_Regular.ttf")).deriveFont(15f);
				break;
			case "�۰�" : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN TIRE_Regular.ttf")).deriveFont(10f);
				break;
			case "�޴� ����" : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN TIRE_Regular.ttf")).deriveFont(5f);
				break;
			case "�޴� ����" : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN TIRE_Regular.ttf")).deriveFont(30f);
				break;
			case "�����߰�ũ��" : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN_TIRE_Bold.ttf")).deriveFont(25f);
				break;
			case "�����߰�" : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN_TIRE_Bold.ttf")).deriveFont(20f);
				break;
			default : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN TIRE_Regular.ttf")).deriveFont(15f);
			}
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(customFont);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		
		return customFont;
	}
}
