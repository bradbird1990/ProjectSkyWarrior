package com.apptonix.GameWorlds;

import com.apptonix.GameObjects.Player;
import com.apptonix.GameObjects.ScrollHandler;

public class GameWorld {
	
	private Player player;
	
	private ScrollHandler scrollHandler;
	
	public GameWorld() {
		
		scrollHandler = new ScrollHandler(this);
		
		player = new Player(50, 50, 95, 72);
		
	}
	
	public void update(float delta) {
		
		// Add a frame limiter
		if (delta > 0.15f) {
			delta = 0.15f;
		}
		
		scrollHandler.update(delta);
		player.update(delta);
		
	}
	
	/*
	 * Getters and setters
	 */
	public Player getPlayer() { return player; }
	
	public ScrollHandler getScrollHandler() { return scrollHandler; }
	
}
