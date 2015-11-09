import java.awt.Graphics;

import javax.swing.JComponent;

public class MiniMap extends JComponent {
	
	private Maze maze;
	private Room[][] rooms;
	private int width, height;
	
	public MiniMap(Maze startMaze) {
		maze = startMaze;
		rooms = startMaze.getRooms();
		width = 200 / startMaze.getRow();
		height = 200 / startMaze.getCol();
	}
	
	public void paint(Graphics g) {
		g.drawRect(50, 50, width, height);
		//g.drawRect(500, 500, width, height);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
