import javax.swing.ImageIcon;

public class Treasure {
	
	private String name;
	private ImageIcon image;
	private int gold;
	private int health;
	private int width;
	private int height;
	private int xCoordinate;
	private int yCoordinate;
	
	public Treasure(String name, String image, int gold, int health, int width, int height, int xCoordinate, int yCoordinate) {
		this.name = name;
		this.image = new ImageIcon("bin/resources/treasures/" + image);
		this.gold = gold;
		this.health = health;
		this.width = width;
		this.height = height;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
