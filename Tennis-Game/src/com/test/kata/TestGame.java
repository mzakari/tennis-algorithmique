package com.test.kata;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dev.kata.Game;
import com.dev.kata.Play;
import com.dev.kata.Player;
import com.dev.kata.TableScore;

public class TestGame {

	@Test
	public void testAddPlay() {
		
		Game g = new Game();
		
		Play p = new Play();
		p.setPlayer_1(new Player(1,15,1));
		p.setPlayer_2(new Player(2,0,0));
		
		g.initGame();
		
		assertEquals(1, g.getSet().size());
		
		g.addPlay(p);		
		assertEquals(2, g.getSet().size());
		
	}
	
	@Test
	public void testWinGame() {
		
		Game g = new Game();		
		g.initGame();		
		
		Play p = new Play();
		p.setPlayer_1(new Player(1,40,3));
		p.setPlayer_2(new Player(2,0,0));		
				
		assertEquals(1, g.getGameWinner(p.nextPlay(1,'N')));
		
		assertEquals(1, g.getGameScore().get(1).getId());
		assertEquals(1, g.getGameScore().get(1).getScore_1());
		assertEquals(0, g.getGameScore().get(1).getScore_2());
		
	}
	
	@Test
	public void testWinMatch() {
		
		Game g = new Game();
		g.initGame();
		
		Play p = new Play();
		p.setPlayer_1(new Player(1,40,3));
		p.setPlayer_2(new Player(2,0,0));
		
		g.addPlay(p);
		
		g.addGameScore(new TableScore(6, 6, 0));		
		assertEquals(1, g.getMatchWinner());
		
		g.addGameScore(new TableScore(7, 6, 5));		
		assertEquals(0, g.getMatchWinner());
		
		g.addGameScore(new TableScore(8, 6, 7));		
		assertEquals(2, g.getMatchWinner());
		
		g.addGameScore(new TableScore(8, 6, 6));		
		assertEquals(0, g.getMatchWinner());
		
	}

}