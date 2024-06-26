package ui;

import static util.Constants.UIConstants.Buttons.*;
import static util.Constants.ImageCaptureConstants.*;
import static util.LoadingImageSave.*;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import gameStates.GameState;

public class MenuButton implements OptionButton{
	
	private int xPos, yPos, rowIndex, index;
	
	private int xOffSetCenter = BUTTON_WIDTH / 2;
	
	private boolean mousePressed = false, mouseOver = false;
	
	private GameState state;
	
	private BufferedImage[] images;
	
	private Rectangle hitbox;
	
	public MenuButton(int xPos, int yPos, int rowIndex, GameState state) {
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.rowIndex = rowIndex;
		this.state = state;
		
		loadImages();
		
		initHitbox();
		
	}

	public void initHitbox() {
		hitbox = new Rectangle(xPos - xOffSetCenter, yPos, BUTTON_WIDTH, BUTTON_HEIGHT);
		
	}
	
	@Override
	public void loadImages() {
		images = new BufferedImage[3];
		BufferedImage image = GetSpriteAtlas(IMAGE_FILE_PATH_MENU);
		for(int i = 0; i < images.length; ++i) {
			images[i] = image.getSubimage(i * BUTTON_WIDTH_DEFAULT, rowIndex * BUTTON_HEIGHT_DEFAULT, BUTTON_WIDTH_DEFAULT, BUTTON_HEIGHT_DEFAULT);
		}
	}
	@Override
	public void draw(Graphics g) {
		g.drawImage(images[index], xPos - xOffSetCenter, yPos, BUTTON_WIDTH, BUTTON_HEIGHT, null);
	}
	@Override
	public void update() {
		index = 0;
		if(mouseOver) {
			index = 1;
		}
		if(mousePressed) {
			index = 2;
		}
		
	}
	@Override
	public void reset() {
		mouseOver = false;
		mousePressed = false;
	}
	public void applyGameState() {
		GameState.state = state;
	}

	public boolean isMousePressed() {
		return mousePressed;
	}

	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
	}

	public boolean isMouseOver() {
		return mouseOver;
	}

	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}
	
	public Rectangle getHixbox() {
		return hitbox;
	}
	
	
	
	
}
