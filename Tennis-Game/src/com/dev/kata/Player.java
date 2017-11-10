package com.dev.kata;

import com.interfaces.kata.PlayerFeatures;

public class Player implements Cloneable, PlayerFeatures {

	private int id;
	private int currentScore;
	private int currentPoint;
	
	public Player(){
		
		super();
	}
	
	public Player(int id){
		
		this.id = id;
	}
	
	public Player(int id, int currentScore, int currentPoint){
		
		this.id = id;
		this.currentScore = currentScore;
		this.currentPoint = currentPoint;
	}
	
	public void  setPlayer(int id, int currentScore, int currentPoint){
		
		this.id = id;
		this.currentScore = currentScore;
		this.currentPoint = currentPoint;
	}
	
	@Override 
	public void init(){
		
		currentPoint = 0;
		currentScore = 0;
	}
	
	@Override 
	public void won(){
		
		this.currentPoint++;
		
		switch(currentScore){			
			
		case 0: 
			this.currentScore += 15; 
		break;

		case 15: 
			this.currentScore += 15;
		break;

		case 30: 
			this.currentScore += 10;		
		break;	
		
		case 40: 
			this.currentScore += 5;		
		break;
		//DEUCE
		case 41: 
			this.currentScore += 1; 
		break;
		
		case 42: 
			this.currentScore += 3; 
		break;

		default:	
			break;				
		}		
		
	}
	
	@Override 
	public Object clone() {
		
		Player g = null;
	    try {	    	
	    	g = (Player) super.clone();
	    } 
	    catch(CloneNotSupportedException cnse) {
	      	cnse.printStackTrace(System.err);
	    }   
	    return g;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCurrentScore() {
		return currentScore;
	}
	
	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}
	
	public int getCurrentPoint() {
		return currentPoint;
	}
	
	public void setCurrentPoint(int currentPoint) {
		this.currentPoint = currentPoint;
	}	
	
}
