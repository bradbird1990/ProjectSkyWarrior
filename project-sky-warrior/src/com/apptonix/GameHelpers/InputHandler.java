package com.apptonix.GameHelpers;

import com.apptonix.GameObjects.Player;
import com.apptonix.GameWorlds.GameWorld;
import com.apptonix.GameWorlds.GameWorld.GameState;
import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor {
	
	private GameWorld world;
	private Player player;
	
	public InputHandler(GameWorld pWorld) {
		
		this.world = pWorld;
		player = world.getPlayer();
		
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		
		//
		if (world.getCurrentState() == GameState.SPLASH) {
			world.setCurrentState(GameState.SPLASH_POST);
		}
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
