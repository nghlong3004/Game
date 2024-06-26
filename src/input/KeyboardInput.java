package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gameStates.GameState;
import main.GamePanel;

public class KeyboardInput implements KeyListener{
	
	GamePanel gamePanel;
	public KeyboardInput(GamePanel gamePanel) {
		// TODO Auto-generated constructor stub
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(GameState.state) {
		case MENU:
			gamePanel.getGameRun().getMenu().keyPressed(e);
			break;
		case PLAYING:
			gamePanel.getGameRun().getPlaying().keyPressed(e);
			break;
		case OPTION:
			gamePanel.getGameRun().getPlaying().keyPressed(e);
			break;
		default:
			break;
		
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(GameState.state) {
		case MENU:
			gamePanel.getGameRun().getMenu().keyReleased(e);
			break;
		case PLAYING:
			gamePanel.getGameRun().getPlaying().keyReleased(e);
			break;
		default:
			break;
		
		}
		
	}

}
