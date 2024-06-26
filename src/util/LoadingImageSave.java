package util;

import static util.Constants.ImageCaptureConstants.*;
import static util.Constants.GameConstants.*;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadingImageSave {
	
	public static BufferedImage GetSpriteAtlas(String atlas) {
		BufferedImage image = null;
		InputStream inputStream = LoadingImageSave.class.getResourceAsStream(atlas);
		try {
			image = ImageIO.read(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return image;
	}
	public static int[][] GetlevelData(){
		int [][] lvlData = new int[TILES_IN_HEIGHT + 1][TILES_IN_WIDTH + 1];
		BufferedImage image = GetSpriteAtlas(IMAGE_FILE_PATH_LEVEL_ONE);
		for(int i = 0; i < image.getHeight(); ++i) {
			for(int j = 0; j < image.getWidth(); ++j) {
				Color color = new Color(image.getRGB(j, i));
				int value = color.getRed() % MAX_LEVEL_IMAGE;
				lvlData[i][j] = value;
			}
		}
		return lvlData;
	}


}
