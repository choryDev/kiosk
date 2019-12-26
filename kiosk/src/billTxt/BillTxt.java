package billTxt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import common.MenuStructor;
import main.Main;
import menudisplay.RightMenuItem;

public class BillTxt {
	ArrayList<ArrayList<MenuStructor>> totalarr;
	
	public BillTxt(int ordernum, Main root) {
		this.totalarr = root.billObject.totalarr;
		
	    final String LINE_SEPARATOR = System.getProperty("line.separator");
		
		//현재 시간 구하는 부분
		long time = System.currentTimeMillis(); //시간을 구하는 함수
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strTime = dayTime.format(new Date(time));
		
	    File file = new File("./src/"+ordernum+"번 영수증.txt");
	    
	    try {
	      FileWriter fw = new FileWriter(file);
	      fw.write("커스텀 비빔밥 주문번호 "+ordernum+"번 손님 영수증");
	      fw.write(LINE_SEPARATOR);
	      int totalprice = 0;//한 그릇의 총 금액
			for(int i = 0; i < totalarr.size(); i++) {
				fw.write(LINE_SEPARATOR);
				fw.write(i+1+"번째 그릇");
				fw.write(LINE_SEPARATOR);
				for(int j = 0; j < totalarr.get(i).size(); j++) {
					fw.write("제품 명 "+ totalarr.get(i).get(j).getMenuTitle()
								+" : "
								+totalarr.get(i).get(j).getMenuCount() + " 개,  총 "
								+totalarr.get(i).get(j).getMenuTotal()+ " 원");
					fw.write(LINE_SEPARATOR);
					totalprice = totalprice + totalarr.get(i).get(j).getMenuTotal();
				}
				fw.write(i+1+"번째 그릇 총 : "+ totalprice +"원");
				fw.write(LINE_SEPARATOR);
			}
			fw.write("총 계산 금액" + totalprice +"원");
			fw.write(LINE_SEPARATOR);
			fw.write("결제한 시간" + strTime);
	      fw.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
}