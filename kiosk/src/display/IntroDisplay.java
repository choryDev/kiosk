package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.CommonMethod;
import common.MyColor;
import common.SetLanguage;
import component.MyBorderButton;
import main.Main;
import payDialog.CardDialog.ThreadTest;

public class IntroDisplay extends JPanel {
	Main root;
	JLabel macot = null;
	public ThreadTest th = new ThreadTest();
	
	public IntroDisplay(Main root){
		setBackground(MyColor.mainColor);
		
		setLayout(new GridLayout(3, 1)); //ȭ���� 3������� ������ �׸��� ���̾ƿ�
		this.root = root; //ȭ�� ������ ���� �θ�ü �޾ƿ�
		JPanel header = new JPanel();
		header.setBackground(MyColor.mainColor);
		header.setLayout(null);
		ImageIcon macotimg = CommonMethod.changeImgSize("images/mascot.png", 160, 128); //�̹��� ũ�� �ٲ��ֱ� ���� �Լ�
		macot = new JLabel(macotimg);
		JLabel headerText = new JLabel("Ŀ���� �����");
		headerText.setFont(CommonMethod.myfont("����"));
		headerText.setBounds(300, 40, 400, 200);
		headerText.setForeground(MyColor.subColor);
		header.add(macot);
		header.add(headerText);

		th.start();//������Ʈ�� �����̴� ������
		
		ImageIcon bibibbab = CommonMethod.changeImgSize("images/bibibab.jpg", 500, 300); //�̹��� ũ�� �ٲ��ֱ� ���� �Լ�
		JLabel body = new JLabel(bibibbab);
		body.setSize(500, 500);
		
		JPanel footer = new JPanel();
		footer.setBackground(MyColor.mainColor);
		footer.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 80)); //��ư�� �� �ǳ� ���̾ƿ� ����
		
		add(header);
		add(body);
		add(footer);
		MyBorderButton koreanBtn = new MyBorderButton("�� �� ��", "ũ��");
		MyBorderButton englishBtn = new MyBorderButton("English", "ũ��");
		koreanBtn.setMargin(new Insets(0, 0, 100, 100));
		
		koreanBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SetLanguage().setKorean();
				root.changeMainDisplay();
				}
			});
		
		englishBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SetLanguage().setEnglish();
				root.changeMainDisplay();
				}
			});
		
		footer.add(koreanBtn);
		footer.add(englishBtn);
		}
	public class ThreadTest extends Thread{
	    public void run(){
	        // ���ͷ�Ʈ ������ ����ó��
	        try{
	        	while(true) {
		            for(int i = 110 ; i > 20; --i){//������Ʈ�� �ٴ� ������
		                Thread.sleep(8);
		                macot.setBounds(110, i, 160, 128);//���밪 ��ġ 
		            }
		            Thread.sleep(20);
		            for(int i = 20 ; i < 110; i++){//������Ʈ�� �ɴ� ������
		                Thread.sleep(8);
		                macot.setBounds(110, i, 160, 128);//���밪 ��ġ 
		            }
	        	}
	        }catch(InterruptedException e){
	            System.out.println(e);
	        }
	    }
	}
}