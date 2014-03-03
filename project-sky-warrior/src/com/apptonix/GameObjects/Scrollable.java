package com.apptonix.GameObjects;

import com.badlogic.gdx.math.Vector2;

public class Scrollable {
	
	protected Vector2 position;
	protected Vector2 velocity;
	
	protected int width;
	protected int height;
	
	protected boolean scrolledLeft;
	
	public Scrollable(float x, float y, int width, int height, float scrollSpeed) {
		
		position = new Vector2(x, y);
		velocity = new Vector2(scrollSpeed, 0);
		
		this.width = width;
		this.height = height;
		
		scrolledLeft = false;
		
	}
	
	public void update(float delta) {
		
		position.add(velocity.cpy().scl(delta));
		
		// Reset the scrolled left boolean if the object goes off the screen
		if (position.x + width < 0) {
			scrolledLeft = true;
		}
		
	}
	
	public void reset (float x) {
		
		position.x = x;
		scrolledLeft = false;
		
	}
	
	/*
	 * Setters and getters
	 */
	public float getX() { return position.x; }
	
	public float getY() { return position.y; }
	
	public int getWidth() { return width; }
	
	public int getHeight() { return height; }
	
	public boolean scrolledLeft() { return scrolledLeft; }
	
	public float getObjectEnd() { return position.x + width; } // TODO Maybe this method only belongs to the background class?

}
