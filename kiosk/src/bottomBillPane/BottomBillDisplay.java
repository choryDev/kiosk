package bottomBillPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import common.BillObject;
import common.MenuObject;
import common.MenuStructor;
import common.MyColor;
import common.SetLanguage;
import component.MyButton;
import component.MyButton;
import main.Main;
import menudisplay.RightMenuDisplay;

public class BottomBillDisplay extends JPanel {
	Main root; //버튼을 누르면 화면을 바꿔주기 위해서
	JPanel btnWrap = new JPanel(); //버튼을 감싸줄 판넬
	boolean langFlag = new SetLanguage().getLang();//언어 플래그
	static JPanel scrollPaneBase = new JPanel(); //스크롤 펜 안에 들어갈 판넬
	JScrollPane scrollPane = new JScrollPane(scrollPaneBase); //감싸줄 스크롤 펜
	BillObject billObject = null;
	AletDialog dialog = null;//한그릇 추가시 보여지는 얼렛다이얼로그
	MenuObject menu = new MenuObject();
	
	public BottomBillDisplay(Main root, RightMenuDisplay rigfht_dis) {
		this.billObject = root.billObject;
		this.root = root;
		setBackground(MyColor.subColor);
		setLayout(new BorderLayout());
		
		scrollPaneBase.setLayout(new BoxLayout(scrollPaneBase, BoxLayout.Y_AXIS));
		scrollPaneBase.setBackground(MyColor.subColor);

		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//스크롤펜을 가로로만 한다
		MyButton addBtn = new MyButton(langFlag ? "bowl addition": "한그릇 추가", langFlag ? "중간" : "크게");
		MyButton randomBtn = new MyButton(langFlag ? "bowl of random" : "랜덤 한그릇", langFlag ? "중간" : "크게");
		btnWrap.setBackground(MyColor.mainColor);
		btnWrap.setLayout(new GridLayout(2, 1));
		btnWrap.add(addBtn);
		btnWrap.add(randomBtn);
		
		randomBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				billObject.billarr.add(langFlag ? menu.riceMenuEng[(int)(Math.random()*10)] : menu.riceMenuKor[(int)(Math.random()*10)]);//밥 추가
				billObject.billarr.add(langFlag ? menu.toppingMenuEng[(int)(Math.random()*17)] : menu.toppingMenuKor[(int)(Math.random()*17)]);//토핑 추가
				billObject.billarr.add(langFlag ? menu.toppingMenuEng[(int)(Math.random()*17)] : menu.toppingMenuKor[(int)(Math.random()*17)]);//토핑 추가
				billObject.billarr.add(langFlag ? menu.toppingMenuEng[(int)(Math.random()*17)] : menu.toppingMenuKor[(int)(Math.random()*17)]);//토핑 추가
				billObject.billarr.add(langFlag ? menu.toppingMenuEng[(int)(Math.random()*17)] : menu.toppingMenuKor[(int)(Math.random()*17)]);//토핑 추가
				billObject.billarr.add(langFlag ? menu.sauceMenuEng[(int)(Math.random()*4)] : menu.sauceMenuKor[(int)(Math.random()*4)]);//소스 추가
				billObject.addOneSet();//리스트에 밥 추가
				dialog = new AletDialog(root, "비빔밥이 추가 되었습니다.");//메뉴를 추가한 경우
				rigfht_dis.refleshDisplay();
				scrollPaneBase.removeAll();
				repaint();
				revalidate();
			}
		});
		
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(billObject.billarr.size() == 0) {//메뉴가 비어서 추가를 못하는 경우
					dialog = new AletDialog(root, langFlag ? "The menu is empty." : "메뉴가 비어 있습니다.");
				}else {
					dialog = new AletDialog(root, langFlag ? "Bibimbap has been added." : "비빔밥이 추가 되었습니다.");//메뉴를 추가한 경우
					billObject.addOneSet();
					rigfht_dis.refleshDisplay();
					scrollPaneBase.removeAll();
					repaint();
					revalidate();
				}
				dialog.setVisible(true);
				}
			});
		
		add(new BottomBillItem(), "North");
		add(scrollPane, "Center");
		add(btnWrap, "East");
		setSize(720, 200);
		setLocation(0, 550);
		setVisible(true);
	}
	
	public void changeDisplay(MenuStructor getItem) {
		scrollPaneBase.removeAll();
		billObject.addBill(getItem); //어레이 리스트에 객체를 넣음
		refleshDisplay();//리스트에 추가 후 화면을 새로 바꿈
	}
	
	public void refleshDisplay() {
		scrollPaneBase.removeAll();
		for(MenuStructor item : billObject.billarr) {
			scrollPaneBase.add(new BottomBillItem(item, this));//화면에 아이템을 넣음
		}		
		revalidate();
		repaint();
	}
}
