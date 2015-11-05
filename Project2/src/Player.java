
public class Player extends Character {
	
	private int currentHealth;
	private int gold;
	
	public Player(int health) {
		super("Player", health);
		currentHealth = health;
		gold = 0;
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
