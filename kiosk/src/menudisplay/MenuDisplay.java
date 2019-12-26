package menudisplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import bottomBillPane.BottomBillDisplay;
import common.CommonMethod;
import common.MenuStructor;
import common.MyColor;
import common.SetLanguage;
import component.MyButton;
	public class MenuDisplay extends JPanel {
		
		MenuItemDisplay[] s = null;
		MenuStructor[] getItem;
		int pageCounter = 0;
		BottomBillDisplay billPane; //������ Ŭ���� ���� ��ü�� �����ϱ� ���ؼ� ����
		
		public MenuDisplay(MenuStructor[] item, BottomBillDisplay billPane){
			this.billPane = billPane;
			this.getItem = item;
			s = new MenuItemDisplay [this.getItem.length];
			setLayout(new BorderLayout());
			
			JPanel mainPanel = new JPanel();
			JPanel btnPanel = new JPanel();
			
			MyButton nextBtn = new MyButton("=>", "�߰�");	
			MyButton preBtn = new MyButton("<=", "�߰�");
			JLabel pageLabel = new JLabel();
			pageLabel.setForeground(MyColor.mainColor);
			pageLabel.setFont(CommonMethod.myfont("�߰�"));
			pageLabel.setText( Integer.toString(pageCounter + 1));
			
			mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			mainPanel.setBackground(MyColor.mainColor);
			setMenu(mainPanel);
			btnPanel.setBackground(MyColor.subColor);
			
			preBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(pageCounter == 0) return;
					 //1�������̸� ������ ���� �� ��� ����
					int pageTempCount = --pageCounter; //������ 1ĭ ����
					pageCounter = pageTempCount;
					mainPanel.removeAll();
					btnPanel.removeAll();
					pageLabel.setText( Integer.toString(pageCounter + 1));
					btnPanel.add(preBtn);
					btnPanel.add(pageLabel);
					btnPanel.add(nextBtn);
					setMenu(mainPanel);
			        revalidate();
			        repaint();
					}
				});
			
			nextBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(getItem.length < (pageCounter+1)*8) return;
					//������ �׸��� ������ �ڷ� ���� ������ ����
					int pageTempCount = ++pageCounter;
					pageCounter = pageTempCount;
					mainPanel.removeAll();
					btnPanel.removeAll();
					pageLabel.setText( Integer.toString(pageCounter + 1));
					btnPanel.add(preBtn);
					btnPanel.add(pageLabel);
					btnPanel.add(nextBtn);
					setMenu(mainPanel);
			        revalidate();
			        repaint();
					}
				});
			
			btnPanel.add(preBtn);
			btnPanel.add(pageLabel);
			btnPanel.add(nextBtn);
			
			add(mainPanel, "Center");
			add(btnPanel, "South");
			
			setSize(710, 550);
			setVisible(true);
		}
		
		public void setMenu(JPanel obJPanel) {
			 //�޴� �������� �ٲ� ������ �޴� �� �ٲ��ִ� �Լ�
			int page = pageCounter;
			int i = page * 8 ;
			int length = 0;
			//�޴��� ������ ������*8 ���� �۰� ������-1 ���ٴ� ���� ���߰��� ��Ȳ�϶�
			if(getItem.length < (page+1)*8 && getItem.length > (page)*8) {
				length = getItem.length;
			}else {
				length = (page + 1) * 8;
			};
			for(; i < length; i++) {
				s[i] = new MenuItemDisplay(getItem[i], billPane);
				obJPanel.add(s[i]);
			}
			//1�������� 0���� �����ؼ� 7����
			//2�������� 8���� �����ؼ� 15����
		}
	}