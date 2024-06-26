package main;

import static util.Constants.FrameRateConstants.*;

import java.awt.Graphics;

import gameStates.GameState;
import gameStates.Menu;
import gameStates.Playing;

public class GameRun implements Runnable{
	
	private GamePanel gamePanel;
	
	private GameWindow gameWindow;
	
	private Thread gameThread;
	
	private Menu menu;
	private Playing playing;
	
	public GameRun() {
		
		newImplement();
		
		gameWindow.add(gamePanel);
		gameWindow.pack();
		gameWindow.setResizable(false);
		gameWindow.setVisible(true);
		
		gamePanel.requestFocus();
		
		gameLoopStart();
	}

	private void newImplement() {
		// TODO Auto-generated method stub
		gamePanel = new GamePanel(this);
	
		gameWindow = new GameWindow();
		
		menu = new Menu(this);
		
		playing = new Playing(this);
	}

	public void update() {
		switch(GameState.state) {
		case MENU:
			menu.update();
			break;
		case PLAYING:
			playing.update();
			break;
		case OPTION:
			break;
		case QUIT:
			System.exit(0);
		default:
			break;
		
		}
		
	}
	public void render(Graphics g) {
		switch(GameState.state) {
		case MENU:
			menu.render(g);
			break;
		case PLAYING:
			playing.render(g);
			break;
		default:
			break;
		
		}
	}
	
	private synchronized void gameLoopStart() {
        gameThread = new Thread(this);
        gameThread.start();
    }
	public synchronized void gameLoopStop() {
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	@Override
	public void run() {
		final double NANOSECONDS_PER_FRAME = 1E9 / FPS_SET;
		final double NANOSECONDS_PER_UPDATE = 1E9 / UPS_SET;
		
		double updateDelta = 0;
		double frameDelta = 0;
		
		int updatesCount = 0;
		int framesCount = 0;
		
		long lastTime = System.nanoTime();
		long frameTime = System.currentTimeMillis();
		
		while(true) {
			long currentTime = System.nanoTime();
			
			updateDelta += (currentTime - lastTime) / NANOSECONDS_PER_UPDATE;
			frameDelta  += (currentTime - lastTime) / NANOSECONDS_PER_FRAME;
			
			lastTime = currentTime;
			
			if(updateDelta >= 1) {
				update();
				updateDelta--;
				updatesCount++;
			}
			if(frameDelta >= 1) {
				framesCount++;
				frameDelta--;
				gamePanel.repaint();
			}	
			if(System.currentTimeMillis() - frameTime >= 1000) {
				frameTime = System.currentTimeMillis();
				//System.out.println("FPS : " + framesCount + " | UPS : " + updatesCount);
				framesCount = 0;
				updatesCount = 0;
			}
			try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
			
		}
		
	}

	public Menu getMenu() {
		return menu;
	}

	public Playing getPlaying() {
		return playing;
	}
	
	
}