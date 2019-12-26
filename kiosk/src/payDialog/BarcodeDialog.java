package payDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.CommonMethod;
import common.MyColor;
import common.SetLanguage;
import component.MyBorderButton2;
import orderdisplay.BillDisplay;

public class BarcodeDialog extends JDialog {
	JLabel displayNumber = null;
	JLabel timer = null;
	MyBorderButton2 numberBtn[] = null;
	public ThreadTest th = new ThreadTest();
	String barcodeNumber = " ";//바코드 번호
	int i = 60;
	int numbtn = 0;
	static boolean langFlag = new SetLanguage().getLang();//언어 플래그
	
	public BarcodeDialog(JFrame frame, BillDisplay parent, boolean takeOutChecked) {
		super(frame, (langFlag ? "Mobile coupon barcode" : "모바일 쿠폰 바코드"));
		setLayout(new BorderLayout());
		JPanel mainjp = new JPanel();
		mainjp.setBackground(MyColor.subColor);
		mainjp.setLayout(new BorderLayout());
		
		JPanel header = new JPanel();//헤더 화면
		JLabel headerText = new JLabel
				(langFlag ? "Please enter barcode number and barcode number as follows."
						: "아래와 같은 방법으로 바코드 인식 및 바코드번호를 입력해 주세요");
		headerText.setFont(CommonMethod.myfont("중간"));
		headerText.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		header.setBackground(MyColor.subColor);
		header.add(headerText);
		
		JPanel body = new JPanel();
		body.setLayout(new GridLayout(1, 2));
		JLabel jlabel = new JLabel(new ImageIcon("images/barcod.png"));//사람 손 아이콘
		JPanel numberPanel = new JPanel();
		numberPanel.setBackground(MyColor.subColor);
		numberPanel.setLayout(new BorderLayout());
		
		displayNumber = new JLabel();//번호가 나타날 화면
		displayNumber.setFont(CommonMethod.myfont("중간크게"));
		displayNumber.setBackground(MyColor.subColor);
		numberPanel.add(displayNumber, "North");
		
		JPanel pad = new JPanel();//번호를 칠 키패드 화면
		pad.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pad.setLayout(new GridLayout(3, 3, 5, 5));
		pad.setBackground(MyColor.subColor);
		numberBtn = new MyBorderButton2[9];
		for(int i = 0; i < 9; i++) {
			numberBtn[i] = new MyBorderButton2(Integer.toString(i + 1), "중간");
			pad.add(numberBtn[i]);
		}
		actionBtn();//버튼의 액션 이벤트를 담은 메써드
		
		numberPanel.add(pad, "Center");
		body.add(jlabel);
		body.add(numberPanel);
		
		//하단 버튼 부분 제한시간을 나타내고 있다
		JPanel footer = new JPanel(); //제한시간 감싸는 판넬
		footer.setLayout(new GridLayout(2, 1));
		footer.setBackground(MyColor.subColor);
		MyBorderButton2 paybtn = new MyBorderButton2(langFlag ? "Complete input" : "입력 완료", "중간");//버튼
		JPanel timerPanel = new JPanel();
		JLabel timerInfo = new JLabel(langFlag ? "Payable time" : "결제 가능시간 ");//글자
		timer = new JLabel(Integer.toString(i));
		timerPanel.setBackground(MyColor.subColor);
		timerInfo.setFont(CommonMethod.myfont("중간 작게"));
		timer.setFont(CommonMethod.myfont("굵게중간"));
		timer.setForeground(Color.RED);
		timerPanel.add(timerInfo);
		timerPanel.add(timer);

		footer.add(paybtn);
		footer.add(timerPanel);
		paybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//주문 화면으로 간다
				setVisible(false);
				if(takeOutChecked) {
					parent.changeSeatDisplay();
				}else {
					parent.changeFianlDisplay();
				}
			}
		});
		mainjp.add(header, "North");
		mainjp.add(body, "Center");
		mainjp.add(footer, "South");
		add(mainjp, "Center");
		setLocation(150, 150);
		setSize(700, 520);
		setVisible(true);
	}
	
	public class ThreadTest extends Thread{//숫자 카운트 쓰레드
	    public void run(){
	        // 인터럽트 됬을때 예외처리
	        try{
	            for(i = 60 ; i > 0; i--){
	                // 스레드 0.5초동안 대기
	                Thread.sleep(1000);
	                timer.setText(Integer.toString(i));
	                if(i == 1000) i = 0;
	            }
	        }catch(InterruptedException e){
	            System.out.println(e);
	        }
	    }
	}
	
	public void actionBtn() {//이벤트 안의 지역변수는 값이 바뀌면 안되서 어쩔 수 없이 이렇게 버튼 이벤트 닮음
		numberBtn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				barcodeNumber = barcodeNumber.concat(Integer.toString(1));
				displayNumber.setText(barcodeNumber);
			}
		});
		numberBtn[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				barcodeNumber = barcodeNumber.concat(Integer.toString(2));
				displayNumber.setText(barcodeNumber);
			}
		});
		numberBtn[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				barcodeNumber = barcodeNumber.concat(Integer.toString(3));
				displayNumber.setText(barcodeNumber);
			}
		});
		numberBtn[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				barcodeNumber = barcodeNumber.concat(Integer.toString(4));
				displayNumber.setText(barcodeNumber);
			}
		});
		numberBtn[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				barcodeNumber = barcodeNumber.concat(Integer.toString(5));
				displayNumber.setText(barcodeNumber);
			}
		});
		numberBtn[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				barcodeNumber = barcodeNumber.concat(Integer.toString(6));
				displayNumber.setText(barcodeNumber);
			}
		});
		numberBtn[6].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				barcodeNumber = barcodeNumber.concat(Integer.toString(7));
				displayNumber.setText(barcodeNumber);
			}
		});
		numberBtn[7].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				barcodeNumber = barcodeNumber.concat(Integer.toString(8));
				displayNumber.setText(barcodeNumber);
			}
		});
		numberBtn[8].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				barcodeNumber = barcodeNumber.concat(Integer.toString(9));
				displayNumber.setText(barcodeNumber);
			}
		});

	}
}
