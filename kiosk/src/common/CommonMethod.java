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
		//ImageIcon 이미지 크기 그냥 바꿀 수 없어 이미지 크기 바꿀 함수
		//객체를 만들 필요가 없고 바로 써서 이미지 크기만 바꾸기 위해 static으로 선언
		//파라미터(Object imgpath, int width,int height) 이미지경로 imgpath, 바꿀 가로 width, 바꿀 세로 height
		ImageIcon imgicon = new ImageIcon(imgpath);
		Image img = imgicon.getImage();  //ImageIcon을 Image로 변환.
		Image newimg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimgicon = new ImageIcon(newimg); //Image로 ImageIcon 생성
		return newimgicon;
	}
	
	public static Font myfont(String fontsize) {
		Font customFont = null;
		
		try {
			switch(fontsize) {
			case "제목" : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN TIRE_Regular.ttf")).deriveFont(60f);
			 	break;
			case "크게" : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN TIRE_Regular.ttf")).deriveFont(30f);
			 	break;
			case "중간크게" : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN TIRE_Regular.ttf")).deriveFont(25f);
				break;
			case "중간" : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN TIRE_Regular.ttf")).deriveFont(20f);
				break;
			case "중간작게" : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN TIRE_Regular.ttf")).deriveFont(15f);
				break;
			case "작게" : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN TIRE_Regular.ttf")).deriveFont(10f);
				break;
			case "메뉴 제목" : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN TIRE_Regular.ttf")).deriveFont(5f);
				break;
			case "메뉴 설명" : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN TIRE_Regular.ttf")).deriveFont(30f);
				break;
			case "굵게중간크게" : customFont = Font.createFont(Font.TRUETYPE_FONT,
					new File("images/NEXEN_TIRE_Bold.ttf")).deriveFont(25f);
				break;
			case "굵게중간" : customFont = Font.createFont(Font.TRUETYPE_FONT,
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
