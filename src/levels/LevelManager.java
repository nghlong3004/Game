package levels;

import static util.LoadingImageSave.*;
import static util.Constans.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.GameRun;

public class LevelManager {

	private GameRun gameRun;
	
	private LevelOne levelOne;
	
	private BufferedImage[] levelSprites;
	
	public LevelManager(GameRun gameRun) {
		this.gameRun = gameRun;
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
	
	public void render(Graphics g) {
		for(int i = 0; i < TILES_IN_HEIGHT; ++i) {
			for(int j = 0; j < TILES_IN_WIDTH; ++j) {
				int index = levelOne.getIndex(j, i);
				g.drawImage(levelSprites[index], TILES_SIZE * j, TILES_SIZE * i, null);
			}
		}
	}
	public void update() {
		
	}
	
}
