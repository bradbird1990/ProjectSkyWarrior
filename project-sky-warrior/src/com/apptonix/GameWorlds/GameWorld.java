package com.apptonix.GameWorlds;

import com.apptonix.GameObjects.Player;

public class GameWorld {

	private Player player;
	
	public GameWorld() {
		
		player = new Player(50, 50, 95, 72);
		
	}
	
	public void update(float delta) {
		
		// Add a frame limiter
		if (delta > 0.15f) {
			delta = 0.15f;
		}
		
		player.update(delta);
		
	}
	
	/*
	 * Getters and setters
	 */
	public Player getPlayer() { return player; }
	
}
