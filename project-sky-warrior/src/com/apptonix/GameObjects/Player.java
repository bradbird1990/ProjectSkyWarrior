package com.apptonix.GameObjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {

	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;
	
	private float rotation;
	private int width;
	private int height;
	
	private Rectangle hitBox;
	
	private int playerHealth = 100;
	private int playerState = 1;
	
	// TODO Temporary
	// Start Cool animation fields
	private float topPos = 50;
	private float bottomPos = 100;
	
	private boolean isGoingDown = true;
	
	private int dipSpeed = 1;
	// End cool animation fields
	
	public Player(float x, float y, int width, int height) {
		
		this.width = width;
		this.height = height;
		
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 0);
		
		hitBox = new Rectangle();
		
	}
	
	public void update(float delta) {
		
		// Set the hit box over the player
		hitBox.set(position.x, position.y, width, height);
		
		// TODO Temporary
		if (isGoingDown) {
			position.x += dipSpeed;
			
			if (position.x >= bottomPos) {
				isGoingDown = false;
			}
		}
		else {
			position.x -= dipSpeed;
			
			if (position.x <= topPos) {
				isGoingDown = true;
			}
		}
		
	}
	
	/*
	 * Basic setters and getters
	 */
	public float getY() { return position.x; }
	
	public void setY(float y) { this.position.y  = y; }
	
	public float getX() { return position.y; }
	
	public void setX(float x) { this.position.x = x; }
	
	public float getWidth() { return width; }
	
	public float getHeight() { return height; }
	
	public Rectangle getHitBox() { return hitBox; }
	
	public int getState() { return playerState; }
	
}
