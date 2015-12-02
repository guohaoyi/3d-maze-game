import java.applet.*;
import java.io.File;
import java.net.*;
import java.util.Random;

public class GamePlay {
	
	private Maze maze;
	private Player player;
	private Room[][] rooms;
	private int playerRow, playerCol;
	
	public GamePlay() {
		maze = new Maze(this);
		player = new Player();
		rooms = maze.getRooms();
		playerRow = 0;
		playerCol = 0;
		rooms[playerRow][playerCol].setPlayer(player);
	}
	
	public void move(String movement) {
		// Player's movements
		if (movement.equals("forward")) {
			// Forward
			if (player.getDirection() == 'n') {
				// North
				if (!rooms[playerRow][playerCol].isNorth()) {
					if (rooms[playerRow - 1][playerCol].getMonster() == null) {
						rooms[playerRow][playerCol].setPlayer(null);
						playerRow--;
						rooms[playerRow][playerCol].setPlayer(player);
						checkMonster();
					}
					else
						System.out.println("You cannot move through a live monster.");
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 'e') {
				// East
				if (!rooms[playerRow][playerCol].isEast()) {
					if (rooms[playerRow][playerCol + 1].getMonster() == null) {
						rooms[playerRow][playerCol].setPlayer(null);
						playerCol++;
						rooms[playerRow][playerCol].setPlayer(player);
						checkMonster();
					}
					else
						System.out.println("You cannot move through a live monster.");
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 's') {
				// South
				if (!rooms[playerRow][playerCol].isSouth()) {
					if (rooms[playerRow + 1][playerCol].getMonster() == null) {
						rooms[playerRow][playerCol].setPlayer(null);
						playerRow++;
						rooms[playerRow][playerCol].setPlayer(player);
						checkMonster();
					}
					else
						System.out.println("You cannot move through a live monster.");
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 'w') {
				// West
				if (!rooms[playerRow][playerCol].isWest()) {
					if (rooms[playerRow][playerCol - 1].getMonster() == null) {
						rooms[playerRow][playerCol].setPlayer(null);
						playerCol--;
						rooms[playerRow][playerCol].setPlayer(player);
						checkMonster();
					}
					else
						System.out.println("You cannot move through a live monster.");
				}
				else
					System.out.println("Out of bounds");
			}
		}
		else if (movement.equals("backward")) {
			// Backward
			if (player.getDirection() == 'n') {
				// North
				if (!rooms[playerRow][playerCol].isSouth()) {
					if (rooms[playerRow + 1][playerCol].getMonster() == null) {
						rooms[playerRow][playerCol].setPlayer(null);
						playerRow++;
						rooms[playerRow][playerCol].setPlayer(player);
						checkMonster();
					}
					else
						System.out.println("You cannot move through a live monster.");
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 'e') {
				// East
				if (!rooms[playerRow][playerCol].isWest()) {
					if (rooms[playerRow][playerCol - 1].getMonster() == null) {
						rooms[playerRow][playerCol].setPlayer(null);
						playerCol--;
						rooms[playerRow][playerCol].setPlayer(player);
						checkMonster();
					}
					else
						System.out.println("You cannot move through a live monster.");
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 's') {
				// South
				if (!rooms[playerRow][playerCol].isNorth()) {
					if (rooms[playerRow - 1][playerCol].getMonster() == null) {
						rooms[playerRow][playerCol].setPlayer(null);
						playerRow--;
						rooms[playerRow][playerCol].setPlayer(player);
						checkMonster();
					}
					else
						System.out.println("You cannot move through a live monster.");
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 'w') {
				// West
				if (!rooms[playerRow][playerCol].isEast()) {
					if (rooms[playerRow][playerCol + 1].getMonster() == null) {
						rooms[playerRow][playerCol].setPlayer(null);
						playerCol++;
						rooms[playerRow][playerCol].setPlayer(player);
						checkMonster();
					}
					else
						System.out.println("You cannot move through a live monster.");
				}
				else
					System.out.println("Out of bounds");
			}
		}
		else if (movement.equals("leftward")) {
			// Leftward
			if (player.getDirection() == 'n') {
				// North
				if (!rooms[playerRow][playerCol].isWest()) {
					if (rooms[playerRow][playerCol - 1].getMonster() == null) {
						rooms[playerRow][playerCol].setPlayer(null);
						playerCol--;
						rooms[playerRow][playerCol].setPlayer(player);
						checkMonster();
					}
					else
						System.out.println("You cannot move through a live monster.");
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 'e') {
				// East
				if (!rooms[playerRow][playerCol].isNorth()) {
					if (rooms[playerRow - 1][playerCol].getMonster() == null) {
						rooms[playerRow][playerCol].setPlayer(null);
						playerRow--;
						rooms[playerRow][playerCol].setPlayer(player);
						checkMonster();
					}
					else
						System.out.println("You cannot move through a live monster.");
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 's') {
				// South
				if (!rooms[playerRow][playerCol].isEast()) {
					if (rooms[playerRow][playerCol + 1].getMonster() == null) {
						rooms[playerRow][playerCol].setPlayer(null);
						playerCol++;
						rooms[playerRow][playerCol].setPlayer(player);
						checkMonster();
					}
					else
						System.out.println("You cannot move through a live monster.");
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 'w') {
				// West
				if (!rooms[playerRow][playerCol].isSouth()) {
					if (rooms[playerRow + 1][playerCol].getMonster() == null) {
						rooms[playerRow][playerCol].setPlayer(null);
						playerRow++;
						rooms[playerRow][playerCol].setPlayer(player);
						checkMonster();
					}
					else
						System.out.println("You cannot move through a live monster.");
				}
				else
					System.out.println("Out of bounds");
			}
		}
		else if (movement.equals("rightward")) {
			// Rightward
			if (player.getDirection() == 'n') {
				// North
				if (!rooms[playerRow][playerCol].isEast()) {
					if (rooms[playerRow][playerCol + 1].getMonster() == null) {
						rooms[playerRow][playerCol].setPlayer(null);
						playerCol++;
						rooms[playerRow][playerCol].setPlayer(player);
						checkMonster();
					}
					else
						System.out.println("You cannot move through a live monster.");
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 'e') {
				// East
				if (!rooms[playerRow][playerCol].isSouth()) {
					if (rooms[playerRow + 1][playerCol].getMonster() == null) {
						rooms[playerRow][playerCol].setPlayer(null);
						playerRow++;
						rooms[playerRow][playerCol].setPlayer(player);
						checkMonster();
					}
					else
						System.out.println("You cannot move through a live monster.");
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 's') {
				// South
				if (!rooms[playerRow][playerCol].isWest()) {
					if (rooms[playerRow][playerCol - 1].getMonster() == null) {
						rooms[playerRow][playerCol].setPlayer(null);
						playerCol--;
						rooms[playerRow][playerCol].setPlayer(player);
						checkMonster();
					}
					else
						System.out.println("You cannot move through a live monster.");
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 'w') {
				// West
				if (!rooms[playerRow][playerCol].isNorth()) {
					if (rooms[playerRow - 1][playerCol].getMonster() == null) {
						rooms[playerRow][playerCol].setPlayer(null);
						playerRow--;
						rooms[playerRow][playerCol].setPlayer(player);
						checkMonster();
					}
					else
						System.out.println("You cannot move through a live monster.");
				}
				else
					System.out.println("Out of bounds");
			}
		}
	}
	
	public void pickUpTreasure(Room room) {
		// Checks if there is a treasure in the room, if so, the player will pick up the treasure
		if (room.getTreasure() != null) {
			Treasure treasure = room.getTreasure();
			if (treasure.getGold() != 0) {
				player.increaseGold(treasure.getGold());
				System.out.println("You've got " + treasure.getGold() + " gold! You currently have " + player.getGold() + " gold");
			}
			if (treasure.getHealth() != 0) {
				player.increaseCurrentHealth(treasure.getHealth());
				System.out.println("You've got " + treasure.getHealth() + " health! Your current health is " + player.getCurrentHealth());
			}
			try {
				java.applet.AudioClip clip = java.applet.Applet.newAudioClip(new URL("http://www.mediacollege.com/downloads/sound-effects/money/cash-register-01.wav"));
				clip.play();
			} catch (java.net.MalformedURLException murle) {
				System.out.println(murle);
			}
			room.setTreasure(null);
		}
	}
	/*
	public void checkMonster(int row, int col) {
		if (rooms[row][col].getMonster() != null) {
			Monster monster = rooms[row][col].getMonster();
			(new Thread(monster)).start();
		}
	}
	*/
	/*
	public boolean checkMonster() {
		boolean isMonster = false;
		if (playerRow > 0) {
			if (rooms[playerRow-1][playerCol].getMonster() != null)
				isMonster = true;
		}
		if (playerCol < maze.getCol() - 1) {
			if (rooms[playerRow][playerCol+1].getMonster() != null)
				isMonster = true;
		}
		if (playerRow < maze.getRow() - 1) {
			if (rooms[playerRow+1][playerCol].getMonster() != null)
				isMonster = true;
		}
		if (playerCol > 0) {
			if (rooms[playerRow][playerCol-1].getMonster() != null)
				isMonster = true;
		}
		System.out.println(isMonster);
		return isMonster;
	}
	*/
	
	public void checkMonster() {
		boolean north = rooms[playerRow][playerCol].isNorth();
		boolean east = rooms[playerRow][playerCol].isEast();
		boolean south = rooms[playerRow][playerCol].isSouth();
		boolean west = rooms[playerRow][playerCol].isWest();
		if ((!north) && (playerRow > 0)) {
			if (rooms[playerRow - 1][playerCol].getMonster() != null) {
				rooms[playerRow - 1][playerCol].getMonster().setPlayerNearby(true);
				(new Thread(rooms[playerRow - 1][playerCol].getMonster())).start();
			}
		}
		if ((!east) && (playerCol < maze.getCol() - 1)) {
			if (rooms[playerRow][playerCol + 1].getMonster() != null) {
				rooms[playerRow][playerCol + 1].getMonster().setPlayerNearby(true);
				(new Thread(rooms[playerRow][playerCol + 1].getMonster())).start();
			}
		}
		if ((!south) && (playerRow < maze.getRow() - 1)) {
			if (rooms[playerRow + 1][playerCol].getMonster() != null) {
				rooms[playerRow + 1][playerCol].getMonster().setPlayerNearby(true);
				(new Thread(rooms[playerRow + 1][playerCol].getMonster())).start();
			}
		}
		if ((!west) && (playerCol > 0)) {
			if (rooms[playerRow][playerCol - 1].getMonster() != null) {
				rooms[playerRow][playerCol - 1].getMonster().setPlayerNearby(true);
				(new Thread(rooms[playerRow][playerCol - 1].getMonster())).start();
			}
		}
	}
	
	public void attack(Room room) {
		Monster monster = room.getMonster();
		Random rand = new Random();
		int attack = rand.nextInt(100);
		if (attack < monster.getProbabilityDamage()) {
			System.out.println("You hit the monster!");
			int playerAttack = 10;
			monster.setHealth(monster.getHealth() - playerAttack);
		}
		else
			System.out.println("You missed!");
		if (monster.getHealth() <= 0) {
			monster.setPlayerNearby(false);
			room.setMonster(null);
		}
	}
	
	public void monsterAttack(Monster monster) {
		Random rand = new Random();
		int attack = rand.nextInt(100);
		if (attack < monster.getProbabilityAttack()) {
			System.out.println("Monster hit you!");
			player.setCurrentHealth(player.getCurrentHealth() - monster.getDamage());
			
			try {
				java.applet.AudioClip clip = java.applet.Applet.newAudioClip(new File("bin/bruh.wav").toURI().toURL());
				clip.play();
			} catch (java.net.MalformedURLException murle) {
				System.out.println(murle);
			}
			
			/*
			try {
				AudioClip clip = Applet.newAudioClip(new URL("http://www.mediacollege.com/downloads/sound-effects/money/cash-register-01.wav"));
				clip.play();
				} catch (MalformedURLException murle) {
				System.out.println(murle);
				}
				*/
		}
		else
			System.out.println("Monster tried to attack you but missed!");
	}
	
	public Room getNextRoom() {
		Room room = null;
		if (player.getDirection() == 'n') {
			// North
			if (!rooms[playerRow][playerCol].isNorth())
				room = rooms[playerRow-1][playerCol];
		}
		else if (player.getDirection() == 'e') {
			// East
			if (!rooms[playerRow][playerCol].isEast())
				room = rooms[playerRow][playerCol+1];
		}
		else if (player.getDirection() == 's') {
			// South
			if (!rooms[playerRow][playerCol].isSouth())
				room = rooms[playerRow+1][playerCol];
		}
		else if (player.getDirection() == 'w') {
			// West
			if (!rooms[playerRow][playerCol].isWest())
				room = rooms[playerRow][playerCol-1];
		}
		return room;
	}
	
	public Maze getMaze() {
		return maze;
	}

	public void setMaze(Maze maze) {
		this.maze = maze;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getPlayerRow() {
		return playerRow;
	}

	public void setPlayerRow(int playerRow) {
		this.playerRow = playerRow;
	}

	public int getPlayerCol() {
		return playerCol;
	}

	public void setPlayerCol(int playerCol) {
		this.playerCol = playerCol;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
