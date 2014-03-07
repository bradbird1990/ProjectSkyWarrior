package com.apptonix.GameHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	
	public static Texture
		splashLogoRaw,
		backgroundsRaw,
		planesRaw;
	
	public static TextureRegion
		splashLogo,
		backgroundDesert,
		planeRed;
	
	public static Music
		introMusic;
	
	/*
	 * Load in the textures from the assets folder
	 */
	public static void load() {
		
		/*
		 * Load the logos
		 */
		splashLogoRaw = new Texture(Gdx.files.internal("data/logos/projectskywarrior.png"));
		splashLogoRaw.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		splashLogo = new TextureRegion(splashLogoRaw, 0, 0, 1024, 512);
		splashLogo.flip(false, true);
		
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
		planesRaw = new Texture(Gdx.files.internal("data/spritesheets/planes.png"));
		planesRaw.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		planeRed = new TextureRegion(planesRaw, 0, 0, 95, 72);
		planeRed.flip(false, true);
		
		/*
		 * Load the music
		 */
		introMusic = Gdx.audio.newMusic(Gdx.files.internal("data/music/intromusic.ogg"));
		
	}
	
	/*
	 * Dispose of the textures after use
	 */
	public static void dispose() {
		
		splashLogoRaw.dispose();
		backgroundsRaw.dispose();
		planesRaw.dispose();
		
		introMusic.dispose();
		
	}

}
