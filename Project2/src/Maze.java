import java.io.FileNotFoundException;
import java.io.FileReader;

public class Maze {
	
	private Room[][] rooms = new Room[50][50];
	
	public Maze() {
		readMap();
		readMonsters();
		readTreasures();
	}
	
	public void readMap() {
		try {
			FileReader fin = new FileReader("bin//map.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Caught FileNotFoundException: " + e.getMessage());
		}
	}
	
	public void readMonsters() {
		try {
			FileReader fin = new FileReader("bin//monsters.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Caught FileNotFoundException: " + e.getMessage());
		}
	}
	
	public void readTreasures() {
		try {
			FileReader fin = new FileReader("bin//treasures.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Caught FileNotFoundException: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
