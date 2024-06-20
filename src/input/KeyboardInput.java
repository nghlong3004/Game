package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;

import static util.Constans.PlayerConstans.*;
import static util.Constans.*;

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
		gamePanel.setState(RUNNING);
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			gamePanel.changeY(-SPEED_PLAYER);
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			gamePanel.changeY(SPEED_PLAYER);
			break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			gamePanel.changeX(-SPEED_PLAYER);
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			gamePanel.changeX(SPEED_PLAYER);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		gamePanel.setState(IDLE);
	}

}
