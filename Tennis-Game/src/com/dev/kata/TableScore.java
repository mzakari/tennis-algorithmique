package com.dev.kata;

public class TableScore {

	private int id;
	private int score_1;
	private int score_2;
	
	public TableScore(){
		super();
	}
	
	public TableScore(int id, int s1, int s2){
		
		this.id = id;
		this.score_1 = s1;
		this.score_2 = s2;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore_1() {
		return score_1;
	}
	public void setScore_1(int score_1) {
		this.score_1 = score_1;
	}
	public int getScore_2() {
		return score_2;
	}
	public void setScore_2(int score_2) {
		this.score_2 = score_2;
	}
	
	
}
