package entities;

import main.GamePanel;

public abstract class Entity {
	
	protected float x;
	protected float y;
	protected GamePanel gamePanel;
	
	public Entity(float x, float y, GamePanel gamePanel) {
		this.x = x;
		this.y = y;
		this.gamePanel = gamePanel;
	}
}
