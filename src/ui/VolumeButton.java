package ui;

import static util.Constants.UIConstants.VolumeButton.*;
import static util.Constants.ImageCaptureConstants.*;
import static util.LoadingImageSave.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class VolumeButton extends PauseButton implements OptionButton{

	private BufferedImage[] imgs;
	private BufferedImage slider;
	
	private int index = 0;
	private int buttonX = 0;
	private int minSlider, maxSlider;
	
	private boolean mouseOver = false, mousePressed = false;
	
	
	public VolumeButton(int xPos, int yPos, int width, int height) {
		super(xPos + width / 2, yPos, VOLUME_WIDTH, height);
		hitbox.x -= VOLUME_WIDTH / 2;
		this.buttonX = xPos + width / 2;
		
		this.x = xPos;
		this.width = width;
		this.minSlider = x + VOLUME_WIDTH / 2;
		this.maxSlider = x + width - VOLUME_WIDTH / 2;
				
		loadImages();
	}
	
	
	@Override
	public void loadImages() {
		imgs = new BufferedImage[3];
		BufferedImage image = GetSpriteAtlas(IMAGE_FILE_PATH_MENU_VOLUME);
		for(int i = 0; i < imgs.length; ++i) {
			imgs[i] = image.getSubimage(i * VOLUME_WIDTH_DEFAULT, 0, VOLUME_WIDTH_DEFAULT, VOLUME_HEIGHT_DEFAULT);
		}
		slider = image.getSubimage(3 * VOLUME_WIDTH_DEFAULT, 0, SLIDER_DEFAULT, VOLUME_HEIGHT_DEFAULT);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
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
		g.drawImage(slider, x, y, width, height, null);
		g.drawImage(imgs[index], buttonX - VOLUME_WIDTH / 2, y, VOLUME_WIDTH, height, null);
		
	}

	@Override
	public void reset() {
		mouseOver = false;
		mousePressed = false;
		
	}
	
	public void changeButtonX(int buttonX) {
		if(buttonX < minSlider) {
			this.buttonX = minSlider;
		}
		else if (buttonX > maxSlider) {
			this.buttonX = maxSlider;
		}
		else {
			this.buttonX = buttonX;
		}
		hitbox.x = buttonX - VOLUME_WIDTH / 2;
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
