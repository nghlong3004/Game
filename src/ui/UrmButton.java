package ui;

import static util.Constants.UIConstants.UrmButton.*;
import static util.LoadingImageSave.*;
import static util.Constants.ImageCaptureConstants.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UrmButton extends PauseButton implements OptionButton{

	private BufferedImage[] imgs;
	private int rowIndex, index;
	private boolean mouseOver = false, mousePressed = false;
	
	public UrmButton(int xPos, int yPos, int width, int height, int rowIndex) {
		super(xPos, yPos, width, height);
		this.rowIndex = rowIndex;
		loadImages();
	}
	@Override
	public void loadImages() {
		imgs = new BufferedImage[3];
		BufferedImage image = GetSpriteAtlas(IMAGE_FILE_PATH_MENU_URM);
		for(int j = 0; j < imgs.length; ++j) {
			imgs[j] = image.getSubimage(j * URM_SIZE_DEFAULT, rowIndex * URM_SIZE_DEFAULT, URM_SIZE_DEFAULT, URM_SIZE_DEFAULT);
		}
		
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
	public void draw(Graphics g) {
		g.drawImage(imgs[index], x, y, URM_SIZE, URM_SIZE, null);
	}
	@Override
	public void reset() {
		this.mouseOver = false;
		this.mousePressed = false;
	}

	public boolean isMouseOver() {
		return mouseOver;
	}

	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}

	public boolean isMousePressed() {
		return mousePressed;
	}

	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
	}
	
	
}
