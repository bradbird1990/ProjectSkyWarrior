package com.apptonix.GameWorlds;

import com.apptonix.GameHelpers.AssetLoader;
import com.apptonix.GameObjects.Player;
import com.apptonix.GameObjects.Soldier;
import com.apptonix.GameObjects.ScrollHandler;

public class GameWorld {
	
	private int gameWidth;
	private int gameHeight;
	
	private Player player;
	
	private int playerStartX = -100;
	private int playerStartY = 400;
	private int playerWidth = 95;
	private int playerHeight = 72;
	
	private Soldier soldier;
	
	private int soldierStartX = 200;
	private int soldierStartY = 600;
	private int soldierWidth = 38;
	private int soldierHeight = 42;
	
	private ScrollHandler scrollHandler;
	
	public enum GameState {
		SPLASH_PRE,
		SPLASH,
		SPLASH_POST,
		PLAYING_PRE,
		PLAYING,
		GAMEOVER
	}
	
	private GameState currentState;
	
	private boolean isFadingOut = false;
	
	public GameWorld(int pGameHeight, int pGameWidth) {
		
		scrollHandler = new ScrollHandler(this);
		
		this.gameWidth = pGameWidth;
		this.gameHeight = pGameHeight;
		
		player = new Player(playerStartX, playerStartY, playerWidth, playerHeight); // Put player out of sight for now
		soldier = new Soldier(soldierStartX, soldierStartY, soldierWidth, soldierHeight);
		
		currentState = GameState.SPLASH_PRE;
		
	}
	
	public void update(float delta) {
		
		// Add a frame limiter
		if (delta > 0.15f) {
			delta = 0.15f;
		}
		
		switch (currentState) {
			case SPLASH_PRE:
				default:
					updateSplashPre(delta);
				break;
			case SPLASH:
				updateSplash(delta);
				break;
			case SPLASH_POST:
				updateSplashPost(delta);
				break;
			case PLAYING_PRE:
				updatePlayingPre(delta);
				break;
			/*case PLAYING:
				updatePlaying(delta);
				break;
			case GAMEOVER:
				updateGameover(delta);
				break;*/
		}
		
		scrollHandler.update(delta);
		player.update(delta);
		
	}
	
	public void updateSplashPre(float delta) {
		
		if (!AssetLoader.introMusic.isPlaying()) {
			AssetLoader.introMusic.play();
			AssetLoader.introMusic.setLooping(true);
		}
		
		player.setVelocityX(200);
		player.setShouldHover(true);
		
		if (player.getX() >= (gameWidth / 2) - (player.getWidth() / 2)) {
			currentState = GameState.SPLASH;
		}
		
	}
	
	public void updateSplash(float delta) {
		
		player.setVelocityX(0);
		
	}
	
	public void updateSplashPost(float delta) {
		
		player.setVelocityX(400);
		
		if (player.getX() >= gameWidth + 100) {
			isFadingOut = true;
			currentState = GameState.PLAYING_PRE;
			player.setX(-100);
			player.setY(100);
			player.setShouldHover(false);
		}
		
	}
	
	public void updatePlayingPre(float delta) {
		
		isFadingOut = false;
		
		player.setVelocityX(200);
		
		if (player.getX() >= 100) {
			player.setVelocityX(0);
		}
		
	}
	
	/*
	 * Getters and setters
	 */
	public Player getPlayer() { return player; }
	
	public ScrollHandler getScrollHandler() { return scrollHandler; }
	
	public GameState getCurrentState() { return currentState; }
	
	public void setCurrentState(GameState gameState) { currentState = gameState; }
	
	public boolean isFadingOut() { return isFadingOut; }
	
}
