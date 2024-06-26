package ui;

import static util.LoadingImageSave.*;
import static util.Constants.ImageCaptureConstants.*;
import static util.Constants.GameConstants.*;
import static util.Constants.UIConstants.PauseButton.*;
import static util.Constants.UIConstants.UrmButton.*;
import static util.Constants.UIConstants.VolumeButton.*;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import gameStates.GameState;
import gameStates.Playing;

public class Option {
	
	BufferedImage backgroundImage;
	
	private int bgX, bgY, bgW, bgH;
	
	private SoundButton musicButton;
	private SoundButton sfxButton;
	
	private UrmButton homeButton, unPauseButton, relayButton;
	
	private VolumeButton volumeButton;
	
	private Playing playing;
	
	public Option(Playing playing) {
		
		loadBackground();
		
		loadSoundButton();
		
		loadUrmButton();
		
		loadVolumeButton();
		
		this.playing = playing;
	}
	
	
	private void loadVolumeButton() {
		int vX = (int)(309 * SCALE);
		int vY = (int)(278 * SCALE);
		volumeButton = new VolumeButton(vX, vY, SLIDER, VOLUME_HEIGHT);
		
	}
	private void loadUrmButton() {
		
		int homeX = (int)(321 * SCALE );
		int unPauseX = (int)(homeX + URM_SIZE * 6 / 5);
		int relayX = (int)(unPauseX + URM_SIZE * 6 / 5 );
		int urmY = (int)(325 * SCALE);
		
		homeButton = new UrmButton(homeX, urmY, URM_SIZE, URM_SIZE, 2);
		unPauseButton = new UrmButton(unPauseX, urmY, URM_SIZE, URM_SIZE, 0);
		relayButton = new UrmButton(relayX, urmY, URM_SIZE, URM_SIZE, 1);
	}


	private void loadSoundButton() {
		
		int soundX = (int)(450 * SCALE);
		int musicY = (int)(140 * SCALE);
		int sfxY = (int)(140 * SCALE + SOUND_SIZE * 9 / 8);
		
		musicButton = new SoundButton(soundX, musicY, SOUND_SIZE, SOUND_SIZE);
		sfxButton = new SoundButton(soundX, sfxY, SOUND_SIZE, SOUND_SIZE);
	}


	private void loadBackground() {
		backgroundImage = GetSpriteAtlas(IMAGE_FILE_PATH_MENU_PAUSE);
		
		bgW = (int)(backgroundImage.getWidth() * SCALE);
		bgH = (int)(backgroundImage.getHeight() * SCALE);
		bgX = (GAME_WIDTH - bgW) >> 1;
		bgY = (int) (25 * SCALE);
	}


	public void update() {
		homeButton.update();
		unPauseButton.update();
		relayButton.update();
		volumeButton.update();
	}
	public void render(Graphics g) {
		g.drawImage(backgroundImage, bgX, bgY, bgW, bgH, null);
		
		musicButton.draw(g);
		sfxButton.draw(g);
		
		homeButton.draw(g);
		unPauseButton.draw(g);
		relayButton.draw(g);
		
		volumeButton.draw(g);
		
	}
	
	public void mouseDragged(MouseEvent e) {
		
		if(volumeButton.isMouseOver()) {
			volumeButton.changeButtonX(e.getX());
		}
		
	}
	
	public void mousePressed(MouseEvent e) {
		
		// TODO Auto-generated method stub
		pressedSoundButton(e);
		
		pressedUrmButton(e);
		
		pressedVolumeButton(e);
	}


	public void mouseReleased(MouseEvent e) {
		
		releasedSoundButton(e);
		
		releasedUrmButton(e);
		
		releaseVolumeButton(e);
		
	}


	public void mouseMoved(MouseEvent e) {
		
		movedSoundButton(e);
		
		movedUrmButton(e);	
		
		movedVolumeButton(e);
		
	}


	// check is point in rectangle ?
	private boolean isPointInRectangle(double buttonX, double buttonY, double eX, double eY, int width, int height) {
		if(eX >= buttonX && eX <= buttonX + width) {
			if(eY >= buttonY && eY <= buttonY + height) {
				return true;
			}
		}
		return false;
	}
	public boolean isInHitBox(MouseEvent e, SoundButton button) {
		return isPointInRectangle(button.getHitbox().getX(), button.getHitbox().getY(), e.getX(), e.getY(), SOUND_SIZE, SOUND_SIZE);
	}
	public boolean isInHitBox(MouseEvent e, UrmButton button) {
		return isPointInRectangle(button.getHitbox().getX(), button.getHitbox().getY(), e.getX(), e.getY(), URM_SIZE, URM_SIZE);
	}
	public boolean isInHitBox(MouseEvent e, VolumeButton button) {
		return isPointInRectangle(button.getHitbox().getX(), button.getHitbox().getY(), e.getX(), e.getY(), VOLUME_WIDTH, VOLUME_HEIGHT);
	}
	// set off moved
	private void movedUrmButton(MouseEvent e) {
		homeButton.setMouseOver(false);
		unPauseButton.setMouseOver(false);
		relayButton.setMouseOver(false);
		
		if(isInHitBox(e, homeButton)) {
			homeButton.setMouseOver(true);
		}
		else if(isInHitBox(e, unPauseButton)) {
			unPauseButton.setMouseOver(true);
		}
		else if(isInHitBox(e, relayButton)) {
			relayButton.setMouseOver(true);
		}
		
	}
	
	public void movedSoundButton(MouseEvent e) {
		musicButton.setMouseOver(0);
		sfxButton.setMouseOver(0);
		if(isInHitBox(e, musicButton)) {
			musicButton.setMouseOver(musicButton.getMousePressed() ^ 1);
		}
		else if(isInHitBox(e, sfxButton)) {
			sfxButton.setMouseOver(sfxButton.getMousePressed() ^ 1);
		}
	}
	private void movedVolumeButton(MouseEvent e) {
		volumeButton.setMouseOver(false);
		if(isInHitBox(e, volumeButton)) {
			volumeButton.setMouseOver(true);
		}
		
	}
	// set of released 
	private void releasedSoundButton(MouseEvent e) {
		if(isInHitBox(e, musicButton)) {
			if(musicButton.getMousePressed() == 1) {
				update();
			}
		}
		else if(isInHitBox(e, sfxButton)) {
			if(sfxButton.getMousePressed() == 1) {
				update();
			}
		}
		musicButton.reset();
		sfxButton.reset();
		
	}
	private void releaseVolumeButton(MouseEvent e) {
		if(isInHitBox(e, volumeButton)) {
			
		}
		volumeButton.reset();
	}
	private void releasedUrmButton(MouseEvent e) {
		if(isInHitBox(e, homeButton)) {
			if(homeButton.isMousePressed()) {
				GameState.state = GameState.MENU;
				playing.setPause(false);
			}
		}
		else if(isInHitBox(e, unPauseButton)) {
			if(unPauseButton.isMousePressed()) {
				playing.setPause(true);
			}
		}
		else if(isInHitBox(e, relayButton)) {
			if(relayButton.isMousePressed()) {
				
			}
		}
		homeButton.reset();
		unPauseButton.reset();
		relayButton.reset();
	}
	// set of pressed
	private void pressedSoundButton(MouseEvent e) {
		if(isInHitBox(e, musicButton)) {
			if(musicButton.getMouseOver() == 1) {
				if(musicButton.getMousePressed() == 1) {
					musicButton.reset();
					musicButton.setMuted(musicButton.getMuted() ^ 1);
				}
				else {
					musicButton.setMousePressed(1);
					musicButton.setMuted(musicButton.getMuted() ^ 1);
				}
			}
			else {
				musicButton.setMouseOver(1);
				musicButton.setMousePressed(1);
				musicButton.setMuted(musicButton.getMuted() ^ 1);
			}
			return;
		}
		else if(isInHitBox(e, sfxButton)) {
			if(sfxButton.getMouseOver() == 1) {
				if(sfxButton.getMousePressed() == 1) {
					sfxButton.reset();
					sfxButton.setMuted(sfxButton.getMuted() ^ 1);
				}
				else {
					sfxButton.setMousePressed(1);
					sfxButton.setMuted(sfxButton.getMuted() ^ 1);
				}
			}
			else {
				sfxButton.setMouseOver(1);
				sfxButton.setMousePressed(1);
				sfxButton.setMuted(sfxButton.getMuted() ^ 1);
			}
		}
		
	}
	private void pressedUrmButton(MouseEvent e) {
		if(isInHitBox(e, homeButton)) {
			homeButton.setMousePressed(true);
		}
		else if(isInHitBox(e, unPauseButton)) {
			unPauseButton.setMousePressed(true);
		}
		else if(isInHitBox(e, relayButton)) {
			relayButton.setMousePressed(true);
		}
	}
	private void pressedVolumeButton(MouseEvent e) {
		if(isInHitBox(e, volumeButton)) {
			volumeButton.setMousePressed(true);
		}
		
	}
	
}
