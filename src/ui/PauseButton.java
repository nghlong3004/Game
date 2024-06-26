package ui;

import static util.Constants.UIConstants.Buttons.*;

import java.awt.Rectangle;

public class PauseButton{

	protected int x, y, width, height;
	
	protected Rectangle hitbox;
	
	public PauseButton(int xPos, int yPos, int width, int height) {
		
		this.x = xPos;
		this.y = yPos;
		this.width = width;
		this.height = height;
		
		initHitbox();
		
	}
	public void initHitbox() {
		hitbox = new Rectangle(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
		
	}
	public Rectangle getHitbox() {
		return hitbox;
	}
	
	
	
}
