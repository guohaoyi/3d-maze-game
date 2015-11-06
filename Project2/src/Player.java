
public class Player extends Character {
	
	private int currentHealth;
	private int gold;
	
	public Player() {
		super("Player", 100);
		currentHealth = 100;
		gold = 0;
		setVisible(true);
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
