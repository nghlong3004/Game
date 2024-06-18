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
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			//gamePanel.changeY(-5);
			break;
		case KeyEvent.VK_S:
			//gamePanel.changeY(5);
			break;
		case KeyEvent.VK_A:
			//gamePanel.changeX(-5);
			break;
		case KeyEvent.VK_D:
			//gamePanel.changeX(+5);
			break;
		}
	}

}
