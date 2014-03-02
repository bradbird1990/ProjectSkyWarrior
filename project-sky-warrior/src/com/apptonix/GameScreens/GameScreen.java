package com.apptonix.GameScreens;

import com.apptonix.GameHelpers.InputHandler;
import com.apptonix.GameWorlds.GameWorld;
import com.apptonix.GameWorlds.GameRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen {
	
	private GameWorld gameWorld;
	private GameRenderer gameRenderer;
	
	// TODO Not 100% sure what this is; Look at Kilobolt
	private float runTime = 0;

	public GameScreen() {
		
		/*
		 * Set the game dimensions
		 */
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		
		float gameWidth = 1280;
		float gameHeight = screenHeight / (screenWidth / gameWidth);
		
		/*
		 * Setup the game world
		 */
		gameWorld = new GameWorld();
		gameRenderer = new GameRenderer(gameWorld, (int) gameHeight, (int) gameWidth);
		
		/*
		 * Assign the game world to the input handler
		 */
		Gdx.input.setInputProcessor(new InputHandler(gameWorld));
		
	}
	
	@Override
	public void render(float delta) {
		
		runTime += delta;
		gameWorld.update(delta);
		gameRenderer.render(runTime);
		
	}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void show() {}

	@Override
	public void hide() {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void dispose() {}

}
