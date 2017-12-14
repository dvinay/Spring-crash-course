package com.fuppino.spring.reftype;

public class Score {
	private int math;
	private int chem;
	private int scie;

	public Score() {
		super();
	}

	public Score(int math, int chem, int scie) {
		super();
		this.math = math;
		this.chem = chem;
		this.scie = scie;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getChem() {
		return chem;
	}

	public void setChem(int chem) {
		this.chem = chem;
	}

	public int getScie() {
		return scie;
	}

	public void setScie(int scie) {
		this.scie = scie;
	}

	@Override
	public String toString() {
		return "Score [math=" + math + ", chem=" + chem + ", scie=" + scie
				+ "]";
	}

}
