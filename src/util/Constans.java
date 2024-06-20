package util;

public class Constans {
	
	public static final int FPS_SET = 120;
	public static final int UPS_SET = 200;
	
	public static final int TILE_DEFAULT_SIZE = 32;
	public static final float SCALE = 1.0f;
	public static final int TILES_IN_WIDTH = 26;
	public static final int TILES_IN_HEIGHT = 14;
	public static final int TILES_SIZE = (int) SCALE * TILE_DEFAULT_SIZE;
	public static final int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
	public static final int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;
	
	public static final int QUANTITY_ANIMATION = 9;
	public static final int MAX_LEVEL_IMAGE = 48;
	
	public static final float SPEED_PLAYER = 1f;
	
	public static final String IMAGE_FILE_PATH_PLAYER = "/player_sprites.png";
	public static final String IMAGE_FILE_PATH_LEVEL = "/outside_sprites.png";
	public static final String IMAGE_FILE_PATH_LEVEL_ONE = "/level_one_data.png";
	
	public static final int IMAGE_PLAYER_WIDTH = 64;
	public static final int IMAGE_PLAYER_HEIGHT = 40;
	
	public static final int PLAYER_WIDTH = 64;
	public static final int PLAYER_HEIGHT = 40;
	
	
	
	public static class PlayerConstans{
		public static final int IDLE = 0;
		public static final int	RUNNING = 1;
		public static final int JUMP = 2;
		public static final int FALLING = 3;
		public static final int GROUND = 4;
		public static final int HIT = 5;
		public static final int ATTACK = 6;
		public static final int ATTACK_JUMP = 7;
		
		public static int GetNumberPlayerConstants(int playerAction) {
			
			switch(playerAction) {
			case RUNNING:
				return 6;
			case IDLE:
				return 5;
			case JUMP:
				break;
			case FALLING:
				break;
			case GROUND:
				break;
			case HIT:
				break;
			case ATTACK:
				return 3;
			case ATTACK_JUMP:
				break;
			default:
				return 5;
			
			}
			
			return 5;
		}
		
	}
	
}
