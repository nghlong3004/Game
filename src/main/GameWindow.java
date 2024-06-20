package main;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class GameWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public GameWindow() {	
		super("Game");
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 400);
		setLocationRelativeTo(null);
	}
	
	
}
