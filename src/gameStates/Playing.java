package gameStates;

import static util.Constants.ImageCaptureConstants.*;
import static util.Constants.GameConstants.*;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import entities.Player;
import levels.LevelManager;
import main.GameRun;
import ui.Background;
import ui.Option;
import util.LoadingImageSave;

public class Playing extends State implements StateMethod{
	
	private Player player;
	
	private LevelManager levelManager;
	
	private Background background;
	
	private Option option;
	
	private boolean pause = true;
	
	private int xLvlOffSet;
	private int leftBorder = (int)(0.4 * GAME_WIDTH);
	private int rightBorder = (int)(0.6 * GAME_WIDTH);
	private int lvlTilesWide = LoadingImageSave.GetlevelData()[0].length;
	private int maxTilesOffSet = lvlTilesWide - TILES_IN_WIDTH;
	private int maxLvlOffset = maxTilesOffSet * TILES_SIZE;
	
	public Playing(GameRun game) {
		super(game);
		
		initClass();
	}
	
	private void initClass() {

		player = new Player(100, 200, PLAYER_WIDTH, PLAYER_HEIGHT);
		
		levelManager = new LevelManager(game);
		
		player.importLvlData(levelManager.getLevelOne().getLvlData());
		
		option = new Option(this);
		
		background = new Background();
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(pause) {
			background.update(xLvlOffSet);
			player.update();
			levelManager.update();
			checkCloseToBorder();
		}
		else {
			option.update();
		}
	}

	private void checkCloseToBorder() {
		int playerX = (int)(player.getHitbox().x);
		int diff = playerX - xLvlOffSet;
		if(diff > rightBorder) {
			xLvlOffSet += diff - rightBorder;
		}
		else if(diff < leftBorder) {
			xLvlOffSet += diff - leftBorder;
		}
		if(xLvlOffSet > maxLvlOffset) {
			xLvlOffSet = maxLvlOffset;
		}
		else if(xLvlOffSet < 0) {
			xLvlOffSet = 0;
		}
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		background.draw(g);
		player.render(g, xLvlOffSet);
		levelManager.render(g, xLvlOffSet);
		if(!pause) {
			option.render(g);
		}
	}
	public void mouseDragged(MouseEvent e) {
		if(!pause) {
			option.mouseDragged(e);
		}
	}

	@Override
	public void mousClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!pause) {
			option.mousePressed(e);
		}
		else {
			player.setAttacking(true);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!pause) {
			option.mouseReleased(e);
		}
		if(pause) {
			player.setAttacking(false);
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!pause) {
			option.mouseMoved(e);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			player.setJump(true);
			break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			player.setLeft(-1f);;
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			player.setRight(1f);;
			break;
		case KeyEvent.VK_SPACE:
			if(pause) {
				pause = false;
			}
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
	
	public void setPause(boolean pause) {
		this.pause = pause;
	}
	
}
