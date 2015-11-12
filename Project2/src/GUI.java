import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setPreferredSize(new Dimension(800,800));
		this.pack();
		this.setLayout(new BorderLayout());
		
		topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(800, 600));
		topPanel.setBackground(Color.gray);
		topPanel.setLayout(new BorderLayout());
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(topPanel, BorderLayout.NORTH);
		
		JLabel pic1 = new JLabel(new ImageIcon("bin/resources/textures/texture1_center.png"));
		topPanel.add(pic1, BorderLayout.CENTER);
		JLabel pic2 = new JLabel(new ImageIcon("bin/resources/textures/texture1_left.png"));
		topPanel.add(pic2, BorderLayout.WEST);
		JLabel pic3 = new JLabel(new ImageIcon("bin/resources/textures/texture1_right.png"));
		topPanel.add(pic3, BorderLayout.EAST);
		
		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(800, 200));
		bottomPanel.setBackground(new Color(229, 204, 255));
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		miniMapPanel = new JPanel();
		miniMapPanel.setPreferredSize(new Dimension(200, 200));
		miniMapPanel.setBackground(Color.white);
		miniMapPanel.setLayout(new BorderLayout());
		bottomPanel.add(miniMapPanel, BorderLayout.EAST);

		MiniMap miniMap = new MiniMap(maze);
		miniMapPanel.add(miniMap, BorderLayout.CENTER);
		
		this.setVisible(true);
	}

}
