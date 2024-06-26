package main;


import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import input.KeyboardInput;
import input.MouseInput;

import static util.Constants.GameConstants.*;

public class GamePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MouseInput mouseInput;
	
	private KeyboardInput keyboardInput;
	
	private GameRun gameRun;
	
	public GamePanel(GameRun gameRun) {
		input();
		
		this.gameRun = gameRun;
		
		setSize();
		
	}

	private void input() {
		keyboardInput = new KeyboardInput(this);
		mouseInput = new MouseInput(this);
		addKeyListener(keyboardInput);
		addMouseListener(mouseInput);
		addMouseMotionListener(mouseInput);
	}

	private void setSize() {
		Dimension dimension = new Dimension(GAME_WIDTH, GAME_HEIGHT);
		setMaximumSize(dimension);
		setPreferredSize(dimension);
		setMinimumSize(dimension);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		gameRun.render(g);
		
	}
	
	public GameRun getGameRun() {
		return this.gameRun;
	}
	
	
}
