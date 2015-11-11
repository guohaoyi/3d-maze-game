import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

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
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(800, 200));
		bottomPanel.setBackground(Color.magenta);
		bottomPanel.setLayout(new BorderLayout());
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		miniMapPanel = new JPanel();
		miniMapPanel.setPreferredSize(new Dimension(200, 200));
		miniMapPanel.setBackground(Color.white);
		miniMapPanel.setLayout(new BorderLayout());
		bottomPanel.add(miniMapPanel,BorderLayout.EAST);

		MiniMap miniMap = new MiniMap(maze);
		miniMapPanel.add(miniMap,BorderLayout.CENTER);
		
		this.setVisible(true);
	}

}
