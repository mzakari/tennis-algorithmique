package com.interfaces.kata;

import com.dev.kata.Play;

public interface GameFeatures {
	
	public void initGame();
	
	public void addPlay (Play p);
	
	public void updateMatchScore(int pId);
	
	public int getGameWinner(Play temp);
	
	public int getMatchWinner();

}
