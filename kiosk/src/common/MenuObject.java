package common;

public class MenuObject {
	//�� �޴�
	public final static String[] korMenu = {"��", "����","�ҽ�", "����", "�� ", "����"};
	public final static String[] engMenu = {"Rice", "Topping", "Sauce", "Side dish", "Soup ", "Beverage"};

	public  static MenuStructor[] riceMenuKor = {new MenuStructor("�ҹ�", 800, "images/rice/�ҹ�.jpg"),
			new MenuStructor("���", 1000, "images/rice/���.jpg"), new MenuStructor("����", 1000, "images/rice/����.jpg"), 
			new MenuStructor("�Ϲ�", 1000, "images/rice/�Ϲ�.jpg"), new MenuStructor("������", 1000, "images/rice/������.jpg"),
			new MenuStructor("�ᳪ����", 1300, "images/rice/�ᳪ����.jpg"), new MenuStructor("���", 1000, "images/rice/���.jpg"),
			new MenuStructor("����", 1300, "images/rice/����.jpg"), new MenuStructor("��巹 ��", 1300, "images/rice/��巹��.jpg"),
			new MenuStructor("�볪�� ��", 1300, "images/rice/�볪����.png")};
	public final static MenuStructor[] toppingMenuKor = {new MenuStructor("���", 500, "images/topping/���.jpg"),
			new MenuStructor("���� �ٱ�", 300, "images/topping/���� �ٱ�.jpg"), new MenuStructor("��縮", 100, "images/topping/��縮.png"), 
			new MenuStructor("��Ÿ�� ����", 400, "images/topping/��Ÿ������.jpg"), new MenuStructor("�ٽø�", 600, "images/topping/�ٽø�.png"),
			new MenuStructor("���", 500, "images/topping/���.png"), new MenuStructor("�߰�����", 400, "images/topping/�߰�����.jpg"),
			new MenuStructor("����ä", 600, "images/topping/����ä.jpg"), new MenuStructor("�̿�", 300, "images/topping/�̿�.jpg"),
			new MenuStructor("����", 700, "images/topping/����.jpg"), new MenuStructor("����ä��", 700, "images/topping/����ä��.png"),
			new MenuStructor("����", 700, "images/topping/����.png"), new MenuStructor("�ñ�ġ", 700, "images/topping/�ñ�ġ.png"),
			new MenuStructor("��ȸ", 700, "images/topping/��ȸ.png"), new MenuStructor("��ȣ��", 700, "images/topping/��ȣ��.jpg"),
			new MenuStructor("����", 700, "images/topping/����.png"), new MenuStructor("���� ����", 700, "images/topping/��������.png")};
	public final static MenuStructor[] sauceMenuKor = {new MenuStructor("Ư�� ������", 500, "images/source/Ư��������.png"),
			new MenuStructor("������", 300, "images/source/������.jpg"), new MenuStructor("������", 100, "images/source/������.jpg"), 
			new MenuStructor("�Ұ�� ������", 400, "images/source/�Ұ�� ������.jpg")};
	public final static MenuStructor[] sideMenuKor = {new MenuStructor("���ڸ���", 500, "images/sidedish/���ڸ���.jpg"),
			new MenuStructor("�������", 300, "images/sidedish/�������.jpg"), new MenuStructor("�����", 100, "images/sidedish/�����.jpg"), 
			new MenuStructor("��ġ����", 300, "images/sidedish/��ġ����.jpg"), new MenuStructor("������", 100, "images/sidedish/������.jpg"), 
			new MenuStructor("�Ұ������", 300, "images/sidedish/�Ұ�� ����.jpg"), new MenuStructor("�Ҿ�", 100, "images/sidedish/�Ҿ�.jpg"), 
			new MenuStructor("���뺺��", 300, "images/sidedish/���뺺��.png"), new MenuStructor("��¡���ʹ�ħ", 100, "images/sidedish/��¡���ʹ�ħ.jpg"),
			new MenuStructor("�𸸵�", 100, "images/sidedish/�𸸵�.jpg"), new MenuStructor("��������", 300, "images/sidedish/��������.png")};
	public final static MenuStructor[] soupMenuKor = {new MenuStructor("��ġ�", 500, "images/soup/��ġ�.jpg"),
			new MenuStructor("��ĩ��", 300, "images/soup/��ĩ��.jpg"), new MenuStructor("���屹", 100, "images/soup/���屹.png"), 
			new MenuStructor("���", 300, "images/soup/���.jpg"), new MenuStructor("�ᳪ����", 100, "images/soup/�ᳪ����.jpg")};
	public final static MenuStructor[] beverageMenuKor = {new MenuStructor("���", 300, "images/beverage/���.jpg"),
			new MenuStructor("����ƾ��", 300, "images/beverage/����ƾ��.jpg"), new MenuStructor("�̼�����", 100, "images/beverage/�̼�����.jpg"), 
			new MenuStructor("��Ű��", 300, "images/beverage/��Ű��.jpg"), new MenuStructor("�ٴҶ��", 100, "images/beverage/�ٴҶ��.jpg"),
			new MenuStructor("����Ŭ��������", 300, "images/beverage/����Ŭ��������.jpg"), new MenuStructor("��������Ʈ", 300, "images/beverage/��������Ʈ.jpg"),
			new MenuStructor("�Ƹ޸�ī��", 100, "images/beverage/�Ƹ޸�ī��.jpg"), new MenuStructor("�ֽĽ�", 100, "images/beverage/�ֽĽ�.jpg"),
			new MenuStructor("���̽�Ƽ", 300, "images/beverage/���̽�Ƽ.jpg"), new MenuStructor("��ī�ݶ�", 100, "images/beverage/��ī�ݶ�.jpg")};

public  static MenuStructor[] riceMenuEng = {new MenuStructor("cooked rice", 800, "images/rice/�ҹ�.jpg"),
		new MenuStructor("bean rice", 1000, "images/rice/���.jpg"), new MenuStructor("joe rice", 1000, "images/rice/����.jpg"), 
		new MenuStructor("Red bean rice", 1000, "images/rice/�Ϲ�.jpg"), new MenuStructor("Bori rice", 1000, "images/rice/������.jpg"),
		new MenuStructor("bean sprouts.", 1300, "images/rice/�ᳪ����.jpg"), new MenuStructor("bean rice", 1000, "images/rice/���.jpg"),
		new MenuStructor("mixed rice", 1300, "images/rice/����.jpg"), new MenuStructor("Gonde rice", 1300, "images/rice/��巹��.jpg"),
		new MenuStructor("bamboo rice", 1300, "images/rice/�볪����.png")};
public final static MenuStructor[] toppingMenuEng = {new MenuStructor("Egg", 500, "images/topping/���.jpg"),
		new MenuStructor("sweet potato stalks", 300, "images/topping/���� �ٱ�.jpg"), new MenuStructor("Bracken", 100, "images/topping/��縮.png"), 
		new MenuStructor("oyster mushroom", 400, "images/topping/��Ÿ������.jpg"), new MenuStructor("Sea tangle", 600, "images/topping/�ٽø�.png"),
		new MenuStructor("Carrot", 500, "images/topping/���.png"), new MenuStructor("Chicken breast", 400, "images/topping/�߰�����.jpg"),
		new MenuStructor("nonliving bond", 600, "images/topping/����ä.jpg"), new MenuStructor("Seaweed", 300, "images/topping/�̿�.jpg"),
		new MenuStructor("Lettuce", 700, "images/topping/����.jpg"), new MenuStructor("fresh vegetables", 700, "images/topping/����ä��.png"),
		new MenuStructor("Beef", 700, "images/topping/����.png"), new MenuStructor("Spinach", 700, "images/topping/�ñ�ġ.png"),
		new MenuStructor("Korean style raw beef", 700, "images/topping/��ȸ.png"), new MenuStructor("amber", 700, "images/topping/��ȣ��.jpg"),
		new MenuStructor("cockle", 700, "images/topping/����.png"), new MenuStructor("fried eggplant", 700, "images/topping/��������.png")};
public final static MenuStructor[] sauceMenuEng = {new MenuStructor("special hot pepper paste", 500, "images/source/Ư��������.png"),
		new MenuStructor("Kang Do-jang", 300, "images/source/������.jpg"), new MenuStructor("red pepper paste", 100, "images/source/������.jpg"), 
		new MenuStructor("beef red pepper paste", 400, "images/source/�Ұ�� ������.jpg")};
public final static MenuStructor[] sideMenuEng = {new MenuStructor("���ڸ���", 500, "images/sidedish/���ڸ���.jpg"),
		new MenuStructor("Rolled Omelet", 300, "images/sidedish/�������.jpg"), new MenuStructor("Steamed eggs", 100, "images/sidedish/�����.jpg"), 
		new MenuStructor("Kimchi dumplings", 300, "images/sidedish/��ġ����.jpg"), new MenuStructor("Gummandu", 100, "images/sidedish/������.jpg"), 
		new MenuStructor("beef stew", 300, "images/sidedish/�Ұ�� ����.jpg"), new MenuStructor("fried sausage and vegetable", 100, "images/sidedish/�Ҿ�.jpg"), 
		new MenuStructor("Stir-fried Sundae", 300, "images/sidedish/���뺺��.png"), new MenuStructor("Squid sushi rolls", 100, "images/sidedish/��¡���ʹ�ħ.jpg"),
		new MenuStructor("steamed dumpling", 100, "images/sidedish/�𸸵�.jpg"), new MenuStructor("braised mackerel", 300, "images/sidedish/��������.png")};
public final static MenuStructor[] soupMenuEng = {new MenuStructor("Kimchi stew", 500, "images/soup/��ġ�.jpg"),
		new MenuStructor("Kimchi soup", 300, "images/soup/��ĩ��.jpg"), new MenuStructor("Soybean Paste Soup", 100, "images/soup/���屹.png"), 
		new MenuStructor("blowfish soup", 300, "images/soup/���.jpg"), new MenuStructor("bean sprout soup", 100, "images/soup/�ᳪ����.jpg")};
public final static MenuStructor[] beverageMenuEng = {new MenuStructor("pepsi", 300, "images/beverage/���.jpg"),
		new MenuStructor("Mountain Dew", 300, "images/beverage/����ƾ��.jpg"), new MenuStructor("Powder made of mixed grains", 100, "images/beverage/�̼�����.jpg"), 
		new MenuStructor("Milkis", 300, "images/beverage/��Ű��.jpg"), new MenuStructor("Vanilla latte", 100, "images/beverage/�ٴҶ��.jpg"),
		new MenuStructor("Sparkling Orange", 300, "images/beverage/����Ŭ��������.jpg"), new MenuStructor("Sprite", 300, "images/beverage/��������Ʈ.jpg"),
		new MenuStructor("Americano", 100, "images/beverage/�Ƹ޸�ī��.jpg"), new MenuStructor("Hot Six", 100, "images/beverage/�ֽĽ�.jpg"),
		new MenuStructor("iced tea", 300, "images/beverage/���̽�Ƽ.jpg"), new MenuStructor("Coca Cola", 100, "images/beverage/��ī�ݶ�.jpg")};
}
