package com.test.kata;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dev.kata.Player;

public class TestPlayer {

	@Test
	public void testInit() {
		
		Player p = new Player(1);
		p.init();
		
		assertEquals(0, p.getCurrentScore());
		assertEquals(0, p.getCurrentPoint());
	}
	
	
	@Test
	public void testWon() {
		
		Player p = new Player(1);
		p.init();
		
		p.won();		
		assertEquals(15, p.getCurrentScore());
		assertEquals(1, p.getCurrentPoint());		
		
		p.won();		
		assertEquals(30, p.getCurrentScore());
		assertEquals(2, p.getCurrentPoint());
		
		p.won();		
		assertEquals(40, p.getCurrentScore());
		assertEquals(3, p.getCurrentPoint());
		
		p.won();		
		assertEquals(45, p.getCurrentScore());
		assertEquals(4, p.getCurrentPoint());
		
		p.won();		
		assertEquals(45, p.getCurrentScore());
		assertEquals(5, p.getCurrentPoint());
	}

	@Test
	public void testWonDEUCE() {
		
		Player p = new Player(1,42,4);		
		
		p.won();		
		assertEquals(45, p.getCurrentScore());
		assertEquals(5, p.getCurrentPoint());
		
		Player p1 = new Player(1,41,4);
		p1.won();		
		assertEquals(42, p1.getCurrentScore());
		assertEquals(5, p1.getCurrentPoint());
		
	}

}
