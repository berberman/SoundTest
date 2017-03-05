package cn.berberman.soundtest;

public enum Sounds {
	比赛开始("charge", 0),
	自动结束("endauto", 1),
	比赛结束("endmatch", 2),
	口哨("factwhistle", 3),
	火警("firebell", 4),
	雾炮("fogblast", 5);

	Sounds(String fname, int index) {
		this.fname = fname + ".wav";
		this.index = index;
	}

	private String fname;
	private int index;

	public int getIndex() {
		return index;
	}

	public String getFname() {
		return fname;
	}
}
