package com.apptonix.GameWorlds;

import com.apptonix.GameHelpers.AssetLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameRenderer {
	
	private GameWorld world;
	private OrthographicCamera camera;
	
	private int
		gameHeight,
		gameWidth;
	
	private SpriteBatch spriteBatcher;
	
	private TextureRegion
		backgroundDesert,
		planeRed;
	
	private boolean debugMode = false;
	
	public GameRenderer(GameWorld pWorld, int gameHeight, int gameWidth) {
		
		world = pWorld;
		
		this.gameHeight = gameHeight;
		this.gameWidth = gameWidth;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1280, 720); // TODO This needs changing
		
		spriteBatcher = new SpriteBatch();
		spriteBatcher.setProjectionMatrix(camera.combined);
		
		initGameObjects();
		initAssets();
		
	}
	
	public void render(float runTime) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		spriteBatcher.begin();
		
		spriteBatcher.draw(backgroundDesert, 0, 0, this.gameWidth, this.gameHeight);
		
		spriteBatcher.end();
		
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
