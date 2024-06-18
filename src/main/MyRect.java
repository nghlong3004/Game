package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class MyRect {
	
	private float x, y, xDelta, yDelta;
	private int w, h;
	private Random random;
	private GamePanel gamePanel;
	private Color color;
	
	public MyRect(float x, float y, GamePanel gamePanel) {
		random = new Random();
		this.x = x;
		this.y = y;
		xDelta = 1f;
		yDelta = 1f;
		w = random.nextInt(40);
		h = random.nextInt(20);	
		this.gamePanel = gamePanel;
	}
	
	public void setXY() {
		x += xDelta;
		y += yDelta;
		if(x <= 0 || x + w >= gamePanel.getWidth()) {
			xDelta *= -1;
			color = getRndColor();
			if(x <= 0) {
				x = 0;
			}
			else {
				x = gamePanel.getWidth() - w;
			}
		}
		if(y <= 0 || y + h >= gamePanel.getHeight()) {
			yDelta *= -1;
			color = getRndColor();
			if(y <= 0) {
				y = 0;
			}
			else {
				y = gamePanel.getHeight() - h;
			}
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect((int)x,(int) y, w, h);
		
	}
	private Color getRndColor() {
		
		int l = random.nextInt(255);
		int r = random.nextInt(255);
		int h = random.nextInt(255);
		
		return new Color(l, r, h);
	}
	
	
}
