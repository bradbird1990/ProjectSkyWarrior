package com.apptonix.GameHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	
	public static Texture
		backgroundsRaw,
		planesRaw;
	
	public static TextureRegion
		backgroundDesert,
		planeRed;
	
	/*
	 * Load in the textures from the assets folder
	 */
	public static void load() {
		
		/*
		 * Load the backgrounds
		 */
		backgroundsRaw = new Texture(Gdx.files.internal("data/backgrounds/desert.png"));
		backgroundsRaw.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		backgroundDesert = new TextureRegion(backgroundsRaw, 0, 0, 1024, 512);
		
		/*
		 * Load the game object sprites
		 */
		planesRaw = new Texture(Gdx.files.internal("data/spritesheets/planes.png"));
		planesRaw.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		planeRed = new TextureRegion(planesRaw, 0, 0, 95, 72);
		
	}
	
	/*
	 * Dispose of the textures after use
	 */
	public static void dispose() {
		
		backgroundsRaw.dispose();
		planesRaw.dispose();
		
	}

}
