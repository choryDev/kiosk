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
	
	JPanel header = new JPanel(); //여백
	JPanel footer = new JPanel(); //하단 버튼
	JPanel scrollPaneBase = new JPanel(); //스크롤 펜 안에 들어갈 판넬
	JScrollPane scrollPane = new JScrollPane(scrollPaneBase);
	AletDialog aletDialog = null;
	BillObject billObject = null;
	boolean langFlag = new SetLanguage().getLang();//언어 플래그
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
		MyButton nextBtn = new MyButton(langFlag ? "payment" : "결제하기", "크게");
		nextBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//한그릇만 주문시에
				if(billObject.billarr.size() != 0) {
					billObject.addOneSet();// 메뉴를 넣고
					root.changeOrderDisplay();//결제 화면으로
				}else if(totalarr.size() == 0) {//아무 주문을 하지 않았을 경우 
					aletDialog = new AletDialog(root, 
							langFlag ?"Please press a bowl after selecting the menu." : "메뉴 선택 후 한그릇을 눌러 주세요");
					aletDialog.setVisible(true);
				}else {//여러그릇 담겨 있을 때
					root.changeOrderDisplay();//결제 화면으로
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
	
	public void refleshDisplay() {//그릇 안에 메뉴를 보여주여야 해서 2중 배열
		scrollPaneBase.removeAll();
		for(int i = 0; i < totalarr.size(); i++) {
			int totalprice = 0;//한 그릇의 총 금액
			scrollPaneBase.add(new RightMenuItem(i, this));
			for(int j = 0; j < totalarr.get(i).size(); j++) {
				scrollPaneBase.add(new RightMenuItem(totalarr.get(i).get(j)));//그릇 안의 메뉴
				totalprice = totalprice + totalarr.get(i).get(j).getMenuPrice();//각 메뉴가격 
			}
			scrollPaneBase.add(new RightMenuItem(totalprice));//한그릇 총합
		}
		revalidate();
		repaint();
	}
}
