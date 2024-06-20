package main;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import input.KeyboardInput;
import input.MouseInput;

import static util.Constans.PlayerConstans.*;
import static util.Constans.*;

public class GamePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MouseInput mouseInput;
	
	private KeyboardInput keyboardInput;
	
	private BufferedImage image;
	private BufferedImage animations[][];
	
	private int playerAction = IDLE;
	private int implement = 0;
	private int nonFps = 0;
	private int x = 0, y = 0;
	
	public void setMouseMoved(int x, int y) {
		
	}
	
	public void changeX(int xDelta) {
		this.x += xDelta;
		if(x <= 0) {
			x = 0;
		}
		if(x + PLAYER_WIDTH >= getWidth()) {
			x = getWidth() - PLAYER_WIDTH;
		}
	}
	public void changeY(int yDelta) {
		this.y += yDelta;
		if(y <= 0) {
			y = 0;
		}
		if(y + PLAYER_HEIGHT >= getHeight()) {
			y = getHeight() - PLAYER_HEIGHT;
		}
	}
	public void setState(int state) {
		playerAction = state;
	}
	
	
	public GamePanel() {
		importImage();
		importAnimations();
		
		input();
		
		setSize();
		
	}
	
	private void importImage() {
		InputStream inputStream = getClass().getResourceAsStream(IMAGE_FILE_PATH);
		try {
			image = ImageIO.read(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void importAnimations() {
		animations = new BufferedImage[QUANTITY_ANIMATION][6];
		for(int i = 0; i < QUANTITY_ANIMATION; ++i) {
			for(int j = 0; j < 6; ++j) {
				animations[i][j] = image.getSubimage(j * IMAGE_PLAYER_WIDTH, i * IMAGE_PLAYER_HEIGHT, IMAGE_PLAYER_WIDTH, IMAGE_PLAYER_HEIGHT);
			}
		}
		
	}

	private void input() {
		keyboardInput = new KeyboardInput(this);
		mouseInput = new MouseInput(this);
		addKeyListener(keyboardInput);
		addMouseListener(mouseInput);
		addMouseMotionListener(mouseInput);
	}

	private void setSize() {
		Dimension dimension = new Dimension(640, 400);
		setPreferredSize(dimension);
	}
	private BufferedImage getAnimation() {
		if(implement >= GetNumberPlayerConstants(playerAction)) {
			implement = 0;
		}
		return animations[playerAction][implement];
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		updateState();
		
		g.drawImage(getAnimation(), x, y, PLAYER_WIDTH, PLAYER_HEIGHT, null);
	}

	private void updateState() {
		long oldTime = 0;
		if(System.currentTimeMillis() - oldTime >= 1000) {
			oldTime = System.currentTimeMillis();
			++nonFps;
		}
		if(nonFps >= 20) {
			nonFps = 0;
			implement = (implement + 1) % GetNumberPlayerConstants(playerAction);
		}
		
	}
	
	
}
