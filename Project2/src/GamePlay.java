
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
		if (movement.equals("forward")) {
			if (player.getDirection() == 'n') {
				rooms[playerRow][playerCol].setPlayer(null);
				playerRow--;
				rooms[playerRow][playerCol].setPlayer(player);
			}
			else if (player.getDirection() == 'e') {
				rooms[playerRow][playerCol].setPlayer(null);
				playerCol++;
				rooms[playerRow][playerCol].setPlayer(player);
			}
			else if (player.getDirection() == 's') {
				rooms[playerRow][playerCol].setPlayer(null);
				playerRow++;
				rooms[playerRow][playerCol].setPlayer(player);
			}
			else if (player.getDirection() == 'w') {
				rooms[playerRow][playerCol].setPlayer(null);
				playerCol--;
				rooms[playerRow][playerCol].setPlayer(player);
			}
		}
		else if (movement.equals("backward")) {
			if (player.getDirection() == 'n') {
				rooms[playerRow][playerCol].setPlayer(null);
				playerRow++;
				rooms[playerRow][playerCol].setPlayer(player);
			}
			else if (player.getDirection() == 'e') {
				rooms[playerRow][playerCol].setPlayer(null);
				playerCol--;
				rooms[playerRow][playerCol].setPlayer(player);
			}
			else if (player.getDirection() == 's') {
				rooms[playerRow][playerCol].setPlayer(null);
				playerRow--;
				rooms[playerRow][playerCol].setPlayer(player);
			}
			else if (player.getDirection() == 'w') {
				rooms[playerRow][playerCol].setPlayer(null);
				playerCol++;
				rooms[playerRow][playerCol].setPlayer(player);
			}
		}
		else if (movement.equals("leftward")) {
			if (player.getDirection() == 'n') {
				rooms[playerRow][playerCol].setPlayer(null);
				playerCol--;
				rooms[playerRow][playerCol].setPlayer(player);
			}
			else if (player.getDirection() == 'e') {
				rooms[playerRow][playerCol].setPlayer(null);
				playerRow--;
				rooms[playerRow][playerCol].setPlayer(player);
			}
			else if (player.getDirection() == 's') {
				rooms[playerRow][playerCol].setPlayer(null);
				playerCol++;
				rooms[playerRow][playerCol].setPlayer(player);
			}
			else if (player.getDirection() == 'w') {
				rooms[playerRow][playerCol].setPlayer(null);
				playerRow++;
				rooms[playerRow][playerCol].setPlayer(player);
			}
		}
		else if (movement.equals("rightward")) {
			if (player.getDirection() == 'n') {
				rooms[playerRow][playerCol].setPlayer(null);
				playerCol++;
				rooms[playerRow][playerCol].setPlayer(player);
			}
			else if (player.getDirection() == 'e') {
				rooms[playerRow][playerCol].setPlayer(null);
				playerRow++;
				rooms[playerRow][playerCol].setPlayer(player);
			}
			else if (player.getDirection() == 's') {
				rooms[playerRow][playerCol].setPlayer(null);
				playerCol--;
				rooms[playerRow][playerCol].setPlayer(player);
			}
			else if (player.getDirection() == 'w') {
				rooms[playerRow][playerCol].setPlayer(null);
				playerRow--;
				rooms[playerRow][playerCol].setPlayer(player);
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
