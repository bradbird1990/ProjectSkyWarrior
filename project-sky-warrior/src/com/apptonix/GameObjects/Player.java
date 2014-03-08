package com.apptonix.GameObjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {

	protected Vector2 position;
	protected Vector2 velocity;
	
	private float rotation;
	private int width;
	private int height;
	
	private Rectangle hitBox;
	
	private int playerHealth = 100;
	private int playerState = 1;
	
	private boolean shouldHover = false;
	private boolean isGoingDown = true;
	private boolean hoverStartingPosSet = false;
	
	private int hoverStartingPos = 0;
	private int hoverVariance = 20;
	private int hoverSpeed = 50;
	
	public Player(float x, float y, int width, int height) {
		
		this.width = width;
		this.height = height;
		
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		
		hitBox = new Rectangle();
		
	}
	
	public void update(float delta) {
		
		// Set the hit box over the player
		hitBox.set(position.x, position.y, width, height);
		
		// Change player velocitys
		position.add(velocity.cpy().scl(delta));
		
		// Hover the plane if it should
		if (shouldHover) {
			playerHover();
		}
		
	}
	
	// TODO Does not work
	public void playerHover() {
		
		if (hoverStartingPosSet == false) {
			hoverStartingPos = (int) position.y;
			hoverStartingPosSet = true;
		}
		
		if (isGoingDown) {
			setVelocityY(hoverSpeed);
			
			if (getY() >= hoverStartingPos + hoverVariance) {
				isGoingDown = false;
			}
		}
		else {
			setVelocityY(-hoverSpeed);
			
			if (getY() <= hoverStartingPos - hoverVariance) {
				isGoingDown = true;
			}
		}
		
	}
	
	/*
	 * Basic setters and getters
	 */
	public float getY() { return position.y; }
	
	public void setY(float y) { this.position.y  = y; }
	
	public float getX() { return position.x; }
	
	public void setX(float x) { this.position.x = x; }
	
	public float getVelocityX() { return velocity.x; }
	
	public void setVelocityX(float x) { this.velocity.x = x; }
	
	public float getVelocityY() { return velocity.y; }
	
	public void setVelocityY(float y) { this.velocity.y = y; }
	
	public float getWidth() { return width; }
	
	public float getHeight() { return height; }
	
	public void setShouldHover(boolean b) { this.shouldHover = b; if (!b) { this.velocity.y = 0; } }
	
	public boolean getShouldHover() { return shouldHover; }
	
	public Rectangle getHitBox() { return hitBox; }
	
	public int getState() { return playerState; }
	
}
