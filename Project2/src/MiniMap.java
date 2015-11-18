import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

public class MiniMap extends JComponent implements Observer {
	
	private Maze maze;
	private Room[][] rooms;
	private int width, height;
	private final int x = 2;
	private final int y = 2;
	
	public MiniMap(Maze startMaze) {
		maze = startMaze;
		rooms = startMaze.getRooms();
		width = 200 / startMaze.getRow();
		height = 200 / startMaze.getCol();
		//this.setPreferredSize(new Dimension(350,200));
	}
	
	public void paint(Graphics g) {
		for (int i = 0; i < maze.getRow(); i++) {
			for (int j = 0; j < maze.getCol(); j++) {
				// Paints the north wall
				if (rooms[j][i].isNorth()) {
					if (rooms[j][i].getTexture().equals("texture2"))
						g.setColor(Color.green);
					else if (rooms[j][i].getTexture().equals("texture3"))
						g.setColor(Color.magenta);
					else if (rooms[j][i].getTexture().equals("texture4"))
						g.setColor(Color.blue);
					g.drawLine(x + width * i, y + height * j, x + width + width * i - 5, y + height * j);
					g.setColor(Color.black);
				}
				// Paints the east wall
				if (rooms[j][i].isEast()) {
					if (rooms[j][i].getTexture().equals("texture2"))
						g.setColor(Color.green);
					else if (rooms[j][i].getTexture().equals("texture3"))
						g.setColor(Color.magenta);
					else if (rooms[j][i].getTexture().equals("texture4"))
						g.setColor(Color.blue);
					g.drawLine(x + width + width * i - 5, y + height * j, x + width + width * i - 5, y + height + height * j - 5);
					g.setColor(Color.black);
				}
				// Paints the south wall
				if (rooms[j][i].isSouth()) {
					if (rooms[j][i].getTexture().equals("texture2"))
						g.setColor(Color.green);
					else if (rooms[j][i].getTexture().equals("texture3"))
						g.setColor(Color.magenta);
					else if (rooms[j][i].getTexture().equals("texture4"))
						g.setColor(Color.blue);
					g.drawLine(x + width * i, y + height + height * j - 5, x + width + width * i - 5, y + height + height * j - 5);
					g.setColor(Color.black);
				}
				// Paints the west wall
				if (rooms[j][i].isWest()) {
					if (rooms[j][i].getTexture().equals("texture2"))
						g.setColor(Color.green);
					else if (rooms[j][i].getTexture().equals("texture3"))
						g.setColor(Color.magenta);
					else if (rooms[j][i].getTexture().equals("texture4"))
						g.setColor(Color.blue);
					g.drawLine(x + width * i, y + height * j, x + width * i, y + height + height * j - 5);
					g.setColor(Color.black);
				}
				// Paints monsters
				if (rooms[j][i].getMonster() != null)
					g.drawString(rooms[j][i].getMonster().toString(), x + 4 + width * i, y + 14 + height * j);
				// Paints treasures
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
				// Paints the player
				if (rooms[j][i].getPlayer() != null)
					g.drawString("U", x + 15 + width * i, y + 25 + height * j);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.repaint();
	}

}
