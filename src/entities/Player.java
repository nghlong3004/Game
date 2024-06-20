package entities;

import static util.Constans.*;
import static util.Constans.PlayerConstans.*;
import static util.LoadingImageSave.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Player extends Entity{
	
	private BufferedImage animations[][];
	
	private int playerAction = IDLE;
	private int implement = 0;
	private int nonFps = 0;
	private int action = 0;
	
	private float up = 0f, down = 0f, left = 0f, right = 0f;
	private boolean attacking = false;
	
	public Player(float x, float y, GamePanel gamePanel) {
		super(x, y, gamePanel);
		importAnimations();
	}
	private void updateState() {
		int currentPlayerAction = playerAction;
		if(action == 0) {
			playerAction = IDLE;
		}
		else if(action == 1) {
			playerAction = RUNNING;
		}
		else if(action == 2) {
			playerAction = ATTACK;
		}
		long oldTime = 0;
		if(System.currentTimeMillis() - oldTime >= 1000) {
			oldTime = System.currentTimeMillis();
			++nonFps;
		}
		if(nonFps >= 20) {
			nonFps = 0;
			implement = (implement + 1) % GetNumberPlayerConstants(playerAction);
		}
		if(currentPlayerAction != playerAction) {
			implement = 0;
		}
	}
	public void update() {
		updatePosition();
		updateAction();
		updateState();
	}
	
	public void render(Graphics g) {
		g.drawImage(getAnimation(),(int) x,(int) y, PLAYER_WIDTH, PLAYER_HEIGHT, null);
	}
	
	private BufferedImage getAnimation() {
		return animations[playerAction][implement];
	}
	public void updatePosition() {
		double xDelta = (double) SPEED_PLAYER;
		double yDelta = (double) SPEED_PLAYER;
		if(left != 0) {
			xDelta *=  left;
			action = 1;
		}
		else {
			xDelta *= right;
			action = 1;
		}
		
		this.x += xDelta;
		
		if(this.x <= 0) {
			this.x = 0;
		}
		if(x + PLAYER_WIDTH >= gamePanel.getWidth()) {
			x = gamePanel.getWidth() - PLAYER_WIDTH;
		}
		
		if(up != 0) {
			yDelta *= up;
			action = 1;
		}
		else {
			yDelta *= down;
			action = 1;
		}
		this.y += yDelta;
		
		if(this.y <= 0) {
			this.y = 0;
		}
		if(y + PLAYER_HEIGHT >= gamePanel.getHeight()) {
			y = gamePanel.getHeight() - PLAYER_HEIGHT;
		}
		if(xDelta == 0 && yDelta == 0) {
			action = 0;
		}
	}
	public void updateAction() {
		if(attacking) {
			action = 2;
		}
	}
	public void setState(int state) {
		playerAction = state;
	}
	
	private void importAnimations() {
		BufferedImage image = GetSpriteAtlas(IMAGE_FILE_PATH_PLAYER);
		animations = new BufferedImage[QUANTITY_ANIMATION][6];
		for(int i = 0; i < QUANTITY_ANIMATION; ++i) {
			for(int j = 0; j < 6; ++j) {
				animations[i][j] = image.getSubimage(j * IMAGE_PLAYER_WIDTH, i * IMAGE_PLAYER_HEIGHT, IMAGE_PLAYER_WIDTH, IMAGE_PLAYER_HEIGHT);
			}
		}
	}
	public void setAnimations(BufferedImage[][] animations) {
		this.animations = animations;
	}
	public void setPlayerAction(int playerAction) {
		this.playerAction = playerAction;
	}
	public void setImplement(int implement) {
		this.implement = implement;
	}
	public void setNonFps(int nonFps) {
		this.nonFps = nonFps;
	}
	public void setUp(float up) {
		this.up = up;
	}
	public void setDown(float down) {
		this.down = down;
	}
	public void setLeft(float left) {
		this.left = left;
	}
	public void setRight(float right) {
		this.right = right;
	}
	public void setAttacking(boolean attacking) {
		this.attacking = attacking;
	}
	
	
}
