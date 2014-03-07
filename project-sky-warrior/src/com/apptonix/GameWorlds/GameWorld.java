package com.apptonix.GameWorlds;

import com.apptonix.GameHelpers.AssetLoader;
import com.apptonix.GameObjects.Player;
import com.apptonix.GameObjects.ScrollHandler;

public class GameWorld {
	
	private int gameWidth;
	private int gameHeight;
	
	private Player player;
	private int playerWidth = 95;
	private int playerHeight = 72;
	
	private ScrollHandler scrollHandler;
	
	private boolean introMusic = false;
	
	public GameWorld(int pGameHeight, int pGameWidth) {
		
		scrollHandler = new ScrollHandler(this);
		
		this.gameWidth = pGameWidth;
		this.gameHeight = pGameHeight;
		
		player = new Player((this.gameWidth / 2) + 100, this.gameHeight / 2, playerWidth, playerHeight);
		
	}
	
	public void update(float delta) {
		
		// Add a frame limiter
		if (delta > 0.15f) {
			delta = 0.15f;
		}
		
		if (!introMusic) {
			AssetLoader.introMusic.play();
			introMusic = true;
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
