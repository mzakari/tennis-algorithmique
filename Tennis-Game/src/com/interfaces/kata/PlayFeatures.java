package com.interfaces.kata;

import com.dev.kata.Play;

public interface PlayFeatures {
	
	public void initNewPlay();	
	
	// N : for normal mode 
	// T : for Tie break 
	public Play nextPlay(int id, char mode);		

}
