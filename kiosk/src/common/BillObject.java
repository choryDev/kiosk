package common;

import java.util.ArrayList;

import bottomBillPane.BottomBillItem;

public class BillObject {
	public ArrayList<ArrayList<MenuStructor>> totalarr = new ArrayList<ArrayList<MenuStructor>>();//��

	public ArrayList<MenuStructor> billarr = new ArrayList<MenuStructor>();//�ѱ׸�
	
	public BillObject(){
		// TODO Auto-generated constructor stub
	}
	
	public void delete1UnderBill(MenuStructor item) {
		//�������� ��ǰ�� 1���� ���������� �ƿ� �����ϱ�
		for(int i = 0; i < billarr.size(); i++) {
			if(billarr.get(i).getMenuTitle().equals(item.getMenuTitle())) {
				billarr.remove(i);
			}
		}
	}
	
	public void addBill(MenuStructor item){
		int sameMenuCheck = -1; //���� �޴��� �ִ��� ������
		for(int i = 0; i < billarr.size(); i++) {
			if(billarr.get(i).getMenuTitle().equals(item.getMenuTitle())) {
				sameMenuCheck = i;//���� �޴��� �־ �ش� �޴� ��° ����
			}
		}
		if(sameMenuCheck == -1) {
			billarr.add(item);//�������� ���� ó�� �߰��� ���
		}else {//���� �Ŵ��� �־ ������ �߰� �ϴ� �κ�
			billarr.get(sameMenuCheck).addMenu();
		}
	}
	
	public void addOneSet() {
		totalarr.add(new ArrayList<MenuStructor>(billarr));
		billarr.clear();
	}
}
