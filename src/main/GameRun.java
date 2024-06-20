package main;

import static util.Constans.*;

public class GameRun implements Runnable{
	
	private GamePanel gamePanel;
	
	private GameWindow gameWindow;
	
	private Thread gameThread;
	
	public GameRun() {
		gamePanel = new GamePanel();
		
		gameWindow = new GameWindow();
		gameWindow.add(gamePanel);
		gameWindow.pack();
		gameWindow.setVisible(true);
		
		gamePanel.requestFocus();
		
		gameLoopStart();
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
				System.out.println("FPS : " + framesCount + " | UPS : " + updatesCount);
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
	
}