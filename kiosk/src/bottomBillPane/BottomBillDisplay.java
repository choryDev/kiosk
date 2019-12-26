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
	Main root; //��ư�� ������ ȭ���� �ٲ��ֱ� ���ؼ�
	JPanel btnWrap = new JPanel(); //��ư�� ������ �ǳ�
	boolean langFlag = new SetLanguage().getLang();//��� �÷���
	static JPanel scrollPaneBase = new JPanel(); //��ũ�� �� �ȿ� �� �ǳ�
	JScrollPane scrollPane = new JScrollPane(scrollPaneBase); //������ ��ũ�� ��
	BillObject billObject = null;
	AletDialog dialog = null;//�ѱ׸� �߰��� �������� �󷿴��̾�α�
	MenuObject menu = new MenuObject();
	
	public BottomBillDisplay(Main root, RightMenuDisplay rigfht_dis) {
		this.billObject = root.billObject;
		this.root = root;
		setBackground(MyColor.subColor);
		setLayout(new BorderLayout());
		
		scrollPaneBase.setLayout(new BoxLayout(scrollPaneBase, BoxLayout.Y_AXIS));
		scrollPaneBase.setBackground(MyColor.subColor);

		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//��ũ������ ���ηθ� �Ѵ�
		MyButton addBtn = new MyButton(langFlag ? "bowl addition": "�ѱ׸� �߰�", langFlag ? "�߰�" : "ũ��");
		MyButton randomBtn = new MyButton(langFlag ? "bowl of random" : "���� �ѱ׸�", langFlag ? "�߰�" : "ũ��");
		btnWrap.setBackground(MyColor.mainColor);
		btnWrap.setLayout(new GridLayout(2, 1));
		btnWrap.add(addBtn);
		btnWrap.add(randomBtn);
		
		randomBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				billObject.billarr.add(langFlag ? menu.riceMenuEng[(int)(Math.random()*10)] : menu.riceMenuKor[(int)(Math.random()*10)]);//�� �߰�
				billObject.billarr.add(langFlag ? menu.toppingMenuEng[(int)(Math.random()*17)] : menu.toppingMenuKor[(int)(Math.random()*17)]);//���� �߰�
				billObject.billarr.add(langFlag ? menu.toppingMenuEng[(int)(Math.random()*17)] : menu.toppingMenuKor[(int)(Math.random()*17)]);//���� �߰�
				billObject.billarr.add(langFlag ? menu.toppingMenuEng[(int)(Math.random()*17)] : menu.toppingMenuKor[(int)(Math.random()*17)]);//���� �߰�
				billObject.billarr.add(langFlag ? menu.toppingMenuEng[(int)(Math.random()*17)] : menu.toppingMenuKor[(int)(Math.random()*17)]);//���� �߰�
				billObject.billarr.add(langFlag ? menu.sauceMenuEng[(int)(Math.random()*4)] : menu.sauceMenuKor[(int)(Math.random()*4)]);//�ҽ� �߰�
				billObject.addOneSet();//����Ʈ�� �� �߰�
				dialog = new AletDialog(root, "������� �߰� �Ǿ����ϴ�.");//�޴��� �߰��� ���
				rigfht_dis.refleshDisplay();
				scrollPaneBase.removeAll();
				repaint();
				revalidate();
			}
		});
		
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(billObject.billarr.size() == 0) {//�޴��� �� �߰��� ���ϴ� ���
					dialog = new AletDialog(root, langFlag ? "The menu is empty." : "�޴��� ��� �ֽ��ϴ�.");
				}else {
					dialog = new AletDialog(root, langFlag ? "Bibimbap has been added." : "������� �߰� �Ǿ����ϴ�.");//�޴��� �߰��� ���
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
		billObject.addBill(getItem); //��� ����Ʈ�� ��ü�� ����
		refleshDisplay();//����Ʈ�� �߰� �� ȭ���� ���� �ٲ�
	}
	
	public void refleshDisplay() {
		scrollPaneBase.removeAll();
		for(MenuStructor item : billObject.billarr) {
			scrollPaneBase.add(new BottomBillItem(item, this));//ȭ�鿡 �������� ����
		}		
		revalidate();
		repaint();
	}
}
