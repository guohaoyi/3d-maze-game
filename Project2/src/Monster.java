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
	private boolean playerNearby;
	private ImageIcon image;
	
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
		this.playerNearby = false;
		this.image = this.image1;
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
	
	public boolean isPlayerNearby() {
		return playerNearby;
	}

	public void setPlayerNearby(boolean playerNearby) {
		this.playerNearby = playerNearby;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public String toString() {
		return name.substring(0, 1);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Greetings from a monster!");
		while (playerNearby) {
			gamePlay.monsterAttack(this);
			if (image == image1)
				image = image2;
			else
				image = image1;
			try {
				Thread.sleep(coolDownTime * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
