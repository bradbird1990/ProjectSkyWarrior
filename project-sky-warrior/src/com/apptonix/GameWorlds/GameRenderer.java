package com.apptonix.GameWorlds;

import com.apptonix.GameHelpers.AssetLoader;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameRenderer {
	
	private GameWorld world;
	private OrthographicCamera camera;
	
	private int gameHeight;
	
	private SpriteBatch spriteBatcher;
	
	private TextureRegion
		backgroundDesert,
		planeRed;
	
	private boolean debugMode = false;
	
	public GameRenderer(GameWorld pWorld, int gameHeight) {
		
		world = pWorld;
		
		this.gameHeight = gameHeight;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 136, 204); // TODO This needs changing
		
		spriteBatcher = new SpriteBatch();
		spriteBatcher.setProjectionMatrix(camera.combined);
		
		initGameObjects();
		initAssets();
		
	}
	
	public void render(float runTime) {
		
		
		
	}
	
	/*
	 * Load the game objects into the game renderer
	 */
	private void initGameObjects() {
		
		
		
	}
	
	/*
	 * Load the assets into the game renderer
	 */
	private void initAssets() {
		
		backgroundDesert = AssetLoader.backgroundDesert;
		planeRed = AssetLoader.planeRed;
		
	}

}
