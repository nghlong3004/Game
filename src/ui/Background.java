package ui;

import static util.LoadingImageSave.*;
import static util.Constants.GameConstants.GAME_HEIGHT;
import static util.Constants.GameConstants.GAME_WIDTH;
import static util.Constants.GameConstants.SCALE;
import static util.Constants.ImageCaptureConstants.*;
import static util.Constants.UIConstants.Cloud.*;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import util.Constants.GameConstants;

public class Background implements OptionButton{

	BufferedImage image;
	BufferedImage imageBigCloud;
	BufferedImage imageSmallCloud;
	
	private int changeX = 0;
	
	private int[] changeY;
	
	private Random random;
	
	public Background() {
		
		loadImages();
		
		loadInfo();
	}
	
	private void loadInfo() {
		changeY = new int[8];
		random = new Random();
		for(int i = 0; i < changeY.length; ++i) {
			changeY[i] = (int)(90 * SCALE) + random.nextInt((int)(150 * SCALE));
		}
	}

	@Override
	public void loadImages() {
		image = GetSpriteAtlas(IMAGE_FILE_PATH_BACKGROUND_PLAYING);
		imageBigCloud = GetSpriteAtlas(IMAGE_FILE_PATH_BIG_CLOUD);
		imageSmallCloud = GetSpriteAtlas(IMAGE_FILE_PATH_SMALL_CLOUD);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}
	public void update(int x) {
		changeX = x;
	}
	@Override
	public void draw(Graphics g) {
		g.drawImage(image, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);
		for(int i = 0; i < 3; ++i) {
			g.drawImage(imageBigCloud, BIG_CLOUD_WIDTH * i - (int)(changeX * 0.3), (int)(204 * GameConstants.SCALE), BIG_CLOUD_WIDTH , BIG_CLOUD_HEIGHT, null);
		}
		for(int i = 0; i < changeY.length; ++i) {
			g.drawImage(imageSmallCloud, SMALL_CLOUD_WIDTH * 4 * i - (int)(changeX * 0.7) , changeY[i], SMALL_CLOUD_WIDTH, SMALL_CLOUD_HEIGHT, null);
		}
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

}
