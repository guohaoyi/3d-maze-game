import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame {
	
	private JPanel topPanel, bottomPanel, miniMapPanel;
	private Maze maze = new Maze();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new GUI();
		BufferedImage image = ImageIO.read(new File("bin/button.png"));

	    int w = image.getWidth();
	    int h = image.getHeight();

	    int[] dataBuffInt = image.getRGB(0, 0, w, h, null, 0, w); 

	    Color c = new Color(dataBuffInt[100]);

	    System.out.println(c.getRed());   // = (dataBuffInt[100] >> 16) & 0xFF
	    System.out.println(c.getGreen()); // = (dataBuffInt[100] >> 8)  & 0xFF
	    System.out.println(c.getBlue());  // = (dataBuffInt[100] >> 0)  & 0xFF
	    System.out.println(c.getAlpha()); 

	}
	
	public GUI() {
		super("Maze of Doom");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setPreferredSize(new Dimension(800,800));
		this.pack();
		this.setLayout(new BorderLayout());
		
		topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(800, 600));
		//topPanel.setBackground(Color.gray);
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
		bottomPanel.setBackground(new Color(200, 192, 230));
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		Bottom bottom = new Bottom();
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

}

class Bottom extends JComponent {
	
	public Bottom() {
		this.setPreferredSize(new Dimension(800,200));
	}
	
	public void paint(Graphics g) {
		ImageIcon buttons = new ImageIcon("bin/buttons.png");
		g.drawImage(buttons.getImage(), 324, 25, null);
	}
	
}
