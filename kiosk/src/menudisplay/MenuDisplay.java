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
		BottomBillDisplay billPane; //아이템 클릭시 같은 객체에 접근하기 위해서 생성
		
		public MenuDisplay(MenuStructor[] item, BottomBillDisplay billPane){
			this.billPane = billPane;
			this.getItem = item;
			s = new MenuItemDisplay [this.getItem.length];
			setLayout(new BorderLayout());
			
			JPanel mainPanel = new JPanel();
			JPanel btnPanel = new JPanel();
			
			MyButton nextBtn = new MyButton("=>", "중간");	
			MyButton preBtn = new MyButton("<=", "중간");
			JLabel pageLabel = new JLabel();
			pageLabel.setForeground(MyColor.mainColor);
			pageLabel.setFont(CommonMethod.myfont("중간"));
			pageLabel.setText( Integer.toString(pageCounter + 1));
			
			mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			mainPanel.setBackground(MyColor.mainColor);
			setMenu(mainPanel);
			btnPanel.setBackground(MyColor.subColor);
			
			preBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(pageCounter == 0) return;
					 //1페이지이면 앞으로 더갈 수 없어서 리턴
					int pageTempCount = --pageCounter; //페이지 1칸 빼기
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
					//아이템 항목이 더없어 뒤로 갈수 없으면 리턴
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
			 //메뉴 페이지가 바뀔때 보여질 메뉴 수 바꿔주는 함수
			int page = pageCounter;
			int i = page * 8 ;
			int length = 0;
			//메뉴의 갯수가 페이지*8 보다 작고 페이지-1 보다는 만은 어중간한 상황일때
			if(getItem.length < (page+1)*8 && getItem.length > (page)*8) {
				length = getItem.length;
			}else {
				length = (page + 1) * 8;
			};
			for(; i < length; i++) {
				s[i] = new MenuItemDisplay(getItem[i], billPane);
				obJPanel.add(s[i]);
			}
			//1페이지면 0부터 시작해서 7까지
			//2페이지면 8부터 시작해서 15까지
		}
	}