package pokelator;

public class PokeData {
/*
	String number;
	String english;
	String china;
	String hongkong;
	String taiwan;
*/
	String data;
	
	public PokeData(String data) {
		this.data = data;
	}
/*
public PokeData(String number, String english, String china, String hongkong, String taiwan){
		this.number = number;
		this.english = english;
		this.china = china;
		this.hongkong = hongkong;
		this.taiwan = taiwan;
	}

	
	public String toString(){
		String s = "#";
		s += number + ": ";
		s += "(ENG " + english + ") ";
		s += "(CN " + china + ") ";
		s += "(HK " + hongkong + ") ";
		s += "(TW " + taiwan + ") ";
		return s;
	}
*/
	public String toString(){
		return "#"+data;
	}
}
