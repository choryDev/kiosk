package orderdisplay;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.CommonMethod;
import common.MenuStructor;
import common.MyColor;
import common.SetLanguage;
import menudisplay.MenuItemDisplay;

public class BillItem extends JPanel {
	JLabel[] title = null;
	String textarr[] = {"제품", "수량", "금액", "총액"};
	String textarrEng[] = {"Title", "number", "Price", "Total"};
	boolean langFlag = new SetLanguage().getLang();//언어 플래그
	
	public BillItem() {//상단 컬럼명 아이템
		setBackground(MyColor.subColor);
		setLayout(new GridLayout(1, 4));
		title = new JLabel [this.textarr.length];
		for(int i = 0; i < this.textarr.length; i++) {
			title[i] = new JLabel(langFlag ? textarrEng[i] : textarr[i]);
			title[i].setFont(CommonMethod.myfont("중간"));
			title[i].setBorder(BorderFactory.createEmptyBorder(5 , 10 , 5 , 10));
			add(title[i]);
		}
		setMaximumSize(new Dimension(620, 30));
		setPreferredSize(new Dimension(620, 30));
	}
	
	public BillItem(int i) {
		setBackground(MyColor.subColor);
		setLayout(new GridLayout(1, 4));
		JLabel firsrItem = new JLabel(i+1 + (langFlag ? "st Set" : "번째 세트"));
		firsrItem.setFont(CommonMethod.myfont("중간"));
		firsrItem.setBorder(BorderFactory.createEmptyBorder(5 , 10 , 5 , 10));
		add(firsrItem);
		setMaximumSize(new Dimension(620, 30));
		setPreferredSize(new Dimension(620, 30));
	}
	
	public BillItem(MenuStructor item) {//갯수와 수량이 있는 메뉴
		setBackground(MyColor.subColor);
		setLayout(new GridLayout(1, 4));
		String textarr[] =//갯수와 수량을 담은 배열
			{item.getMenuTitle(), Integer.toString(item.getMenuPrice()),
				Integer.toString(item.getMenuCount()), Integer.toString(item.getMenuTotal())};
		title = new JLabel [this.textarr.length];
		for(int i = 0; i < this.textarr.length; i++) {
			title[i] = new JLabel(langFlag ? textarr[i] : textarr[i]);
			title[i].setFont(CommonMethod.myfont(langFlag ? "중간작게" : "중간"));
			title[i].setBorder(BorderFactory.createEmptyBorder(5 , 10 , 5 , 10));
			add(title[i]);
		}
		setMaximumSize(new Dimension(620, 30));
		setPreferredSize(new Dimension(620, 30));
	}
	
	public BillItem(int totalprice, boolean flg) {//갯수와 수량이 있는 메뉴
		setBackground(MyColor.subColor);
		setLayout(new GridLayout(1, 4));
		String textarr[] = {"", "", langFlag ? "Total" : "총 금액 : ", Integer.toString(totalprice)};//갯수와 수량을 담은 배열
		title = new JLabel [this.textarr.length];
		for(int i = 0; i < this.textarr.length; i++) {
			title[i] = new JLabel(textarr[i]);
			title[i].setFont(CommonMethod.myfont(langFlag ? "중간작게" : "중간"));
			title[i].setBorder(BorderFactory.createEmptyBorder(5 , 10 , 5 , 10));
			if(i == 2) {// 총 금액과 가까이 보이게 하기 위해 우측 정렬
				title[2].setHorizontalAlignment(JLabel.RIGHT);
			}
			add(title[i]);
		}
		setMaximumSize(new Dimension(620, 50));
		setPreferredSize(new Dimension(620, 50));
	}
}
