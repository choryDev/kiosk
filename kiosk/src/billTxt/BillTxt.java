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
		
		//���� �ð� ���ϴ� �κ�
		long time = System.currentTimeMillis(); //�ð��� ���ϴ� �Լ�
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strTime = dayTime.format(new Date(time));
		
	    File file = new File("./src/"+ordernum+"�� ������.txt");
	    
	    try {
	      FileWriter fw = new FileWriter(file);
	      fw.write("Ŀ���� ����� �ֹ���ȣ "+ordernum+"�� �մ� ������");
	      fw.write(LINE_SEPARATOR);
	      int totalprice = 0;//�� �׸��� �� �ݾ�
			for(int i = 0; i < totalarr.size(); i++) {
				fw.write(LINE_SEPARATOR);
				fw.write(i+1+"��° �׸�");
				fw.write(LINE_SEPARATOR);
				for(int j = 0; j < totalarr.get(i).size(); j++) {
					fw.write("��ǰ �� "+ totalarr.get(i).get(j).getMenuTitle()
								+" : "
								+totalarr.get(i).get(j).getMenuCount() + " ��,  �� "
								+totalarr.get(i).get(j).getMenuTotal()+ " ��");
					fw.write(LINE_SEPARATOR);
					totalprice = totalprice + totalarr.get(i).get(j).getMenuTotal();
				}
				fw.write(i+1+"��° �׸� �� : "+ totalprice +"��");
				fw.write(LINE_SEPARATOR);
			}
			fw.write("�� ��� �ݾ�" + totalprice +"��");
			fw.write(LINE_SEPARATOR);
			fw.write("������ �ð�" + strTime);
	      fw.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
}