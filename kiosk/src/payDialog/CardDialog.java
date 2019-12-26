package payDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import common.CommonMethod;
import common.MyColor;
import common.SetLanguage;
import component.MyBorderButton2;
import orderdisplay.BillDisplay;

public class CardDialog extends JDialog {
	JPanel mainjp = null;
	JLabel card = null;
	JPanel body = null;
	JLabel headerText = null;
	MyBorderButton2 paybtn = null;
	public ThreadTest th = new ThreadTest();
	int i = 0;
	boolean flag = false;
	boolean langFlag = new SetLanguage().getLang();//언어 플래그
	
	public CardDialog(JFrame frame, BillDisplay parent, boolean takeOutChecked) {
		super(frame, "쓰레드를 이용한 카드");
		setLayout(new BorderLayout());
		mainjp = new JPanel();
		mainjp.setBackground(MyColor.subColor);
		mainjp.setLayout(new BorderLayout());
		
		JPanel header = new JPanel();//헤더 화면
		headerText = new JLabel(langFlag ? "Credit Card / Samsung / LG Pay" : "신용카드 / 삼성 / LG페이");
		headerText.setFont(CommonMethod.myfont("중간"));
		headerText.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		header.setBackground(MyColor.subColor);
		header.add(headerText);
		
		body = new JPanel();
		body.setLayout(null);
		body.setBackground(MyColor.subColor);
		card = new JLabel(new ImageIcon("images/samsungCard.png"));
		body.add(card);
		card.setBounds(700, 50, 300, 175);//절대값 위치 
		
		JPanel footer = new JPanel();
		footer.setBackground(MyColor.subColor);
		paybtn = new MyBorderButton2(langFlag ? "Insert card" : "카드 넣음", "중간");
		footer.add(paybtn);
		
		paybtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!flag) {
					InsertCard();//서명창 화면으로 전환
					flag = true;
				}else {
					setVisible(false);//마지막 화면으로 전환
					if(takeOutChecked) {
						parent.changeSeatDisplay();
					}else {
						parent.changeFianlDisplay();
					}
				}
			}
		});
		
		mainjp.add(header, "North");
		mainjp.add(body, "Center");
		mainjp.add(footer, "South");
		add(mainjp, "Center");
		setLocation(150, 150);
		setSize(700, 500);
		setVisible(true);
	}
	
	public void InsertCard() {//카드 삽입 완료 시 서명 창을 띄운다.
		headerText.setText(langFlag ? "Please press OK after signing" : "서명 후 확인을 눌러 주세요");//화면 텍스트 들도 변환
		paybtn.setText(langFlag ? "Signed" : "서명 완료");
		body.removeAll();
		SignDrawer signDrawer = new SignDrawer();//서명 창 객체 생성
		signDrawer.setSize(700, 400);
		body.add(signDrawer);
		revalidate();
		repaint();
		signDrawer.setFocusable(true);
	}
	
	public class ThreadTest extends Thread{
	    public void run(){
	        // 인터럽트 됬을때 예외처리
	        try{
	            for(i = 0 ; true; i++){
	                // 스레드 0.5초동안 대기
	                Thread.sleep(10);
	                card.setBounds(700 - i, 50, 300, 175);//절대값 위치 
	                if(i == 1000) i = 0;//한바퀴 돌은 경우
	            }
	        }catch(InterruptedException e){
	            System.out.println(e);
	        }
	    }
	}
}
