package gameStates;

import static util.Constants.GameConstants.*;
import static util.Constants.UIConstants.Buttons.*;
import static util.Constants.ImageCaptureConstants.*;
import static util.LoadingImageSave.*;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import main.GameRun;
import ui.MenuButton;

public class Menu extends State implements StateMethod{

	private MenuButton[] menuButtons = new MenuButton[3];
	
	private BufferedImage menuBackground;
	
	private int xPos, yPos, width, height;
	
	public Menu(GameRun game) {
		super(game);
		// TODO Auto-generated constructor stub
		
		loadMenuButtons();
		
		loadBackground();
		
	}

	private void loadBackground() {
		menuBackground = GetSpriteAtlas(IMAGE_FILE_PATH_MENU_BACKGROUND);
		
		width = (int)(menuBackground.getWidth() * SCALE);
		height = (int)(menuBackground.getHeight() * SCALE);
		xPos = (GAME_WIDTH - width) >> 1;
		yPos = (int)(45 * SCALE);
	}

	private void loadMenuButtons() {
		// TODO Auto-generated method stub
		menuButtons[0] = new MenuButton(GAME_WIDTH / 2,(int)((BUTTON_WIDTH_DEFAULT) * SCALE) , 0, GameState.PLAYING);
		menuButtons[1] = new MenuButton(GAME_WIDTH / 2,(int)((BUTTON_WIDTH_DEFAULT * 3 / 2) * SCALE) , 1, GameState.OPTION);
		menuButtons[2] = new MenuButton(GAME_WIDTH / 2,(int)((BUTTON_WIDTH_DEFAULT * 2) * SCALE) , 2, GameState.QUIT);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		for(MenuButton button: menuButtons) {
			button.update();
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(menuBackground, xPos, yPos, width, height, null);
		for(MenuButton button: menuButtons) {
			button.draw(g);
		}
		
	}

	@Override
	public void mousClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		for(MenuButton button: menuButtons) {
			if(isInHitBox(e, button)) {
				button.setMousePressed(true);
				break;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for(MenuButton button: menuButtons) {
			if(isInHitBox(e, button)) {
				if(button.isMousePressed()) {
					button.applyGameState();
				}
				break;
			}
		}
		resetMenuButtons();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		for(MenuButton button: menuButtons) {
			button.setMouseOver(false);
		}
		for(MenuButton button: menuButtons) {
			if(isInHitBox(e, button)) {
				button.setMouseOver(true);
				break;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == KeyEvent.VK_ENTER) {
			GameState.state = GameState.PLAYING;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void resetMenuButtons() {
		for(MenuButton button: menuButtons) {
			button.reset();
		}
	}
	
}
