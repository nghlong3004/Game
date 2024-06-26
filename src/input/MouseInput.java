package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import gameStates.GameState;
import main.GamePanel;

public class MouseInput implements MouseListener, MouseMotionListener{
	
	GamePanel gamePanel;
	public MouseInput(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		switch(GameState.state) {
		case MENU:
			gamePanel.getGameRun().getMenu().mousClicked(e);
			break;
		case PLAYING:
			gamePanel.getGameRun().getPlaying().mousClicked(e);
			break;
		default:
			break;
		
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch(GameState.state) {
		case MENU:
			gamePanel.getGameRun().getMenu().mousePressed(e);
			break;
		case PLAYING:
			gamePanel.getGameRun().getPlaying().mousePressed(e);
			break;
		default:
			break;
		
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch(GameState.state) {
		case MENU:
			gamePanel.getGameRun().getMenu().mouseReleased(e);
			break;
		case PLAYING:
			gamePanel.getGameRun().getPlaying().mouseReleased(e);
			break;
		default:
			break;
		
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		switch(GameState.state) {
		case PLAYING:
			gamePanel.getGameRun().getPlaying().mouseDragged(e);
			break;
		default:
			break;
		
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		switch(GameState.state) {
		case MENU:
			gamePanel.getGameRun().getMenu().mouseMoved(e);
			break;
		case PLAYING:
			gamePanel.getGameRun().getPlaying().mouseMoved(e);
			break;
		default:
			break;
		
		}
	}

}
