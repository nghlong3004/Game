package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import input.KeyboardInput;
import input.MouseInput;

public class GamePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MouseInput mouseInput;
	
	private float xDelta = 0, yDelta = 0;
	public void setXY(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
	}
	
	private float stateX = 1f, stateY = 1f;
	
	private Color color;
	
	private Random random;
	
	private ArrayList<MyRect> rects = new ArrayList<>();
	public void setRect(float x, float y) {
		rects.add(new MyRect(x, y, this));
	}
	
	public GamePanel() {
		setBounds(0, 0, 300, 300);
		
		addKeyListener(new KeyboardInput(this));
		
		mouseInput = new MouseInput(this);
		addMouseListener(mouseInput);
		//addMouseMotionListener(mouseInput);
		random = new Random();
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		updateRectangle();
		for(MyRect rect: rects) {
			rect.setXY();
			rect.draw(g);
		}
		g.setColor(color);
		g.fillRect((int)xDelta, (int)yDelta, 40, 20);
	}
	private void updateRectangle() {
		this.xDelta += stateX;
		this.yDelta += stateY;
		if(this.xDelta <= 0 || this.xDelta + 40 >= this.getWidth()) {
			stateX *= -1f;
			color = getRndColor();
			if(xDelta <= 0) {
				xDelta = 0;
			}
			else {
				xDelta = this.getWidth() - 40;
			}
		}
		if(this.yDelta <= 0 || this.yDelta + 20 >= this.getHeight()) {
			stateY *= -1f;
			color = getRndColor();
			if(yDelta <= 0) {
				yDelta = 0;
			}
			else {
				yDelta = this.getHeight() - 20;
			}
		}
	}
	private Color getRndColor() {
		
		int l = random.nextInt(255);
		int r = random.nextInt(255);
		int h = random.nextInt(255);
		
		return new Color(l, r, h);
	}
	
	
}
