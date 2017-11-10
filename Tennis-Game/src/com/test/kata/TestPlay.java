package com.test.kata;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dev.kata.Play;
import com.dev.kata.Player;

public class TestPlay {

	@Test
	public void testNetxPlay() {
		
		Play p = new Play();
		p.setPlayer_1(new Player(1,30,2));
		p.setPlayer_2(new Player(2,0,0));
		
		Play np = p.nextPlay(1,'N');
		
		assertEquals(1, np.getId());
		
		assertEquals(40, np.getPlayer_1().getCurrentScore());
		assertEquals(3, np.getPlayer_1().getCurrentPoint());
		
		assertEquals(0, np.getPlayer_2().getCurrentScore());
		assertEquals(0, np.getPlayer_2().getCurrentPoint());
		
	}
	
	@Test
	public void testNetxPlayDEUCE() {
		
		Play p = new Play();
		p.setPlayer_1(new Player(1,40,3));
		p.setPlayer_2(new Player(2,40,3));
		
		Play np = p.nextPlay(1,'N');
		
		assertEquals(1, np.getId());		
		assertEquals(42, np.getPlayer_1().getCurrentScore());
		assertEquals(4, np.getPlayer_1().getCurrentPoint());
		
		Play np1 = np.nextPlay(2,'N');
		assertEquals(41, np1.getPlayer_1().getCurrentScore());
		assertEquals(41, np1.getPlayer_2().getCurrentScore());
		
		Play np2 = np1.nextPlay(2,'N');
		assertEquals(40, np2.getPlayer_1().getCurrentScore());
		assertEquals(42, np2.getPlayer_2().getCurrentScore());
		
		Play np3 = np2.nextPlay(2,'N');
		assertEquals(40, np3.getPlayer_1().getCurrentScore());
		assertEquals(45, np3.getPlayer_2().getCurrentScore());			
		
	}
	
	@Test
	public void testNetxPlayTieBreak() {
		
		Play p = new Play();
		p.setPlayer_1(new Player(1,40,3));
		p.setPlayer_2(new Player(2,40,3));
		
		Play np = p.nextPlay(1,'T');
		
		assertEquals(1, np.getId());		
		assertEquals(4, np.getPlayer_1().getCurrentPoint());
		
		Play np1 = np.nextPlay(1,'T');
		assertEquals(5, np1.getPlayer_1().getCurrentPoint());
	}

}
