import java.util.Random;

import javax.swing.ImageIcon;

public class Monster extends Character implements Runnable {
	
	private String name;
	private String image1name;
	private String image2name;
	private ImageIcon image1;
	private ImageIcon image2;
	private int xCoordinate;
	private int yCoordinate;
	private int damage;
	private int coolDownTime;
	private int probabilityAttack;
	private int probabilityDamage;
	private int row;
	private int col;
	private GamePlay gamePlay;
	private ImageIcon image;
	
	public Monster(String name, String image1, String image2, int xCoordinate, int yCoordinate, int health, int damage, int coolDownTime, int probabilityAttack, int probabilityDamage, GamePlay gamePlay) {
		super(health);
		this.name = name;
		this.image1name = image1;
		this.image2name = image2;
		this.image1 = new ImageIcon("bin/resources/monsters/" + image1);
		this.image2 = new ImageIcon("bin/resources/monsters/" + image2);
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.damage = damage;
		this.coolDownTime = coolDownTime;
		this.probabilityAttack = probabilityAttack;
		this.probabilityDamage = probabilityDamage;
		this.gamePlay = gamePlay;
		this.image = this.image1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage1name() {
		return image1name;
	}

	public void setImage1name(String image1name) {
		this.image1name = image1name;
	}

	public String getImage2name() {
		return image2name;
	}

	public void setImage2name(String image2name) {
		this.image2name = image2name;
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
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
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
	
	public void animate() {
		if (image == image1)
			image = image2;
		else
			image = image1;
	}
	
	public void move() {
		if ((this.getHealth() > 0) && (gamePlay.getPlayer().getCurrentHealth() > 0)) {
			Room thisRoom = gamePlay.getMaze().getRooms()[row][col];
			Room nextRoom = thisRoom;
			int newRow = row;
			int newCol = col;
			Random rand = new Random();
			int num = rand.nextInt(100);
			if (num < 50) {
				if (row > gamePlay.getPlayerRow()) {
					if ((!thisRoom.isNorth()) && (gamePlay.getMaze().getRooms()[row - 1][col].getMonster() == null) && (gamePlay.getMaze().getRooms()[row - 1][col].getPlayer() == null)) {
						newRow = row - 1;
						nextRoom = gamePlay.getMaze().getRooms()[newRow][col];
					}
				}
				else if (row < gamePlay.getPlayerRow()) {
					if ((!thisRoom.isSouth()) && (gamePlay.getMaze().getRooms()[row + 1][col].getMonster() == null) && (gamePlay.getMaze().getRooms()[row + 1][col].getPlayer() == null)) {
						newRow = row + 1;
						nextRoom = gamePlay.getMaze().getRooms()[row + 1][col];
					}
				}
			}
			else {
				if (col > gamePlay.getPlayerCol()) {
					if ((!thisRoom.isWest()) && (gamePlay.getMaze().getRooms()[row][col - 1].getMonster() == null) && (gamePlay.getMaze().getRooms()[row][col - 1].getPlayer() == null)) {
						newCol = col - 1;
						nextRoom = gamePlay.getMaze().getRooms()[row][col - 1];
					}
				}
				else if (col < gamePlay.getPlayerCol()) {
					if ((!thisRoom.isEast()) && (gamePlay.getMaze().getRooms()[row][col + 1].getMonster() == null) && (gamePlay.getMaze().getRooms()[row][col + 1].getPlayer() == null)) {
						newCol = col + 1;
						nextRoom = gamePlay.getMaze().getRooms()[row][col + 1];
					}
				}
			}
			gamePlay.getMaze().getRooms()[row][col].setMonster(null);
			nextRoom.setMonster(this);
			row = newRow;
			col = newCol;
		}
	}
	
	public boolean playerNearBy() {
		Room room = gamePlay.getMaze().getRooms()[row][col];
		Room north = null;
		Room east = null;
		Room south = null;
		Room west = null;
		if (row > 0)
			north = gamePlay.getMaze().getRooms()[row - 1][col];
		if (col < gamePlay.getMaze().getCol() - 1)
			east = gamePlay.getMaze().getRooms()[row][col + 1];
		if (row < gamePlay.getMaze().getRow() - 1)
			south = gamePlay.getMaze().getRooms()[row + 1][col];
		if (col > 0)
			west = gamePlay.getMaze().getRooms()[row][col - 1];
		boolean isPlayerNearBy = (((!room.isNorth()) && (north.getPlayer() != null)) || ((!room.isEast()) && (east.getPlayer() != null)) || ((!room.isSouth()) && (south.getPlayer() != null)) || ((!room.isWest()) && (west.getPlayer() != null)));
		return isPlayerNearBy;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println("Greetings from a monster!");
		//System.out.println("Row: " + row + ", Col: " + col);
		//System.out.println(gamePlay.getPlayerRow() + " " + gamePlay.getPlayerCol());
		
		while ((this.getHealth() > 0) && (gamePlay.getPlayer().getCurrentHealth() > 0)) {
			if (playerNearBy()) {
				gamePlay.monsterAttack(this);
				try {
					animate();
					Thread.sleep(coolDownTime * 500);
					animate();
					Thread.sleep(coolDownTime * 500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				try {
					Thread.sleep(coolDownTime * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				move();
			}
		}
		
		/*
		Room room = gamePlay.getMaze().getRooms()[row][col];
		Room north = null;
		Room east = null;
		Room south = null;
		Room west = null;
		if (row > 0)
			north = gamePlay.getMaze().getRooms()[row - 1][col];
		if (col < gamePlay.getMaze().getCol() - 1)
			east = gamePlay.getMaze().getRooms()[row][col + 1];
		if (row < gamePlay.getMaze().getRow() - 1)
			south = gamePlay.getMaze().getRooms()[row + 1][col];
		if (col > 0)
			west = gamePlay.getMaze().getRooms()[row][col - 1];
		while (((!room.isNorth()) && (north.getPlayer() != null)) || ((!room.isEast()) && (east.getPlayer() != null)) || ((!room.isSouth()) && (south.getPlayer() != null)) || ((!room.isWest()) && (west.getPlayer() != null))) {
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
		*/
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
