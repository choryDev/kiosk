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
	String textarr[] = {"��ǰ", "����", "�ݾ�", "�Ѿ�"};
	String textarrEng[] = {"Title", "number", "Price", "Total"};
	boolean langFlag = new SetLanguage().getLang();//��� �÷���
	
	public BillItem() {//��� �÷��� ������
		setBackground(MyColor.subColor);
		setLayout(new GridLayout(1, 4));
		title = new JLabel [this.textarr.length];
		for(int i = 0; i < this.textarr.length; i++) {
			title[i] = new JLabel(langFlag ? textarrEng[i] : textarr[i]);
			title[i].setFont(CommonMethod.myfont("�߰�"));
			title[i].setBorder(BorderFactory.createEmptyBorder(5 , 10 , 5 , 10));
			add(title[i]);
		}
		setMaximumSize(new Dimension(620, 30));
		setPreferredSize(new Dimension(620, 30));
	}
	
	public BillItem(int i) {
		setBackground(MyColor.subColor);
		setLayout(new GridLayout(1, 4));
		JLabel firsrItem = new JLabel(i+1 + (langFlag ? "st Set" : "��° ��Ʈ"));
		firsrItem.setFont(CommonMethod.myfont("�߰�"));
		firsrItem.setBorder(BorderFactory.createEmptyBorder(5 , 10 , 5 , 10));
		add(firsrItem);
		setMaximumSize(new Dimension(620, 30));
		setPreferredSize(new Dimension(620, 30));
	}
	
	public BillItem(MenuStructor item) {//������ ������ �ִ� �޴�
		setBackground(MyColor.subColor);
		setLayout(new GridLayout(1, 4));
		String textarr[] =//������ ������ ���� �迭
			{item.getMenuTitle(), Integer.toString(item.getMenuPrice()),
				Integer.toString(item.getMenuCount()), Integer.toString(item.getMenuTotal())};
		title = new JLabel [this.textarr.length];
		for(int i = 0; i < this.textarr.length; i++) {
			title[i] = new JLabel(langFlag ? textarr[i] : textarr[i]);
			title[i].setFont(CommonMethod.myfont(langFlag ? "�߰��۰�" : "�߰�"));
			title[i].setBorder(BorderFactory.createEmptyBorder(5 , 10 , 5 , 10));
			add(title[i]);
		}
		setMaximumSize(new Dimension(620, 30));
		setPreferredSize(new Dimension(620, 30));
	}
	
	public BillItem(int totalprice, boolean flg) {//������ ������ �ִ� �޴�
		setBackground(MyColor.subColor);
		setLayout(new GridLayout(1, 4));
		String textarr[] = {"", "", langFlag ? "Total" : "�� �ݾ� : ", Integer.toString(totalprice)};//������ ������ ���� �迭
		title = new JLabel [this.textarr.length];
		for(int i = 0; i < this.textarr.length; i++) {
			title[i] = new JLabel(textarr[i]);
			title[i].setFont(CommonMethod.myfont(langFlag ? "�߰��۰�" : "�߰�"));
			title[i].setBorder(BorderFactory.createEmptyBorder(5 , 10 , 5 , 10));
			if(i == 2) {// �� �ݾװ� ������ ���̰� �ϱ� ���� ���� ����
				title[2].setHorizontalAlignment(JLabel.RIGHT);
			}
			add(title[i]);
		}
		setMaximumSize(new Dimension(620, 50));
		setPreferredSize(new Dimension(620, 50));
	}
}
