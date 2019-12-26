package common;

public class SetLanguage {
	private static boolean lang = true;
	
	public void setKorean() {
		this.lang = false;
	}
	
	public void setEnglish() {
		this.lang = true;
	}

	public boolean getLang() {
		return this.lang;
	}
}
