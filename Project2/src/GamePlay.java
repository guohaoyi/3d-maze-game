
public class GamePlay {
	
	private Maze maze;
	private Player player;
	private Room[][] rooms;
	private int playerRow, playerCol;
	
	public GamePlay() {
		maze = new Maze();
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
					rooms[playerRow][playerCol].setPlayer(null);
					playerRow--;
					rooms[playerRow][playerCol].setPlayer(player);
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 'e') {
				// East
				if (!rooms[playerRow][playerCol].isEast()) {
					rooms[playerRow][playerCol].setPlayer(null);
					playerCol++;
					rooms[playerRow][playerCol].setPlayer(player);
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 's') {
				// South
				if (!rooms[playerRow][playerCol].isSouth()) {
					rooms[playerRow][playerCol].setPlayer(null);
					playerRow++;
					rooms[playerRow][playerCol].setPlayer(player);
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 'w') {
				// West
				if (!rooms[playerRow][playerCol].isWest()) {
					rooms[playerRow][playerCol].setPlayer(null);
					playerCol--;
					rooms[playerRow][playerCol].setPlayer(player);
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
					rooms[playerRow][playerCol].setPlayer(null);
					playerRow++;
					rooms[playerRow][playerCol].setPlayer(player);
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 'e') {
				// East
				if (!rooms[playerRow][playerCol].isWest()) {
					rooms[playerRow][playerCol].setPlayer(null);
					playerCol--;
					rooms[playerRow][playerCol].setPlayer(player);
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 's') {
				// South
				if (!rooms[playerRow][playerCol].isNorth()) {
					rooms[playerRow][playerCol].setPlayer(null);
					playerRow--;
					rooms[playerRow][playerCol].setPlayer(player);
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 'w') {
				// West
				if (!rooms[playerRow][playerCol].isEast()) {
					rooms[playerRow][playerCol].setPlayer(null);
					playerCol++;
					rooms[playerRow][playerCol].setPlayer(player);
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
					rooms[playerRow][playerCol].setPlayer(null);
					playerCol--;
					rooms[playerRow][playerCol].setPlayer(player);
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 'e') {
				// East
				if (!rooms[playerRow][playerCol].isNorth()) {
					rooms[playerRow][playerCol].setPlayer(null);
					playerRow--;
					rooms[playerRow][playerCol].setPlayer(player);
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 's') {
				// South
				if (!rooms[playerRow][playerCol].isEast()) {
					rooms[playerRow][playerCol].setPlayer(null);
					playerCol++;
					rooms[playerRow][playerCol].setPlayer(player);
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 'w') {
				// West
				if (!rooms[playerRow][playerCol].isSouth()) {
					rooms[playerRow][playerCol].setPlayer(null);
					playerRow++;
					rooms[playerRow][playerCol].setPlayer(player);
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
					rooms[playerRow][playerCol].setPlayer(null);
					playerCol++;
					rooms[playerRow][playerCol].setPlayer(player);
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 'e') {
				// East
				if (!rooms[playerRow][playerCol].isSouth()) {
					rooms[playerRow][playerCol].setPlayer(null);
					playerRow++;
					rooms[playerRow][playerCol].setPlayer(player);
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 's') {
				// South
				if (!rooms[playerRow][playerCol].isWest()) {
					rooms[playerRow][playerCol].setPlayer(null);
					playerCol--;
					rooms[playerRow][playerCol].setPlayer(player);
				}
				else
					System.out.println("Out of bounds");
			}
			else if (player.getDirection() == 'w') {
				// West
				if (!rooms[playerRow][playerCol].isNorth()) {
					rooms[playerRow][playerCol].setPlayer(null);
					playerRow--;
					rooms[playerRow][playerCol].setPlayer(player);
				}
				else
					System.out.println("Out of bounds");
			}
		}
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
