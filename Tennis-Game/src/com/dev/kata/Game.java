package com.dev.kata;

import java.util.ArrayList;
import java.util.List;

import com.interfaces.kata.GameFeatures;

public class Game implements GameFeatures {
	
	List<Play> set = new ArrayList<>();
	List<TableScore> gameScore = new ArrayList<>();
	
	public void addGameScore(TableScore t){
		this.gameScore.add(t);
	}		
	
	@Override 
	public void initGame(){
		
		set.clear();
		gameScore.clear();
		
		Play p = new Play();
		p.setPlayer_1(new Player(1,0,0));
		p.setPlayer_2(new Player(2,0,0));
		
		set.add(p);
		gameScore.add(new TableScore(0,0,0));		
	
	}
	
	@Override 
	public void addPlay (Play p){			
		
		if( getGameWinner(p) == 0 )
			set.add(p);
		
		else{
			p.initNewPlay();
			set.add(p);
		}
	}
	
	@Override 
	public void updateMatchScore(int pId){
		
		int index = this.gameScore.size()-1;
		
		if(pId == 1){			
			TableScore t = this.gameScore.get(index);
			this.gameScore.add(new TableScore(t.getId()+1, t.getScore_1()+1,t.getScore_2()));
		}
		
		else if (pId == 2){			
			TableScore t = this.gameScore.get(index);
			this.gameScore.add(new TableScore(t.getId()+1, t.getScore_1(),t.getScore_2()+1));
		}
	}
	
	@Override 
	public int getGameWinner(Play temp){
		
		int winner = 0;		
		int index = this.gameScore.size()-1;
		
		if(gameScore.get(index).getScore_1() < 6 || gameScore.get(index).getScore_1() < 6){
			
			if (temp.getPlayer_1().getCurrentScore() == 45){
				winner = 1;
				updateMatchScore(1);
			}				
			
			else if (temp.getPlayer_2().getCurrentScore() == 45){
				winner = 2;
				updateMatchScore(2);
			}			
		}
		
		else if(gameScore.get(index).getScore_1() == 6 && gameScore.get(index).getScore_1() == 6){
			
			if (temp.getPlayer_1().getCurrentPoint() >= 7 && (temp.getPlayer_1().getCurrentPoint() - temp.getPlayer_2().getCurrentPoint()) == 2 ){
				winner = 1;
				updateMatchScore(1);
			}
			
			else if (temp.getPlayer_2().getCurrentPoint() >= 7 && (temp.getPlayer_2().getCurrentPoint() - temp.getPlayer_1().getCurrentPoint()) == 2 ){
				winner = 2;
				updateMatchScore(2);
			}			
		}		
		
		return winner;		
	}
	
	@Override 
	public int getMatchWinner(){
		
		int winner = 0;		
		TableScore temp = this.gameScore.get(this.gameScore.size()-1);
		
		if( temp.getScore_1() == 6 && temp.getScore_2() <= 4 || temp.getScore_1() == 7 )
			winner = 1;
		
		else if( temp.getScore_2() == 6 && temp.getScore_1() <= 4 || temp.getScore_2() == 7 )
			winner = 2;		
		
		else if ( temp.getScore_1() == 6 && temp.getScore_2() == 6 ){
			
			Play p = set.get(set.size()-1);
			
			winner = getGameWinner(p);
		}
				
		return winner;
		
	}

	
	public List<Play> getSet() {
		return set;
	}

	
	public List<TableScore> getGameScore() {
		return gameScore;
	}	
	
}