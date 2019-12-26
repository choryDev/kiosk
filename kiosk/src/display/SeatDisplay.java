package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.CommonMethod;
import common.MyColor;
import common.SetLanguage;
import component.MyBorderButton;
import component.SeatButton;
import display.IntroDisplay.ThreadTest;
import main.Main;

public class SeatDisplay extends JPanel {
	
	JLabel macot = null;
	public ThreadTest th = new ThreadTest();
	JPanel centerP = null;
	
	JPanel topSeat = null;
	JPanel centerSeat = null;
	JPanel eastSeat = null;
	
	boolean langFlag = new SetLanguage().getLang();//언어 플래그
	
	public SeatDisplay(Main root) {
		//상단 로고
		setLayout(new BorderLayout());
		JPanel header = new JPanel();
		header.setBackground(MyColor.mainColor);
		header.setLayout(null);
		ImageIcon macotimg = CommonMethod.changeImgSize("images/mascot.png", 160, 128); //이미지 크기 바꿔주기 위한 함수
		macot = new JLabel(macotimg);
		JLabel headerText = new JLabel(langFlag ? "Please choose a seat" : "자리를 선택해 주세요");
		headerText.setFont(CommonMethod.myfont("제목"));
		headerText.setBounds(200, -20, 700, 200);
		headerText.setForeground(MyColor.subColor);
		header.add(macot);
		header.add(headerText);
		header.setPreferredSize(new Dimension(920, 150));
		th.start();//마스코트가 움직이는 쓰레드
		
		//중간 자리
		centerP = new JPanel();
		centerP.setLayout(new BorderLayout(25, 25));
		centerP.setBackground(MyColor.subColor);
		
		topSeat = new JPanel();
		topSeat.setLayout(new GridLayout(2, 7, 10, 10));
		topSeat.setPreferredSize(new Dimension(920, 150));
		topSeat.setBackground(MyColor.subColor);
		for(int i = 1; i < 19; i++) {
			System.out.println(i);
			topSeat.add(new SeatButton(Integer.toString(i), "중간"));
		}
		
		centerSeat = new JPanel();
		centerSeat.setBackground(MyColor.subColor);
		centerSeat.setLayout(new GridLayout(4, 4, 10, 10));
		centerSeat.setPreferredSize(new Dimension(920, 150));
		for(int i = 15; i < 31; i++) {
			centerSeat.add(new SeatButton(Integer.toString(i), "중간"));
		}
		
		
		JPanel westSeat = new JPanel();
		westSeat.setPreferredSize(new Dimension(150, getHeight()));
		westSeat.setBackground(MyColor.subColor);
		
		eastSeat = new JPanel();
		eastSeat.setPreferredSize(new Dimension(300, getHeight()));
		eastSeat.setBackground(MyColor.subColor);
		eastSeat.setLayout(new GridLayout(4, 3, 10, 10));
		for(int i = 31; i < 43; i++) {
			eastSeat.add(new SeatButton(Integer.toString(i), "중간"));
		}
		
		centerP.add(topSeat, "North");
		centerP.add(centerSeat, "Center");
		SeatButton counter = new SeatButton(langFlag ? "counter" : "카운터",langFlag ? "중간" : "크게");
		counter.setEnabled(false);
		centerP.add(counter, "West");
		centerP.add(eastSeat, "East");
		
		//하단 버튼
		JPanel southP = new JPanel();
		southP.setBackground(MyColor.mainColor);
		southP.setLayout(new FlowLayout(FlowLayout.RIGHT)); //버튼을 둘 판넬 레이아웃 지정
		MyBorderButton completeBtn = new MyBorderButton(langFlag ? "Selected" : "선택 완료", langFlag ? "중간크게" : "크게");
		completeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				root.changeFinalDisplay();
			}
		});
		southP.add(completeBtn);
		
		add(header, "North");
		add(centerP, "Center");
		add(southP, "South");
		
		setSize(920, 800);
	}
	
	public class ThreadTest extends Thread{
	    public void run(){
	        // 인터럽트 됬을때 예외처리
	        try{
	        	while(true) {
		            for(int i = 25 ; i > 0; --i){//마스코트가 뛰는 쓰레드
		                Thread.sleep(15);
		                macot.setBounds(30, i, 160, 128);//절대값 위치 
		            }
		            for(int i = 0 ; i < 25; i++){//마스코트가 앉는 쓰레드
		                Thread.sleep(15);
		                macot.setBounds(30, i, 160, 128);//절대값 위치 
		            }
	        	}
	        }catch(InterruptedException e){
	            System.out.println(e);
	        }
	    }
	}
}
