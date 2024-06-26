package util;

import static util.Constants.ImageCaptureConstants.*;
import static util.Constants.GameConstants.*;

import java.awt.geom.Rectangle2D;

public class HelpMethod {
	
	public static int in(float x) {
		return (int)x;
	}
	
	public static boolean CanMove(float x, float y, float width, float height, int [][] lvlData) {
		if(IsSolid(x, y, lvlData)) {
			if(IsSolid(x + width, y + height, lvlData)) {
				if(IsSolid(x + width, y, lvlData)) {
					if(IsSolid(x, y + height, lvlData)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	public static boolean IsSolid(float x, float y, int[][] lvlData) {
		if(x < 0 || x > GAME_WIDTH) {
			return false;
		}
		if(y < 0 || y > GAME_HEIGHT) {
			return false;
		}
		float xIndex = x / TILES_SIZE;
		float yIndex = y / TILES_SIZE;
		int value = lvlData[in(yIndex) ][in(xIndex)];
		if(value >= MAX_LEVEL_IMAGE || value != 11 || value <= 0 || value >= 48) {
			return false;
		}
		return true;
	}
	public static float GetEnityXPosNextToWall(Rectangle2D.Float hitbox, float x) {
		int currentTile = (int)(hitbox.x / TILES_SIZE);
		
		if(x > 0) {
			//right
			float tileXPos = currentTile * TILES_SIZE;
			float xOffSet = (TILES_SIZE - hitbox.width);
			return tileXPos + xOffSet - 1;
		}
		else {
			// left
			return currentTile * TILES_SIZE;
			
		}
	}
	public static float GetEnityYPosNextToWall(Rectangle2D.Float hitbox, float y) {
		int currentTile = (int)(hitbox.y / TILES_SIZE);
		if(y > 0) {
			//right
			float tileXPos = currentTile * TILES_SIZE;
			float yOffSet = (TILES_SIZE - hitbox.height);
			return tileXPos + yOffSet - 1;
		}
		else {
			// left
			return currentTile * TILES_SIZE;
			
		}
	}
	public static boolean IsEntityOnFloor(Rectangle2D.Float hitbox, int[][] lvlData) {
		if(IsSolid(hitbox.x, hitbox.y + hitbox.height + 1, lvlData)) {
			if(IsSolid(hitbox.x + hitbox.width + 1, hitbox.y + hitbox.height + 1, lvlData)) {
				return false;
			}
		}
		
		return true;
	}
	
}
