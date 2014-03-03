package com.apptonix.GameObjects;

import com.apptonix.GameWorlds.GameWorld;

public class ScrollHandler {
	
	private GameWorld world;
	
	private Background
		background,
		background2;
	
	public static final int SCROLL_SPEED = -300;
	
	public ScrollHandler(GameWorld pWorld) {
		
		this.world = pWorld;
		
		background = new Background(0, 0, 1280, 720, SCROLL_SPEED);
		background2 = new Background(background.getObjectEnd(), 0, 1280, 720, SCROLL_SPEED);
		
	}
	
	public void update(float delta) {
		
		background.update(delta);
		background2.update(delta);
		
		if (background.scrolledLeft()) {
			background.reset(background2.getObjectEnd());
		}
		else if (background2.scrolledLeft()) {
			background2.reset(background.getObjectEnd());
		}
		
	}
	
	/*
	 * Setters and getters
	 */
	public Background getBackground() { return background; }
	
	public Background getBackground2() { return background2; }

}
