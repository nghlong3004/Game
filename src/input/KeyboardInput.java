package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			gamePanel.getGameRun().getPlayer().setUp(-1f);;
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			gamePanel.getGameRun().getPlayer().setDown(1f);;
			break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			gamePanel.getGameRun().getPlayer().setLeft(-1f);;
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			gamePanel.getGameRun().getPlayer().setRight(1f);;
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			gamePanel.getGameRun().getPlayer().setUp(0f);;
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			gamePanel.getGameRun().getPlayer().setDown(0f);;
			break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			gamePanel.getGameRun().getPlayer().setLeft(0f);;
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			gamePanel.getGameRun().getPlayer().setRight(0f);;
			break;
		}
	}

}
