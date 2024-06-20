package levels;

public class LevelOne {
	
	private int[][] lvlData;
	public LevelOne(int[][] lvlData) {
		
		this.lvlData = lvlData;
		
	}
	
	public int getIndex(int x, int y) {
		return lvlData[y][x];
	}
	
}
