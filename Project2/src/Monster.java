import javax.swing.ImageIcon;

public class Monster extends Character {
	
	private ImageIcon image1;
	private ImageIcon image2;
	private int damage;
	private int coolDownTime;
	private int probabilityAttack;
	private int probabilityDamage;
	
	public Monster(String name, int health, int damage, int coolDownTime, int probabilityAttack, int probabilityDamage) {
		super(name, health);
		this.damage = damage;
		this.coolDownTime = coolDownTime;
		this.probabilityAttack = probabilityAttack;
		this.probabilityDamage = probabilityDamage;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getCoolDownTime() {
		return coolDownTime;
	}

	public void setCoolDownTime(int coolDownTime) {
		this.coolDownTime = coolDownTime;
	}

	public int getProbabilityAttack() {
		return probabilityAttack;
	}

	public void setProbabilityAttack(int probabilityAttack) {
		this.probabilityAttack = probabilityAttack;
	}

	public int getProbabilityDamage() {
		return probabilityDamage;
	}

	public void setProbabilityDamage(int probabilityDamage) {
		this.probabilityDamage = probabilityDamage;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
