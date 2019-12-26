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
	String barcodeNumber = " ";//���ڵ� ��ȣ
	int i = 60;
	int numbtn = 0;
	static boolean langFlag = new SetLanguage().getLang();//��� �÷���
	
	public BarcodeDialog(JFrame frame, BillDisplay parent, boolean takeOutChecked) {
		super(frame, (langFlag ? "Mobile coupon barcode" : "����� ���� ���ڵ�"));
		setLayout(new BorderLayout());
		JPanel mainjp = new JPanel();
		mainjp.setBackground(MyColor.subColor);
		mainjp.setLayout(new BorderLayout());
		
		JPanel header = new JPanel();//��� ȭ��
		JLabel headerText = new JLabel
				(langFlag ? "Please enter barcode number and barcode number as follows."
						: "�Ʒ��� ���� ������� ���ڵ� �ν� �� ���ڵ��ȣ�� �Է��� �ּ���");
		headerText.setFont(CommonMethod.myfont("�߰�"));
		headerText.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		header.setBackground(MyColor.subColor);
		header.add(headerText);
		
		JPanel body = new JPanel();
		body.setLayout(new GridLayout(1, 2));
		JLabel jlabel = new JLabel(new ImageIcon("images/barcod.png"));//��� �� ������
		JPanel numberPanel = new JPanel();
		numberPanel.setBackground(MyColor.subColor);
		numberPanel.setLayout(new BorderLayout());
		
		displayNumber = new JLabel();//��ȣ�� ��Ÿ�� ȭ��
		displayNumber.setFont(CommonMethod.myfont("�߰�ũ��"));
		displayNumber.setBackground(MyColor.subColor);
		numberPanel.add(displayNumber, "North");
		
		JPanel pad = new JPanel();//��ȣ�� ĥ Ű�е� ȭ��
		pad.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pad.setLayout(new GridLayout(3, 3, 5, 5));
		pad.setBackground(MyColor.subColor);
		numberBtn = new MyBorderButton2[9];
		for(int i = 0; i < 9; i++) {
			numberBtn[i] = new MyBorderButton2(Integer.toString(i + 1), "�߰�");
			pad.add(numberBtn[i]);
		}
		actionBtn();//��ư�� �׼� �̺�Ʈ�� ���� �޽��
		
		numberPanel.add(pad, "Center");
		body.add(jlabel);
		body.add(numberPanel);
		
		//�ϴ� ��ư �κ� ���ѽð��� ��Ÿ���� �ִ�
		JPanel footer = new JPanel(); //���ѽð� ���δ� �ǳ�
		footer.setLayout(new GridLayout(2, 1));
		footer.setBackground(MyColor.subColor);
		MyBorderButton2 paybtn = new MyBorderButton2(langFlag ? "Complete input" : "�Է� �Ϸ�", "�߰�");//��ư
		JPanel timerPanel = new JPanel();
		JLabel timerInfo = new JLabel(langFlag ? "Payable time" : "���� ���ɽð� ");//����
		timer = new JLabel(Integer.toString(i));
		timerPanel.setBackground(MyColor.subColor);
		timerInfo.setFont(CommonMethod.myfont("�߰� �۰�"));
		timer.setFont(CommonMethod.myfont("�����߰�"));
		timer.setForeground(Color.RED);
		timerPanel.add(timerInfo);
		timerPanel.add(timer);

		footer.add(paybtn);
		footer.add(timerPanel);
		paybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//�ֹ� ȭ������ ����
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
	
	public class ThreadTest extends Thread{//���� ī��Ʈ ������
	    public void run(){
	        // ���ͷ�Ʈ ������ ����ó��
	        try{
	            for(i = 60 ; i > 0; i--){
	                // ������ 0.5�ʵ��� ���
	                Thread.sleep(1000);
	                timer.setText(Integer.toString(i));
	                if(i == 1000) i = 0;
	            }
	        }catch(InterruptedException e){
	            System.out.println(e);
	        }
	    }
	}
	
	public void actionBtn() {//�̺�Ʈ ���� ���������� ���� �ٲ�� �ȵǼ� ��¿ �� ���� �̷��� ��ư �̺�Ʈ ����
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
