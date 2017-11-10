package com.dev.kata;

import com.interfaces.kata.PlayFeatures;

public class Play implements Cloneable, PlayFeatures {
	
	private int id;
	private Player player_1;
	private Player player_2;
	
	public Play(){
		super();
	}
	
	public Play(int id, Player p1, Player p2){
		
		this.id = id;
		this.player_1 = (Player)p1.clone();		
		this.player_2 = (Player)p2.clone();
	}
	
	@Override 
	public void initNewPlay(){
		
		this.id ++;
		this.player_1.init();
		this.player_2.init();
	}
	
	@Override 
	public Object clone() {
		
		Play g = null;
	    try {	    	
	    	g = (Play) super.clone();	   
	    	g.id = id;
	    	g.player_1 = (Player)this.player_1.clone();
	    	g.player_2 = (Player)this.player_2.clone();
	    } 
	    catch(CloneNotSupportedException cnse) {
	      	cnse.printStackTrace(System.err);
	    }   
	    return g;
	}
	
	@Override 
	public Play nextPlay(int id, char mode) {
		Play p = new Play();
		p = (Play) this.clone();
		
		int pId1 = p.player_1.getId();
		int pId2 = p.player_2.getId();
		
		p.setId(this.id+1);
		
		if (mode == 'N'){
			
			if (id == pId1 && p.player_2.getCurrentScore() < 40)
				p.player_1.won();
			
			else if (id == pId1 && p.player_1.getCurrentScore() == 40 && p.player_2.getCurrentScore() == 40)
				p.player_1.setPlayer(pId1, 42, p.player_1.getCurrentPoint()+1);		
				
			else if (id == pId1 && p.player_1.getCurrentScore() == 40 && p.player_2.getCurrentScore() == 42){
				p.player_1.setPlayer(pId1, 41, p.player_1.getCurrentPoint()+1);
				p.player_2.setPlayer(pId2, 41, p.player_2.getCurrentPoint()+1);
			}
			
			else if (id == pId1 && p.player_1.getCurrentScore() == 42 && p.player_2.getCurrentScore() == 40)
				p.player_1.won();
			
			else if (id == pId1 && p.player_1.getCurrentScore() == 41){
				p.player_1.won();
				p.player_2.setPlayer(pId2, 40, p.player_2.getCurrentPoint()+1);
			}
				
			
			else if (id == pId2 && p.player_1.getCurrentScore() < 40)
				p.player_2.won();	
			
			else if (id == pId2 && p.player_1.getCurrentScore() == 40 && p.player_2.getCurrentScore() == 40)
				p.player_2.setPlayer(pId2, 42, p.player_2.getCurrentPoint()+1);
			
			else if (id == pId2 && p.player_2.getCurrentScore() == 42 && p.player_1.getCurrentScore() == 40)
				p.player_2.won();
			
			else if (id == pId2 && p.player_2.getCurrentScore() == 40 && p.player_1.getCurrentScore() == 42){
				p.player_1.setPlayer(pId1, 41, p.player_1.getCurrentPoint()+1);
				p.player_2.setPlayer(pId2, 41, p.player_2.getCurrentPoint()+1);
			}
			
			else if (id == pId2 && p.player_2.getCurrentScore() == 41){
				p.player_1.setPlayer(pId1, 40, p.player_1.getCurrentPoint()+1);
				p.player_2.won();
			}
		}
		
		else if (mode == 'T'){
			if (id == pId1)
				p.player_1.won();
			else if (id == pId2)
				p.player_2.won();
		}
		return p;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Player getPlayer_1() {
		return player_1;
	}
	
	public void setPlayer_1(Player player_1) {
		this.player_1 = (Player)player_1.clone();
	}
	
	public Player getPlayer_2() {
		return player_2;
	}
	public void setPlayer_2(Player player_2) {
		this.player_2 = (Player)player_2.clone();
	}

}
