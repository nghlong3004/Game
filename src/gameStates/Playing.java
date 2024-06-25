package gameStates;

import static util.Constans.ImageCaptureConstants.*;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import entities.Player;
import levels.LevelManager;
import main.GameRun;

public class Playing extends State implements StateMethod{
	
	private Player player;
	
	private LevelManager levelManager;
	
	public Playing(GameRun game) {
		super(game);
		
		initClass();
	}
	
	private void initClass() {

		player = new Player(100, 200, PLAYER_WIDTH, PLAYER_HEIGHT);
		
		levelManager = new LevelManager(game);
		
		player.importLvlData(levelManager.getLevelOne().getLvlData());
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		player.update();
		levelManager.update();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		levelManager.render(g);
		player.render(g);
	}

	@Override
	public void mousClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		player.setAttacking(true);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		player.setAttacking(false);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			player.setJump(true);
			break;
////		case KeyEvent.VK_DOWN:
////		case KeyEvent.VK_S:
////			gamePanel.getGameRun().getPlayer().setDown(1f);;
////			break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			player.setLeft(-1f);;
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			player.setRight(1f);;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			player.setJump(false);
			break;
//		case KeyEvent.VK_DOWN:
//		case KeyEvent.VK_S:
//			gamePanel.getGameRun().getPlayer().setDown(0f);;
//			break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			player.setLeft(0f);;
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			player.setRight(0f);;
			break;
		}
	}

}
