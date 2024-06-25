package gameStates;

import java.awt.event.MouseEvent;

import main.GameRun;
import ui.MenuButton;

public class State {
	protected GameRun game;
	
	public State(GameRun game) {
		this.game = game;
	}
	
	public boolean isInHitBox(MouseEvent e, MenuButton button) {
		return button.getHixbox().contains(e.getX(), e.getY());
	}
	
	public GameRun getGame() {
		return game;
	}
}
