package com.apptonix.psw;

import com.apptonix.GameHelpers.AssetLoader;
import com.apptonix.GameScreens.GameScreen;
import com.badlogic.gdx.Game;

public class ProjectSkyWarrior extends Game {
	
	@Override
	public void create() {		
		
		AssetLoader.load();
		setScreen(new GameScreen());
		
	}

	public void dispose() {
		
		super.dispose();
		AssetLoader.dispose();
		
	}

}
