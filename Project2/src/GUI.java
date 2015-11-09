import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {
	
	private JPanel topPanel, bottomPanel, miniMapPanel;
	private Maze maze = new Maze();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI();

	}
	
	public GUI() {
		super("Maze of Doom");
		this.setSize(800, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//bottomPanel = new JPanel();
		//bottomPanel.setPreferredSize(new Dimension(800,226));
		//bottomPanel.setBackground(Color.MAGENTA);
		//this.add(bottomPanel, BorderLayout.SOUTH);
		
		//miniMapPanel = new JPanel();
		//miniMapPanel.setPreferredSize(new Dimension(200,200));
		//miniMapPanel.setBackground(Color.GRAY);
		//this.add(miniMapPanel);
		
		MiniMap miniMap = new MiniMap(maze);
		this.add(miniMap);
		
		this.setVisible(true);
	}
	
	/*
	public void paint(Graphics g) {
		//super.paint(g);
		g.drawLine(0, 500, 800, 500);
		//Treasure t = maze.getRooms()[0][0].getTreasure();
		//g.drawImage(maze.getRooms()[0][0].getTreasure().getImage().getImage(), maze.getRooms()[0][0].getTreasure().getxCoordinate(), maze.getRooms()[0][0].getTreasure().getyCoordinate(), null);
	}
	*/

	/*@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
	}*/

}
