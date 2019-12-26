package common;

import java.util.ArrayList;

import bottomBillPane.BottomBillItem;

public class BillObject {
	public ArrayList<ArrayList<MenuStructor>> totalarr = new ArrayList<ArrayList<MenuStructor>>();//총

	public ArrayList<MenuStructor> billarr = new ArrayList<MenuStructor>();//한그릇
	
	public BillObject(){
		// TODO Auto-generated constructor stub
	}
	
	public void delete1UnderBill(MenuStructor item) {
		//영수증에 제품이 1개라서 영수증에서 아예 삭제하기
		for(int i = 0; i < billarr.size(); i++) {
			if(billarr.get(i).getMenuTitle().equals(item.getMenuTitle())) {
				billarr.remove(i);
			}
		}
	}
	
	public void addBill(MenuStructor item){
		int sameMenuCheck = -1; //같은 메뉴가 있는지 없는지
		for(int i = 0; i < billarr.size(); i++) {
			if(billarr.get(i).getMenuTitle().equals(item.getMenuTitle())) {
				sameMenuCheck = i;//같은 메뉴가 있어서 해당 메뉴 번째 저장
			}
		}
		if(sameMenuCheck == -1) {
			billarr.add(item);//영수증에 없고 처음 추가인 경우
		}else {//같은 매뉴가 있어서 수량을 추가 하는 부분
			billarr.get(sameMenuCheck).addMenu();
		}
	}
	
	public void addOneSet() {
		totalarr.add(new ArrayList<MenuStructor>(billarr));
		billarr.clear();
	}
}
