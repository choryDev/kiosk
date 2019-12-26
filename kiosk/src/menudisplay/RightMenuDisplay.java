package menudisplay;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import bottomBillPane.AletDialog;
import common.BillObject;
import common.MenuStructor;
import common.MyColor;
import common.SetLanguage;
import component.MyBorderButton;
import component.MyButton;
import main.Main;

public class RightMenuDisplay extends JPanel {
	Main root;
	
	JPanel header = new JPanel(); //����
	JPanel footer = new JPanel(); //�ϴ� ��ư
	JPanel scrollPaneBase = new JPanel(); //��ũ�� �� �ȿ� �� �ǳ�
	JScrollPane scrollPane = new JScrollPane(scrollPaneBase);
	AletDialog aletDialog = null;
	BillObject billObject = null;
	boolean langFlag = new SetLanguage().getLang();//��� �÷���
	public static ArrayList<ArrayList<MenuStructor>> totalarr = new ArrayList<ArrayList<MenuStructor>>();
	
	public RightMenuDisplay(Main root) {
		this.root = root;
		this.totalarr = root.billObject.totalarr;
		this.billObject = root.billObject;
		setLayout(new BorderLayout());
		
		scrollPaneBase.setLayout(new BoxLayout(scrollPaneBase, BoxLayout.Y_AXIS));
		scrollPaneBase.setBackground(MyColor.subColor);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		header.setBackground(MyColor.mainColor);
		header.setPreferredSize(new Dimension(200, 35));
		

		footer.setBackground(MyColor.mainColor);
		footer.setPreferredSize(new Dimension(200, 210));
		footer.setBorder(BorderFactory.createEmptyBorder(27 , 10 , 10 , 0));
		MyButton nextBtn = new MyButton(langFlag ? "payment" : "�����ϱ�", "ũ��");
		nextBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//�ѱ׸��� �ֹ��ÿ�
				if(billObject.billarr.size() != 0) {
					billObject.addOneSet();// �޴��� �ְ�
					root.changeOrderDisplay();//���� ȭ������
				}else if(totalarr.size() == 0) {//�ƹ� �ֹ��� ���� �ʾ��� ��� 
					aletDialog = new AletDialog(root, 
							langFlag ?"Please press a bowl after selecting the menu." : "�޴� ���� �� �ѱ׸��� ���� �ּ���");
					aletDialog.setVisible(true);
				}else {//�����׸� ��� ���� ��
					root.changeOrderDisplay();//���� ȭ������
				}
			}
		});
		nextBtn.setPreferredSize(new Dimension(195, 167));
		footer.add(nextBtn);
		
		refleshDisplay();
		add(header, "North");
		add(scrollPane, "Center");
		add(footer, "South");
		
		setSize(200, 400);
		setVisible(true);
	}
	
	public void refleshDisplay() {//�׸� �ȿ� �޴��� �����ֿ��� �ؼ� 2�� �迭
		scrollPaneBase.removeAll();
		for(int i = 0; i < totalarr.size(); i++) {
			int totalprice = 0;//�� �׸��� �� �ݾ�
			scrollPaneBase.add(new RightMenuItem(i, this));
			for(int j = 0; j < totalarr.get(i).size(); j++) {
				scrollPaneBase.add(new RightMenuItem(totalarr.get(i).get(j)));//�׸� ���� �޴�
				totalprice = totalprice + totalarr.get(i).get(j).getMenuPrice();//�� �޴����� 
			}
			scrollPaneBase.add(new RightMenuItem(totalprice));//�ѱ׸� ����
		}
		revalidate();
		repaint();
	}
}
