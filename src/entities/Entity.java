package entities;

import static util.Constants.GameConstants.*;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public abstract class Entity {
	
	protected float x;
	protected float y;
	
	protected int width, height;
	
	protected Rectangle2D.Float hitbox;
	
	public Entity(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		initHitbox();
	}
	
	protected void drawHitbox(Graphics g) {
		
		g.drawRect((int)hitbox.x, (int)hitbox.y, (int)hitbox.width, (int)hitbox.height);
		
	}
	
	private void initHitbox() {
		hitbox = new Rectangle2D.Float(x, y,(float) width - HITBOX_WIDTH_OFF_SET,(float) height - HITBOX_HEIGHT_OFF_SET);
	}
	public Rectangle2D.Float getHitbox() {
		return this.hitbox;
	}
	
}
