package entities;

import static util.Constants.ImageCaptureConstants.*;
import static util.Constants.GameConstants.*;
import static util.Constants.PlayerConstants.*;
import static util.LoadingImageSave.*;
import static util.HelpMethod.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends Entity{
	
	private BufferedImage animations[][];
	
	private int playerAction = IDLE;
	private int implement = 0;
	private int nonFps = 0;
	private int action = 0;
	
	private int [][] lvlData;
	
	private float left = 0f, right = 0f;
	private float yDelta = 0f;
	private float graviti = 0.04f * SCALE;
	private float jumSpeed = -2.25f* SCALE;
	private float fallSpeedAfterCollsion = 0.5f * SCALE;
	
	private float xDraw = 21 * SCALE;
	private float yDraw = 4 * SCALE;
	
	private boolean inAir = false;
	private boolean attacking = false;
	private boolean jump = false;
	
	public Player(float x, float y, int width, int height) {
		super(x, y, width, height);
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
		else if(action == 3) {
			if(yDelta < 0) {
				playerAction = JUMP;
			}
			else {
				playerAction = FALLING;
			}
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
		g.drawImage(getAnimation(),(int) (hitbox.x - xDraw),(int) (hitbox.y - yDraw + 1), PLAYER_WIDTH, PLAYER_HEIGHT , null);
	}
	
	private BufferedImage getAnimation() {
		return animations[playerAction][implement];
	}
	public void updatePosition() {
		float xDelta = updateDelta((float) SPEED_PLAYER, this.left, this.right);
		
		if(jump) {
			jump();
		}
		
		if(!inAir) {
			if(!IsEntityOnFloor(hitbox, lvlData)) {
				inAir = true;
			}
		}
		if(xDelta == 0 && !inAir) {
			action = 0;
			return;
		}
		
		if(inAir) {
			if(CanMove(hitbox.x, hitbox.y + yDelta, hitbox.width, hitbox.height, lvlData)) {
				hitbox.y += yDelta;
				yDelta += graviti;
			}
			else {
				hitbox.y = GetEnityYPosNextToWall(hitbox, yDelta);
				if(yDelta > 0) {
					resetInAir();
				}
				else {
					 yDelta = fallSpeedAfterCollsion;
				}
			}
		}
		updateXSpos(xDelta);
		
	}
	
	private void jump() {
		if(inAir) {
			return;
		}
		inAir = true;
		yDelta = jumSpeed;
	}
	private void resetInAir() {
		inAir = false;
		yDelta = 0;
		
	}
	private void updateXSpos(float xDelta) {
		if(CanMove(hitbox.x + xDelta, hitbox.y, hitbox.width, hitbox.height, lvlData)) {
			hitbox.x += xDelta;
		}
		else {
			hitbox.x = GetEnityXPosNextToWall(hitbox, xDelta);
		}
	}
	
	private float updateDelta(float Delta, float up, float down ) {
		if(up != 0) {
			Delta *= up;
			action = 1;
		}
		else {
			Delta *= down;
			action = 1;
		}
		return Delta;
	}
	
	public void updateAction() {
		if(attacking) {
			action = 2;
		}
		if(inAir) {
			action = 3;
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
	
	public void importLvlData(int[][] lvlData) {
		this.lvlData = lvlData;
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
	public void setLeft(float left) {
		this.left = left;
	}
	public void setRight(float right) {
		this.right = right;
	}
	public void setAttacking(boolean attacking) {
		this.attacking = attacking;
	}
	public void setJump(boolean jump) {
		this.jump = jump;
	}
	
}
