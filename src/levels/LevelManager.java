package levels;

import static util.LoadingImageSave.*;
import static util.Constants.ImageCaptureConstants.*;
import static util.Constants.GameConstants.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.GameRun;

public class LevelManager {
	
	private LevelOne levelOne;
	
	private BufferedImage[] levelSprites;
	
	public LevelManager(GameRun gameRun) {
		levelOne = new LevelOne(GetlevelData());
		importImages();
	}
	
	private void importImages() {
		BufferedImage image = GetSpriteAtlas(IMAGE_FILE_PATH_LEVEL);
		levelSprites = new BufferedImage[MAX_LEVEL_IMAGE];
		for(int j = 0; j < 4; ++j) {
			for(int i = 0; i < 12; ++i) {
				int index = j * 12 + i;
				levelSprites[index] = image.getSubimage(i * TILE_DEFAULT_SIZE, j * TILE_DEFAULT_SIZE, TILE_DEFAULT_SIZE, TILE_DEFAULT_SIZE);
			}
		}
	}
	
	public void render(Graphics g, int xLvlOffset) {
		for(int i = 0; i < TILES_IN_HEIGHT; ++i) {
			for(int j = 0; j < levelOne.getLvlData()[0].length; ++j) {
				int index = levelOne.getIndex(j, i);
				g.drawImage(levelSprites[index], TILES_SIZE * j - xLvlOffset, TILES_SIZE * i, TILES_SIZE, TILES_SIZE, null);
			}
		}
	}
	public void update() {
		
	}
	
	public LevelOne getLevelOne() {
		return this.levelOne;
	}
	
}
