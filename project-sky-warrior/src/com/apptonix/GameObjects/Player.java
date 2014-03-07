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
	
	private boolean shouldHover = false;
	private boolean isGoingDown = true;
	private boolean hoverStartingPosSet = false;
	
	private int hoverStartingPos = 0;
	private int hoverVariance = 100;
	private int hoverSpeed = 20;
	
	public Player(float x, float y, int width, int height) {
		
		this.width = width;
		this.height = height;
		
		this.startingPos = x;
		
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 0);
		
		hitBox = new Rectangle();
		
	}
	
	public void update(float delta) {
		
		// Set the hit box over the player
		hitBox.set(position.x, position.y, width, height);
		
		// TODO Temporary
		// Hover the plane if it should
		if (shouldHover) {
			playerHover();
		}
	// TODO Does not work
	public void playerHover() {
		
		if (hoverStartingPosSet == false) {
			hoverStartingPos = (int) position.y;
			hoverStartingPosSet = true;
		}
		
		System.out.println(getY());
		
		if (isGoingDown) {
			setVelocityY(hoverSpeed);
			
			if (getY() >= hoverStartingPos + hoverVariance) {
				isGoingDown = false;
			}
		}
		else {
			position.x -= dipSpeed;
			setVelocityY(-hoverSpeed);
			
			if (getY() <= hoverStartingPos - hoverVariance) {
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
