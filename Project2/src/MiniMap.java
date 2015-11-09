import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class MiniMap extends JComponent {
	
	private Maze maze;
	private Room[][] rooms;
	private int width, height;
	private final int x = 550;
	private final int y = 500;
	
	public MiniMap(Maze startMaze) {
		maze = startMaze;
		rooms = startMaze.getRooms();
		width = 200 / startMaze.getRow();
		height = 200 / startMaze.getCol();
	}
	
	public void paint(Graphics g) {
		//g.drawRect(x, y, 200, 200);
		for (int i = 0; i < maze.getRow(); i++) {
			for (int j = 0; j < maze.getCol(); j++) {
				if (rooms[j][i].isNorth()) {
					g.drawLine(x + width * i, y + height * j, x + width + width * i, y + height * j);
				}
				if (rooms[j][i].isEast()) {
					g.drawLine(x + width + width * i, y + height * j, x + width + width * i, y + height + height * j);
				}
				if (rooms[j][i].isSouth()) {
					g.drawLine(x + width * i, y + height + height * j, x + width + width * i, y + height + height * j);
				}
				if (rooms[j][i].isWest()) {
					g.drawLine(x + width * i, y + height * j, x + width * i, y + height + height * j);
				}
				if (rooms[j][i].getMonster() != null)
					g.drawString(rooms[j][i].getMonster().toString(), x + 2 + width * i, y + 12 + height * j);
				if (rooms[j][i].getTreasure() != null) {
					if (rooms[j][i].getTreasure().getName().equals("Gold Bag"))
						g.fillOval(x + 25 + width * i, y + 17 + height * j, 10, 10);
					else if (rooms[j][i].getTreasure().getName().equals("Gem")) {
						g.setColor(Color.red);
						g.fillOval(x + 25 + width * i, y + 17 + height * j, 10, 10);
						g.setColor(Color.black);
					}
					else if (rooms[j][i].getTreasure().getName().equals("Chalice")) {
						g.setColor(Color.yellow);
						g.fillOval(x + 25 + width * i, y + 17 + height * j, 10, 10);
						g.setColor(Color.black);
					}
					else if (rooms[j][i].getTreasure().getName().equals("Health Potion")) {
						g.setColor(Color.blue);
						g.fillOval(x + 25 + width * i, y + 17 + height * j, 10, 10);
						g.setColor(Color.black);
					}
				}
				//g.drawRect(x + width * i, y + height * j, width, height);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
