import java.util.Random;

import javax.swing.ImageIcon;

public class Monster extends Character implements Runnable {
	
	private String name;
	private ImageIcon image1;
	private ImageIcon image2;
	private int xCoordinate;
	private int yCoordinate;
	private int damage;
	private int coolDownTime;
	private int probabilityAttack;
	private int probabilityDamage;
	private GamePlay gamePlay;
	
	public Monster(String name, String image1, String image2, int xCoordinate, int yCoordinate, int health, int damage, int coolDownTime, int probabilityAttack, int probabilityDamage, GamePlay gamePlay) {
		super(health);
		this.name = name;
		this.image1 = new ImageIcon("bin/resources/monsters/" + image1);
		this.image2 = new ImageIcon("bin/resources/monsters/" + image2);
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.damage = damage;
		this.coolDownTime = coolDownTime;
		this.probabilityAttack = probabilityAttack;
		this.probabilityDamage = probabilityDamage;
		this.gamePlay = gamePlay;
		setVisible(false);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageIcon getImage1() {
		return image1;
	}

	public void setImage1(ImageIcon image1) {
		this.image1 = image1;
	}

	public ImageIcon getImage2() {
		return image2;
	}

	public void setImage2(ImageIcon image2) {
		this.image2 = image2;
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
	
	public String toString() {
		return name.substring(0, 1);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Greetings from a monster!");
		//Random rand = new Random();
		//int attack = rand.nextInt(100);
		//if (attack < damage) {
			
		//}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
