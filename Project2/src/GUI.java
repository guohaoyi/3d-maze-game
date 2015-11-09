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
	
	private JPanel topPanel, bottomPanel;
	private Maze maze = new Maze();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI();

	}
	
	public GUI() {
		super("Maze of Doom");
		this.setSize(800, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MiniMap miniMap = new MiniMap(maze);
		this.add(miniMap);
		
		this.setVisible(true);
	}

}
