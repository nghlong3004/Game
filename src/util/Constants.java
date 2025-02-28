package util;

public class Constants {
	
	public static class FrameRateConstants{
		public static final int FPS_SET = 120;
		public static final int UPS_SET = 220;
	}
	
	public static class ImageCaptureConstants{
		public static final String IMAGE_FILE_PATH_PLAYER = "/player_sprites.png";
		public static final String IMAGE_FILE_PATH_LEVEL = "/outside_sprites.png";
		public static final String IMAGE_FILE_PATH_LEVEL_ONE = "/level_one_data_long.png";
		public static final String IMAGE_FILE_PATH_MENU = "/button_atlas.png";
		public static final String IMAGE_FILE_PATH_MENU_BACKGROUND = "/menu_background.png";
		public static final String IMAGE_FILE_PATH_MENU_PAUSE = "/pause_menu.png";
		public static final String IMAGE_FILE_PATH_MENU_SOUND = "/sound_button.png";
		public static final String IMAGE_FILE_PATH_MENU_URM = "/urm_buttons.png";
		public static final String IMAGE_FILE_PATH_MENU_VOLUME = "/volume_buttons.png";
		public static final String IMAGE_FILE_PATH_BACKGROUND_MENU = "/background_menu.png";
		public static final String IMAGE_FILE_PATH_BACKGROUND_PLAYING = "/playing_bg_img.png";
		public static final String IMAGE_FILE_PATH_BIG_CLOUD = "/big_clouds.png";
		public static final String IMAGE_FILE_PATH_SMALL_CLOUD = "/small_clouds.png";
		
		public static final int QUANTITY_ANIMATION = 9;
		public static final int MAX_LEVEL_IMAGE = 48;
		
		public static final int IMAGE_PLAYER_WIDTH = 64;
		public static final int IMAGE_PLAYER_HEIGHT = 40;
		
		public static final int PLAYER_WIDTH = (int)(IMAGE_PLAYER_WIDTH * GameConstants.SCALE);
		public static final int PLAYER_HEIGHT = (int)(IMAGE_PLAYER_HEIGHT * GameConstants.SCALE);
	}
	
	public static class UIConstants{
		public static class Buttons{
			public static final int BUTTON_WIDTH_DEFAULT = 140;
			public static final int BUTTON_HEIGHT_DEFAULT = 56;
			
			public static final int BUTTON_WIDTH = (int)( BUTTON_WIDTH_DEFAULT * GameConstants.SCALE );
			public static final int BUTTON_HEIGHT = (int)( BUTTON_HEIGHT_DEFAULT * GameConstants.SCALE );
		}
		public static class PauseButton{
			public static final int SOUND_SIZE_DEFAULT = 42;
			public static final int SOUND_SIZE = (int)(SOUND_SIZE_DEFAULT * GameConstants.SCALE);
		}
		public static class UrmButton{
			public static final int URM_SIZE_DEFAULT = 56;
			public static final int URM_SIZE = (int)(URM_SIZE_DEFAULT * GameConstants.SCALE);
		}
		public static class VolumeButton{
			public static final int VOLUME_WIDTH_DEFAULT = 28;
			public static final int VOLUME_HEIGHT_DEFAULT = 44;
			public static final int SLIDER_DEFAULT = 215;
			
			public static final int VOLUME_WIDTH = (int)( VOLUME_WIDTH_DEFAULT * GameConstants.SCALE );
			public static final int VOLUME_HEIGHT = (int)( VOLUME_HEIGHT_DEFAULT * GameConstants.SCALE );
			public static final int SLIDER = (int)(SLIDER_DEFAULT * GameConstants.SCALE);
		}
		public static class Cloud{
			public static final int BIG_CLOUD_WIDTH_DEFAULT = 448;
			public static final int BIG_CLOUD_HEIGHT_DEFAULT = 101;
			public static final int BIG_CLOUD_WIDTH = (int)(BIG_CLOUD_WIDTH_DEFAULT * GameConstants.SCALE);
			public static final int BIG_CLOUD_HEIGHT = (int)(BIG_CLOUD_HEIGHT_DEFAULT * GameConstants.SCALE);
			
			public static final int SMALL_CLOUD_WIDTH_DEFAULT = 74;
			public static final int SMALL_CLOUD_HEIGHT_DEFAULT = 24;
			public static final int SMALL_CLOUD_WIDTH = (int)(SMALL_CLOUD_WIDTH_DEFAULT * GameConstants.SCALE);
			public static final int SMALL_CLOUD_HEIGHT = (int)(SMALL_CLOUD_HEIGHT_DEFAULT * GameConstants.SCALE);
			
			
		}
	}
	
	public static class GameConstants{
		public static final int TILE_DEFAULT_SIZE = 32;
		public static final int TILES_IN_WIDTH = 26;
		public static final int TILES_IN_HEIGHT = 14;
		
		public static final float SCALE = 1.5f;
		
		public static final int TILES_SIZE = (int) (TILE_DEFAULT_SIZE * SCALE);
		public static final int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
		public static final int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;
		
		public static final float SPEED_PLAYER = 1f * SCALE;
		
		public static final float HITBOX_WIDTH_OFF_SET = 40f * SCALE;
		public static final float HITBOX_HEIGHT_OFF_SET = 12f * SCALE;
	}
	
	
	public static class PlayerConstants{
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
				return 3;
			case FALLING:
				return 1;
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
