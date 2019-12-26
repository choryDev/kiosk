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
	boolean langFlag = new SetLanguage().getLang();//��� �÷���
	
	public CardDialog(JFrame frame, BillDisplay parent, boolean takeOutChecked) {
		super(frame, "�����带 �̿��� ī��");
		setLayout(new BorderLayout());
		mainjp = new JPanel();
		mainjp.setBackground(MyColor.subColor);
		mainjp.setLayout(new BorderLayout());
		
		JPanel header = new JPanel();//��� ȭ��
		headerText = new JLabel(langFlag ? "Credit Card / Samsung / LG Pay" : "�ſ�ī�� / �Ｚ / LG����");
		headerText.setFont(CommonMethod.myfont("�߰�"));
		headerText.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		header.setBackground(MyColor.subColor);
		header.add(headerText);
		
		body = new JPanel();
		body.setLayout(null);
		body.setBackground(MyColor.subColor);
		card = new JLabel(new ImageIcon("images/samsungCard.png"));
		body.add(card);
		card.setBounds(700, 50, 300, 175);//���밪 ��ġ 
		
		JPanel footer = new JPanel();
		footer.setBackground(MyColor.subColor);
		paybtn = new MyBorderButton2(langFlag ? "Insert card" : "ī�� ����", "�߰�");
		footer.add(paybtn);
		
		paybtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!flag) {
					InsertCard();//����â ȭ������ ��ȯ
					flag = true;
				}else {
					setVisible(false);//������ ȭ������ ��ȯ
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
	
	public void InsertCard() {//ī�� ���� �Ϸ� �� ���� â�� ����.
		headerText.setText(langFlag ? "Please press OK after signing" : "���� �� Ȯ���� ���� �ּ���");//ȭ�� �ؽ�Ʈ �鵵 ��ȯ
		paybtn.setText(langFlag ? "Signed" : "���� �Ϸ�");
		body.removeAll();
		SignDrawer signDrawer = new SignDrawer();//���� â ��ü ����
		signDrawer.setSize(700, 400);
		body.add(signDrawer);
		revalidate();
		repaint();
		signDrawer.setFocusable(true);
	}
	
	public class ThreadTest extends Thread{
	    public void run(){
	        // ���ͷ�Ʈ ������ ����ó��
	        try{
	            for(i = 0 ; true; i++){
	                // ������ 0.5�ʵ��� ���
	                Thread.sleep(10);
	                card.setBounds(700 - i, 50, 300, 175);//���밪 ��ġ 
	                if(i == 1000) i = 0;//�ѹ��� ���� ���
	            }
	        }catch(InterruptedException e){
	            System.out.println(e);
	        }
	    }
	}
}
