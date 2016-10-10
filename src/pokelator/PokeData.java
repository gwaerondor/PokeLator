package pokelator;

import java.net.URL;

public class PokeData {
	private String number;
	private String english;
	private String china;
	private String hongkong;
	private String taiwan;
	
	public PokeData(String number, String english, String china, String hongkong, String taiwan) {
		this.number = number;
		this.english = english;
		this.china = china;
		this.hongkong = hongkong;
		this.taiwan = taiwan;
	}

	public String toString() {
		String s = "<html>";
		s += getImageString();
		s += "<kbd>#";
		s += number + ":</kbd> ";
		s += "(ENG " + english + ") ";
		s += "(CN " + china + ") ";
		s += "(HK " + hongkong + ") ";
		s += "(TW " + taiwan + ")";
		s += "</html>";
		return s;
	}
	
	private String getImageString() {
		String location = "icons/";
		location += (number.equals("???") ? "qqq" : number) + ".png";
		URL imageURL = getClass().getResource(location);
		return "<img src=\""+imageURL+"\" />";
	}
}
