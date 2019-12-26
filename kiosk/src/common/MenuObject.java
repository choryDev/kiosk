package common;

public class MenuObject {
	//탭 메뉴
	public final static String[] korMenu = {"밥", "토핑","소스", "반찬", "국 ", "음료"};
	public final static String[] engMenu = {"Rice", "Topping", "Sauce", "Side dish", "Soup ", "Beverage"};

	public  static MenuStructor[] riceMenuKor = {new MenuStructor("쌀밥", 800, "images/rice/쌀밥.jpg"),
			new MenuStructor("콩밥", 1000, "images/rice/콩밥.jpg"), new MenuStructor("조밥", 1000, "images/rice/조밥.jpg"), 
			new MenuStructor("팥밥", 1000, "images/rice/팥밥.jpg"), new MenuStructor("보리밥", 1000, "images/rice/보리밥.jpg"),
			new MenuStructor("콩나물밥", 1300, "images/rice/콩나물밥.jpg"), new MenuStructor("콩밥", 1000, "images/rice/콩밥.jpg"),
			new MenuStructor("잡곡밥", 1300, "images/rice/잡곡밥.jpg"), new MenuStructor("곤드레 밥", 1300, "images/rice/곤드레밥.jpg"),
			new MenuStructor("대나무 밥", 1300, "images/rice/대나무밥.png")};
	public final static MenuStructor[] toppingMenuKor = {new MenuStructor("계란", 500, "images/topping/계란.jpg"),
			new MenuStructor("고구마 줄기", 300, "images/topping/고구마 줄기.jpg"), new MenuStructor("고사리", 100, "images/topping/고사리.png"), 
			new MenuStructor("느타리 버섯", 400, "images/topping/느타리버슷.jpg"), new MenuStructor("다시마", 600, "images/topping/다시마.png"),
			new MenuStructor("당근", 500, "images/topping/당근.png"), new MenuStructor("닭가슴살", 400, "images/topping/닭가슴살.jpg"),
			new MenuStructor("무생채", 600, "images/topping/무생채.jpg"), new MenuStructor("미역", 300, "images/topping/미역.jpg"),
			new MenuStructor("상추", 700, "images/topping/상추.jpg"), new MenuStructor("새싹채소", 700, "images/topping/새싹채소.png"),
			new MenuStructor("쇠고기", 700, "images/topping/쇠고기.png"), new MenuStructor("시금치", 700, "images/topping/시금치.png"),
			new MenuStructor("육회", 700, "images/topping/육회.png"), new MenuStructor("애호박", 700, "images/topping/애호박.jpg"),
			new MenuStructor("꼬막", 700, "images/topping/꼬막.png"), new MenuStructor("가지 볶음", 700, "images/topping/가지볶음.png")};
	public final static MenuStructor[] sauceMenuKor = {new MenuStructor("특제 고추장", 500, "images/source/특제고추장.png"),
			new MenuStructor("강된장", 300, "images/source/강된장.jpg"), new MenuStructor("고추장", 100, "images/source/고추장.jpg"), 
			new MenuStructor("소고기 고추장", 400, "images/source/소고기 고추장.jpg")};
	public final static MenuStructor[] sideMenuKor = {new MenuStructor("감자만두", 500, "images/sidedish/감자만두.jpg"),
			new MenuStructor("계란말이", 300, "images/sidedish/계란말이.jpg"), new MenuStructor("계란찜", 100, "images/sidedish/계란찜.jpg"), 
			new MenuStructor("김치만두", 300, "images/sidedish/김치만두.jpg"), new MenuStructor("군만두", 100, "images/sidedish/군만두.jpg"), 
			new MenuStructor("소고기조림", 300, "images/sidedish/소고기 조림.jpg"), new MenuStructor("소야", 100, "images/sidedish/소야.jpg"), 
			new MenuStructor("순대볶음", 300, "images/sidedish/순대볶음.png"), new MenuStructor("오징어초무침", 100, "images/sidedish/오징어초무침.jpg"),
			new MenuStructor("찐만두", 100, "images/sidedish/찐만두.jpg"), new MenuStructor("고등어조림", 300, "images/sidedish/고등어조림.png")};
	public final static MenuStructor[] soupMenuKor = {new MenuStructor("김치찌개", 500, "images/soup/김치찌개.jpg"),
			new MenuStructor("김칫국", 300, "images/soup/김칫국.jpg"), new MenuStructor("된장국", 100, "images/soup/된장국.png"), 
			new MenuStructor("복어국", 300, "images/soup/복어국.jpg"), new MenuStructor("콩나물국", 100, "images/soup/콩나물국.jpg")};
	public final static MenuStructor[] beverageMenuKor = {new MenuStructor("펩시", 300, "images/beverage/펩시.jpg"),
			new MenuStructor("마운틴듀", 300, "images/beverage/마운틴듀.jpg"), new MenuStructor("미숫가루", 100, "images/beverage/미숫가루.jpg"), 
			new MenuStructor("밀키스", 300, "images/beverage/밀키스.jpg"), new MenuStructor("바닐라라떼", 100, "images/beverage/바닐라라떼.jpg"),
			new MenuStructor("스파클링오렌지", 300, "images/beverage/스파클링오렌지.jpg"), new MenuStructor("스프라이트", 300, "images/beverage/스프라이트.jpg"),
			new MenuStructor("아메리카노", 100, "images/beverage/아메리카노.jpg"), new MenuStructor("핫식스", 100, "images/beverage/핫식스.jpg"),
			new MenuStructor("아이스티", 300, "images/beverage/아이스티.jpg"), new MenuStructor("코카콜라", 100, "images/beverage/코카콜라.jpg")};

public  static MenuStructor[] riceMenuEng = {new MenuStructor("cooked rice", 800, "images/rice/쌀밥.jpg"),
		new MenuStructor("bean rice", 1000, "images/rice/콩밥.jpg"), new MenuStructor("joe rice", 1000, "images/rice/조밥.jpg"), 
		new MenuStructor("Red bean rice", 1000, "images/rice/팥밥.jpg"), new MenuStructor("Bori rice", 1000, "images/rice/보리밥.jpg"),
		new MenuStructor("bean sprouts.", 1300, "images/rice/콩나물밥.jpg"), new MenuStructor("bean rice", 1000, "images/rice/콩밥.jpg"),
		new MenuStructor("mixed rice", 1300, "images/rice/잡곡밥.jpg"), new MenuStructor("Gonde rice", 1300, "images/rice/곤드레밥.jpg"),
		new MenuStructor("bamboo rice", 1300, "images/rice/대나무밥.png")};
public final static MenuStructor[] toppingMenuEng = {new MenuStructor("Egg", 500, "images/topping/계란.jpg"),
		new MenuStructor("sweet potato stalks", 300, "images/topping/고구마 줄기.jpg"), new MenuStructor("Bracken", 100, "images/topping/고사리.png"), 
		new MenuStructor("oyster mushroom", 400, "images/topping/느타리버슷.jpg"), new MenuStructor("Sea tangle", 600, "images/topping/다시마.png"),
		new MenuStructor("Carrot", 500, "images/topping/당근.png"), new MenuStructor("Chicken breast", 400, "images/topping/닭가슴살.jpg"),
		new MenuStructor("nonliving bond", 600, "images/topping/무생채.jpg"), new MenuStructor("Seaweed", 300, "images/topping/미역.jpg"),
		new MenuStructor("Lettuce", 700, "images/topping/상추.jpg"), new MenuStructor("fresh vegetables", 700, "images/topping/새싹채소.png"),
		new MenuStructor("Beef", 700, "images/topping/쇠고기.png"), new MenuStructor("Spinach", 700, "images/topping/시금치.png"),
		new MenuStructor("Korean style raw beef", 700, "images/topping/육회.png"), new MenuStructor("amber", 700, "images/topping/애호박.jpg"),
		new MenuStructor("cockle", 700, "images/topping/꼬막.png"), new MenuStructor("fried eggplant", 700, "images/topping/가지볶음.png")};
public final static MenuStructor[] sauceMenuEng = {new MenuStructor("special hot pepper paste", 500, "images/source/특제고추장.png"),
		new MenuStructor("Kang Do-jang", 300, "images/source/강된장.jpg"), new MenuStructor("red pepper paste", 100, "images/source/고추장.jpg"), 
		new MenuStructor("beef red pepper paste", 400, "images/source/소고기 고추장.jpg")};
public final static MenuStructor[] sideMenuEng = {new MenuStructor("감자만두", 500, "images/sidedish/감자만두.jpg"),
		new MenuStructor("Rolled Omelet", 300, "images/sidedish/계란말이.jpg"), new MenuStructor("Steamed eggs", 100, "images/sidedish/계란찜.jpg"), 
		new MenuStructor("Kimchi dumplings", 300, "images/sidedish/김치만두.jpg"), new MenuStructor("Gummandu", 100, "images/sidedish/군만두.jpg"), 
		new MenuStructor("beef stew", 300, "images/sidedish/소고기 조림.jpg"), new MenuStructor("fried sausage and vegetable", 100, "images/sidedish/소야.jpg"), 
		new MenuStructor("Stir-fried Sundae", 300, "images/sidedish/순대볶음.png"), new MenuStructor("Squid sushi rolls", 100, "images/sidedish/오징어초무침.jpg"),
		new MenuStructor("steamed dumpling", 100, "images/sidedish/찐만두.jpg"), new MenuStructor("braised mackerel", 300, "images/sidedish/고등어조림.png")};
public final static MenuStructor[] soupMenuEng = {new MenuStructor("Kimchi stew", 500, "images/soup/김치찌개.jpg"),
		new MenuStructor("Kimchi soup", 300, "images/soup/김칫국.jpg"), new MenuStructor("Soybean Paste Soup", 100, "images/soup/된장국.png"), 
		new MenuStructor("blowfish soup", 300, "images/soup/복어국.jpg"), new MenuStructor("bean sprout soup", 100, "images/soup/콩나물국.jpg")};
public final static MenuStructor[] beverageMenuEng = {new MenuStructor("pepsi", 300, "images/beverage/펩시.jpg"),
		new MenuStructor("Mountain Dew", 300, "images/beverage/마운틴듀.jpg"), new MenuStructor("Powder made of mixed grains", 100, "images/beverage/미숫가루.jpg"), 
		new MenuStructor("Milkis", 300, "images/beverage/밀키스.jpg"), new MenuStructor("Vanilla latte", 100, "images/beverage/바닐라라떼.jpg"),
		new MenuStructor("Sparkling Orange", 300, "images/beverage/스파클링오렌지.jpg"), new MenuStructor("Sprite", 300, "images/beverage/스프라이트.jpg"),
		new MenuStructor("Americano", 100, "images/beverage/아메리카노.jpg"), new MenuStructor("Hot Six", 100, "images/beverage/핫식스.jpg"),
		new MenuStructor("iced tea", 300, "images/beverage/아이스티.jpg"), new MenuStructor("Coca Cola", 100, "images/beverage/코카콜라.jpg")};
}
