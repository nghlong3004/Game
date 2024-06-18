package main;

public class GameRun implements Runnable{
	
	private GamePanel gamePanel;
	
	private GameWindow gameWindow;
	
	private Thread gameThread;
	
	private final int FPS_SET = 120;
	
	public GameRun() {
		gamePanel = new GamePanel();
		
		gameWindow = new GameWindow();
		gameWindow.add(gamePanel);
		gameWindow.setVisible(true);
		
		gamePanel.requestFocus();
		
		gameLoop();
	}
	
	private void gameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		double timeNano = 1E9 / FPS_SET;
		long oldTime = System.nanoTime();
		while(true) {
			if(System.nanoTime() - oldTime >= timeNano) {
				oldTime = System.nanoTime();
				gamePanel.repaint();
			}
			
		}
		
	}
	
}
