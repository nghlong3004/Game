package ui;

import static util.LoadingImageSave.*;
import static util.Constants.UIConstants.PauseButton.*;
import static util.Constants.ImageCaptureConstants.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SoundButton extends PauseButton implements OptionButton{

	private BufferedImage[][] pauseImgs;
	
	private int muted = 0;
	
	private int mousePressed = 0, mouseOver = 0;
	
	public SoundButton(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		loadImages();
	}
	@Override
	public void reset() {
		this.mouseOver = 0;
		this.mousePressed = 0;
	}
	@Override
	public void loadImages() {
		pauseImgs = new BufferedImage[2][3];
		BufferedImage image = GetSpriteAtlas(IMAGE_FILE_PATH_MENU_SOUND);
		for(int j = 0; j < pauseImgs.length; ++j) {
			for(int i = 0; i < pauseImgs[j].length; ++i) {
				pauseImgs[j][i] = image.getSubimage(i * SOUND_SIZE_DEFAULT, j * SOUND_SIZE_DEFAULT, SOUND_SIZE_DEFAULT,  SOUND_SIZE_DEFAULT);
			}
		}
		
	}
	@Override
	public void update() {
		
	}
	@Override
	public void draw(Graphics g) {
		g.drawImage(pauseImgs[muted][0 + mouseOver + mousePressed], x, y, width, height, null);
	}

	public int getMuted() {
		return muted;
	}

	public void setMuted(int muted) {
		this.muted = muted;
	}

	public int getMousePressed() {
		return mousePressed;
	}

	public void setMousePressed(int mousePressed) {
		this.mousePressed = mousePressed;
	}

	public int getMouseOver() {
		return mouseOver;
	}

	public void setMouseOver(int mouseOver) {
		this.mouseOver = mouseOver;
	}

	
	
	
}
