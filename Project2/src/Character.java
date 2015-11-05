
public class Character {
	
	private String name;
	private int health;
	private boolean visible;
	
	public Character(String name, int health) {
		this.name = name;
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
