package com.apptonix.GameWorlds;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.apptonix.GameHelpers.AssetLoader;
import com.apptonix.GameHelpers.SpriteAccessor;
import com.apptonix.GameObjects.Background;
import com.apptonix.GameObjects.Player;
import com.apptonix.GameObjects.ScrollHandler;
import com.apptonix.GameObjects.Soldier;
import com.apptonix.GameWorlds.GameWorld.GameState;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameRenderer {
	
	private GameWorld world;
	private OrthographicCamera camera;
	
	private int
		gameHeight,
		gameWidth;
	
	private ScrollHandler
		scrollHandler;
	
	private Player
		player;
	
	private Soldier
		soldier;
	
	private SpriteBatch
		spriteBatcher;
	
	private Background
		background,
		background2;
	
	private TextureRegion
		blackOverlay,
		splashLogo,
		buttonPlay,
		backgroundDesert,
		planeRed;
	
	private Animation
		buttonPlayAnimation,
		soldierAnimation;
	
	private ShapeRenderer
		backgroundColour;
	
	private boolean debugMode = false;
	
	public GameRenderer(GameWorld pWorld, int pGameHeight, int pGameWidth) {
		
		world = pWorld;
		
		gameHeight = pGameHeight;
		gameWidth = pGameWidth;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1280, 720); // TODO This needs changing
		
		backgroundColour = new ShapeRenderer();
		backgroundColour.setProjectionMatrix(camera.combined);
		
		spriteBatcher = new SpriteBatch();
		spriteBatcher.setProjectionMatrix(camera.combined);
		
		initGameObjects();
		initAssets();
		
	}
	
	public void render(float runTime) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		backgroundColour.begin(ShapeType.Filled);
		
		backgroundColour.setColor(100 / 255.0f, 150 / 255.0f, 255 / 255.0f, 1);
		backgroundColour.rect(0, 0, gameWidth, gameHeight);
		
		backgroundColour.end();
		
		spriteBatcher.begin();
		
		spriteBatcher.draw(backgroundDesert, background.getX(), background.getY(), background.getWidth(), background.getHeight());
		spriteBatcher.draw(backgroundDesert, background2.getX(), background2.getY(), background2.getWidth(), background2.getHeight());
		
		spriteBatcher.draw(planeRed, player.getX(), player.getY(), player.getWidth(), player.getHeight());
		spriteBatcher.draw(soldierAnimation.getKeyFrame(runTime), soldier.getX(), soldier.getY(), soldier.getWidth(), soldier.getHeight());
		
		if (world.getCurrentState() == GameState.SPLASH_PRE || world.getCurrentState() == GameState.SPLASH || world.getCurrentState() == GameState.SPLASH_POST) {
			spriteBatcher.draw(splashLogo, (gameWidth / 2) - (splashLogo.getRegionWidth() / 2), 50, splashLogo.getRegionWidth(), splashLogo.getRegionHeight());
		}
		
		if (world.getCurrentState() == GameState.SPLASH) {
			spriteBatcher.draw(buttonPlayAnimation.getKeyFrame(runTime), (gameWidth / 2) - (buttonPlay.getRegionWidth() / 2), player.getY() - buttonPlay.getRegionHeight() - 30, buttonPlay.getRegionWidth(), buttonPlay.getRegionHeight());
		}
		
		// TODO Temporary - Need to fix
		if (world.isFadingOut()) {
//			spriteBatcher.draw(blackOverlay, -5, -5, gameWidth + 10, gameHeight + 10);
		}

		spriteBatcher.end();
		
	}
	
	/*
	 * Load the game objects into the game renderer
	 */
	private void initGameObjects() {
		
		player = world.getPlayer();
		
		scrollHandler = world.getScrollHandler();
		
		background = scrollHandler.getBackground();
		background2 = scrollHandler.getBackground2();
		
	}
	
	/*
	 * Load the assets into the game renderer
	 */
	private void initAssets() {
		
		blackOverlay = AssetLoader.blackOverlay;
		splashLogo = AssetLoader.splashLogo;
		buttonPlay = AssetLoader.buttonPlay1;
		buttonPlayAnimation = AssetLoader.buttonPlayAnimation;
		backgroundDesert = AssetLoader.backgroundDesert;
		planeRed = AssetLoader.planeRed;
		
	}

}
