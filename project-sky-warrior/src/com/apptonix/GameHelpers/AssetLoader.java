package com.apptonix.GameHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	
	public static Texture
		uiRaw,
		backgroundsRaw,
		spritesheetRaw;
	
	public static TextureRegion
		blackOverlay,
		splashLogo,
		buttonPlay1, buttonPlay2,
		soldierRunning1, soldierRunning2, soldierRunning3,
		backgroundDesert,
		planeRed;
	
	public static Animation
		buttonPlayAnimation,
		soldierRunningAnimation;
	
	public static Music
		introMusic;
	
	/*
	 * Load in the textures from the assets folder
	 */
	public static void load() {
		
		/*
		 * Load the UI
		 */
		uiRaw = new Texture(Gdx.files.internal("data/ui/ui.png"));
		uiRaw.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		splashLogo = new TextureRegion(uiRaw, 0, 0, 695, 256);
		splashLogo.flip(false, true);
		
		/*
		 * Load the buttons
		 */
		buttonPlay1 = new TextureRegion(uiRaw, 0, 256, 150, 58);
		buttonPlay1.flip(false, true);
		
		buttonPlay2 = new TextureRegion(uiRaw, 150, 256, 150, 58);
		buttonPlay2.flip(false, true);
		
		TextureRegion[] buttonPlayFrames = { buttonPlay1, buttonPlay2 };
		buttonPlayAnimation = new Animation(0.2f, buttonPlayFrames);
		buttonPlayAnimation.setPlayMode(Animation.LOOP);
		
		/*
		 * Load misc UI
		 */
		blackOverlay = new TextureRegion(uiRaw, 695, 0, 1, 1);
		
		/*
		 * Load the backgrounds
		 */
		backgroundsRaw = new Texture(Gdx.files.internal("data/backgrounds/backgrounds.png"));
		backgroundsRaw.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		backgroundDesert = new TextureRegion(backgroundsRaw, 0, 0, 2048, 226);
		backgroundDesert.flip(false, true);
		
		/*
		 * Load the game object sprites
		 */
		spritesheetRaw = new Texture(Gdx.files.internal("data/spritesheets/spritesheet.png"));
		spritesheetRaw.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		planeRed = new TextureRegion(spritesheetRaw, 0, 0, 95, 72);
		planeRed.flip(false, true);
		
		soldierRunning1 = new TextureRegion(spritesheetRaw, 0, 72, 25, 42);
		soldierRunning1.flip(false, true);
		
		soldierRunning2 = new TextureRegion(spritesheetRaw, 25, 72, 38, 42);
		soldierRunning2.flip(false, true);
		
		soldierRunning3 = new TextureRegion(spritesheetRaw, 63, 72, 26, 42);
		soldierRunning3.flip(false, true);
		
		TextureRegion[] soldierRunningFrames = { soldierRunning1, soldierRunning2, soldierRunning3 };
		soldierRunningAnimation = new Animation(0.2f, soldierRunningFrames);
		soldierRunningAnimation.setPlayMode(Animation.LOOP_PINGPONG);
		
		/*
		 * Load the music
		 */
		introMusic = Gdx.audio.newMusic(Gdx.files.internal("data/music/intromusic.ogg"));
		
	}
	
	/*
	 * Dispose of the textures after use
	 */
	public static void dispose() {
		
		uiRaw.dispose();
		backgroundsRaw.dispose();
		spritesheetRaw.dispose();
		
		introMusic.dispose();
		
	}

}
