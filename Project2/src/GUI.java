import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame implements MouseListener {
	
	private JPanel topPanel, bottomPanel, miniMapPanel;
	public GamePlay gamePlay = new GamePlay();
	private Maze maze = gamePlay.getMaze();
	private Player player;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new GUI();

	}
	
	public GUI() {
		super("Maze of Doom");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setPreferredSize(new Dimension(800,800));
		this.pack();
		this.setLayout(new BorderLayout());
		addMouseListener(this);
		
		this.player = gamePlay.getPlayer();
		
		topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(800, 600));
		topPanel.setLayout(new BorderLayout());
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(topPanel, BorderLayout.NORTH);
		
		Top top = new Top(gamePlay, player);
		topPanel.add(top);
		
		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(800, 200));
		bottomPanel.setBackground(new Color(200, 192, 230));
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		Bottom bottom = new Bottom(player);
		bottomPanel.add(bottom);
		
		miniMapPanel = new JPanel();
		miniMapPanel.setPreferredSize(new Dimension(200, 200));
		miniMapPanel.setBackground(new Color(238, 238, 238));
		miniMapPanel.setLayout(new BorderLayout());
		bottomPanel.add(miniMapPanel, BorderLayout.EAST);

		MiniMap miniMap = new MiniMap(maze);
		miniMapPanel.add(miniMap, BorderLayout.CENTER);
		
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
    	int y = e.getY();
    	Room room = gamePlay.getNextRoom();
    	boolean monster = false;
    	if (room != null)
    		monster = (room.getMonster() != null);
    	if ((x >= 340) && (x <= 460) && (y >= 655) && (y <= 688)) {
    		if (monster) {
    			System.out.println("Attack");
        		gamePlay.attack(room);
        		this.repaint();
    		}
    	}
    	else if ((x >= 328) && (x <= 369) && (y >= 713) && (y <= 749)) {
    		System.out.println("Turn left");
    		player.turnLeft();
    		this.repaint();
    	}
    	else if ((x >= 380) && (x <= 418) && (y >= 713) && (y <= 756)) {
    		System.out.println("Forward");
    		gamePlay.move("forward");
    		this.repaint();
    	}
    	else if ((x >= 431) && (x <= 472) && (y >= 713) && (y <= 749)) {
    		System.out.println("Turn right");
    		player.turnRight();
    		this.repaint();
    	}
    	else if ((x >= 328) && (x <= 369) && (y >= 765) && (y <= 803)) {
    		System.out.println("Leftward");
    		gamePlay.move("leftward");
    		this.repaint();
    	}
    	else if ((x >= 380) && (x <= 418) && (y >= 765) && (y <= 806)) {
    		System.out.println("Backward");
    		gamePlay.move("backward");
    		this.repaint();
    	}
    	else if ((x >= 431) && (x <= 472) && (y >= 765) && (y <= 803)) {
    		System.out.println("Rightward");
    		gamePlay.move("rightward");
    		this.repaint();
    	}
    	
    	boolean treasure = false;
    	//Room room = gamePlay.getNextRoom();
    	if (room != null)
    		treasure = (room.getTreasure() != null);
    	if (treasure) {
    		int x1 = room.getTreasure().getxCoordinate();
    		int x2 = x1 + room.getTreasure().getWidth();
    		int y1 = room.getTreasure().getyCoordinate();
    		int y2 = y1 + room.getTreasure().getHeight();
    		if ((x >= x1) && (x <= x2) && (y >= y1) && (y <= y2))
    			gamePlay.pickUpTreasure(room);
    		this.repaint();
    	}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

// Paints the bottom panel
class Bottom extends JComponent {
	
	private Player player;
	
	public Bottom(Player player) {
		this.player = player;
		this.setPreferredSize(new Dimension(800,200));
	}
	
	public void paint(Graphics g) {
		// Paints the buttons, health, and treasure
		ImageIcon buttons = new ImageIcon("bin/buttons.png");
		g.drawImage(buttons.getImage(), 324, 25, null);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		g2.drawLine(265, 70, 290, 70);
		g2.drawLine(277, 60, 277, 80);
		g2.setFont(new Font(g2.getFont().getFontName(), Font.BOLD, 15));
		if (player.getDirection() == 'n')
			g2.drawString("N", 272, 57);
		else if (player.getDirection() == 'e')
			g2.drawString("N", 292, 75);
		else if (player.getDirection() == 's')
			g2.drawString("N", 272, 93);
		else if (player.getDirection() == 'w')
			g2.drawString("N", 251, 75);
		g2.drawString("Health", 30, 30);
		g2.drawString("Treasure", 30, 100);
		g2.drawString(String.valueOf(player.getGold()), 30, 125);
		g2.setStroke(new BasicStroke(1));
		g2.drawRect(29, 39, 202, 32);
		if (player.getCurrentHealth() >= 67)
			g2.setColor(Color.green);
		else if (player.getCurrentHealth() <= 33)
			g2.setColor(Color.red);
		else
			g2.setColor(Color.yellow);
		g2.fillRect(30, 40, (200 * player.getCurrentHealth() / 100), 30);
	}

}

// Paints the top panel
class Top extends JComponent {
	
	private GamePlay gamePlay;
	private Player player;
	private int row, col;
	
	public Top(GamePlay gamePlay, Player player) {
		this.gamePlay = gamePlay;
		this.player = player;
		this.row = gamePlay.getMaze().getRow();
		this.col = gamePlay.getMaze().getCol();
		this.setPreferredSize(new Dimension(800,200));
	}
	
	public void paint(Graphics g) {
		// Initializes the room where the player is in, and the room ahead
		Room back = gamePlay.getMaze().getRooms()[gamePlay.getPlayerRow()][gamePlay.getPlayerCol()];
		boolean backNorth = back.isNorth();
		boolean backEast = back.isEast();
		boolean backSouth = back.isSouth();
		boolean backWest = back.isWest();
		boolean frontNorth = true;
		boolean frontEast = true;
		boolean frontSouth = true;
		boolean frontWest = true;
		Room front = new Room(null, null, true, true, true, true, "texture1");
		
		// North
		if (player.getDirection() == 'n') {
			if (gamePlay.getPlayerRow() > 0) {
				front = gamePlay.getMaze().getRooms()[gamePlay.getPlayerRow() - 1][gamePlay.getPlayerCol()];
				frontNorth = front.isNorth();
				frontEast = front.isEast();
				frontSouth = front.isSouth();
				frontWest = front.isWest();
			}
		}
		// East
		else if (player.getDirection() == 'e') {
			if (gamePlay.getPlayerCol() < col - 1) {
				front = gamePlay.getMaze().getRooms()[gamePlay.getPlayerRow()][gamePlay.getPlayerCol() + 1];
				frontNorth = front.isEast();
				frontEast = front.isSouth();
				frontSouth = front.isWest();
				frontWest = front.isNorth();
			}
			backNorth = back.isEast();
			backEast = back.isSouth();
			backSouth = back.isWest();
			backWest = back.isNorth();
		}
		// South
		else if (player.getDirection() == 's') {
			if (gamePlay.getPlayerRow() < row - 1) {
				front = gamePlay.getMaze().getRooms()[gamePlay.getPlayerRow() + 1][gamePlay.getPlayerCol()];
				frontNorth = front.isSouth();
				frontEast = front.isWest();
				frontSouth = front.isNorth();
				frontWest = front.isEast();
			}
			backNorth = back.isSouth();
			backEast = back.isWest();
			backSouth = back.isNorth();
			backWest = back.isEast();
		}
		// West
		else if (player.getDirection() == 'w') {
			if (gamePlay.getPlayerCol() > 0) {
				front = gamePlay.getMaze().getRooms()[gamePlay.getPlayerRow()][gamePlay.getPlayerCol() - 1];
				frontNorth = front.isWest();
				frontEast = front.isNorth();
				frontSouth = front.isEast();
				frontWest = front.isSouth();
			}
			backNorth = back.isWest();
			backEast = back.isNorth();
			backSouth = back.isEast();
			backWest = back.isSouth();
		}
		// Paints left wall
		if ((frontWest) && (backWest)) {
			ImageIcon left = new ImageIcon("bin/resources/textures/" + back.getTexture() + "_left.png");
			g.drawImage(left.getImage(), 0, 0, null);
		}
		else if (((frontWest) && (!backWest) && (!backNorth)) || ((!backWest) && (backNorth))) {
			ImageIcon left = new ImageIcon("bin/resources/textures/" + back.getTexture() + "_left_no_wall_back.png");
			g.drawImage(left.getImage(), 0, 0, null);
		}
		else if ((!frontWest) && (!backWest)) {
			ImageIcon left = new ImageIcon("bin/resources/textures/" + back.getTexture() + "_left_no_wall_both.png");
			g.drawImage(left.getImage(), 0, 0, null);
		}
		else if ((!frontWest) && (backWest)) {
			ImageIcon left = new ImageIcon("bin/resources/textures/" + back.getTexture() + "_left_no_wall_front.png");
			g.drawImage(left.getImage(), 0, 0, null);
		}
		// Paints center wall
		if (backNorth) {
			ImageIcon left = new ImageIcon("bin/resources/textures/" + back.getTexture() + "_center_wall_in_face.png");
			g.drawImage(left.getImage(), 228, 0, null);
		}
		else if ((frontNorth) && (!backNorth)) {
			ImageIcon left = new ImageIcon("bin/resources/textures/" + back.getTexture() + "_center.png");
			g.drawImage(left.getImage(), 228, 0, null);
		}
		else if ((!frontNorth) && (!backNorth)) {
			ImageIcon left = new ImageIcon("bin/resources/textures/" + back.getTexture() + "_center_no_wall_back.png");
			g.drawImage(left.getImage(), 228, 0, null);
		}
		// Paints right wall
		if ((frontEast) && (backEast)) {
			ImageIcon left = new ImageIcon("bin/resources/textures/" + back.getTexture() + "_right.png");
			g.drawImage(left.getImage(), 571, 0, null);
		}
		else if (((frontEast) && (!backEast) && (!backNorth)) || ((!backEast) && (backNorth))) {
			ImageIcon left = new ImageIcon("bin/resources/textures/" + back.getTexture() + "_right_no_wall_back.png");
			g.drawImage(left.getImage(), 571, 0, null);
		}
		else if ((!frontEast) && (!backEast)) {
			ImageIcon left = new ImageIcon("bin/resources/textures/" + back.getTexture() + "_right_no_wall_both.png");
			g.drawImage(left.getImage(), 571, 0, null);
		}
		else if ((!frontEast) && (backEast)) {
			ImageIcon left = new ImageIcon("bin/resources/textures/" + back.getTexture() + "_right_no_wall_front.png");
			g.drawImage(left.getImage(), 571, 0, null);
		}
		// Paints treasure
		if ((!frontSouth) && (front.getTreasure() != null))
			g.drawImage(front.getTreasure().getImage().getImage(), front.getTreasure().getxCoordinate(), front.getTreasure().getyCoordinate(), front.getTreasure().getWidth(), front.getTreasure().getHeight(), null);
		// Paints monsters
		if ((!frontSouth) && (front.getMonster() != null)) {
			g.drawImage(front.getMonster().getImage().getImage(), front.getMonster().getxCoordinate(), front.getMonster().getyCoordinate(), null);
			this.repaint();
		}
	}
	
}