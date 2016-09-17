package pokelator;

public class ResultLine {
	private String dex;
	private String eng;
	private String cn;
	private String hk;
	private String tw;
	
	public ResultLine(String dex, String eng, String cn, String hk, String tw) {
		this.dex = dex;
		this.eng = eng;
		this.cn = cn;
		this.hk = hk;
		this.tw = tw;
	}
	
	public String getDex() {
		return dex;
	}

	public String getEng() {
		return eng;
	}

	public String getCn() {
		return cn;
	}
	
	public String getHk() {
		return hk;
	}
	
	public String getTw() {
		return tw;
	}
	
	public String toString() {
		String s = "";
		s += "Dex: " + dex + "\n";
		s += "Eng: " + eng + "\n";
		s += "CN:  " + cn + "\n";
		s += "HK:  " + hk + "\n";
		s += "TW:  " + tw + "\n";
		return s;
	}
}
