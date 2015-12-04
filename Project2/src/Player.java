
public class Player extends Character {
	
	private int currentHealth;
	private int gold;
	private char direction;
	
	public Player() {
		super(100);
		currentHealth = 100;
		gold = 0;
		direction = 's';
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	
	public void increaseCurrentHealth(int increase) {
		currentHealth = currentHealth + increase;
		if (currentHealth > this.getHealth())
			currentHealth = this.getHealth();
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public void increaseGold(int increase) {
		gold = gold + increase;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}
	
	public void turnLeft() {
		if (getCurrentHealth() > 0) {
			if (direction == 'n')
				direction = 'w';
			else if (direction == 'e')
				direction = 'n';
			else if (direction == 's')
				direction = 'e';
			else if (direction == 'w')
				direction = 's';
		}
	}
	
	public void turnRight() {
		if (getCurrentHealth() > 0) {
			if (direction == 'n')
				direction = 'e';
			else if (direction == 'e')
				direction = 's';
			else if (direction == 's')
				direction = 'w';
			else if (direction == 'w')
				direction = 'n';
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
