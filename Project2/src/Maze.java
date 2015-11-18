import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

public class Maze extends Observable {
	
	private ArrayList<Monster> monsters = new ArrayList<Monster>();
	private ArrayList<String> monsterNames = new ArrayList<String>();
	private ArrayList<Treasure> treasures = new ArrayList<Treasure>();
	private ArrayList<String> treasureNames = new ArrayList<String>();
	private Room[][] rooms;
	private int row, col;
	
	public Maze() {
		super();
		readMonsters();
		readTreasures();
		readMap();
	}
	
	public void readMap() {
		// Reads in map.txt file, creates rooms, and stores them in a double array
		try {
			FileReader fin = new FileReader("bin/map.txt");
			Scanner scan = new Scanner(fin);
			scan.nextInt();
			row = scan.nextInt();
			col = scan.nextInt();
			rooms = new Room[row][col];
			scan.nextLine();
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					scan.nextLine();
					String monsterName = scan.nextLine();
					int monsterIndex = monsterNames.indexOf(monsterName);
					Monster monster = null;
					if (monsterIndex != -1)
						monster = monsters.get(monsterIndex);
					String treasureName = scan.nextLine();
					int treasureIndex = treasureNames.indexOf(treasureName);
					Treasure treasure = null;
					if (treasureIndex != -1)
						treasure = treasures.get(treasureIndex);
					boolean north = Boolean.parseBoolean(scan.nextLine());
					boolean east = Boolean.parseBoolean(scan.nextLine());
					boolean south = Boolean.parseBoolean(scan.nextLine());
					boolean west = Boolean.parseBoolean(scan.nextLine());
					String texture = scan.nextLine();
					rooms[i][j] = new Room(monster, treasure, north, east, south, west, texture);
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("Caught FileNotFoundException: " + e.getMessage());
		}
	}
	
	public void readMonsters() {
		// Reads in monsters.txt file, creates monsters, and stores them in an ArrayList
		try {
			FileReader fin = new FileReader("bin/monsters.txt");
			Scanner scan = new Scanner(fin);
			int num = scan.nextInt();
			for (int i = 0; i < num; i++) {
				scan.nextLine();
				scan.nextLine();
				String name = scan.nextLine();
				monsterNames.add(name);
				String image1 = scan.nextLine();
				String image2 = scan.nextLine();
				int xCoordinate = scan.nextInt();
				int yCoordinate = scan.nextInt();
				int health = scan.nextInt();
				int damage = scan.nextInt();
				int coolDownTime = scan.nextInt();
				int probabilityAttack = scan.nextInt();
				int probabilityDamage = scan.nextInt();
				Monster m = new Monster(name, image1, image2, xCoordinate, yCoordinate, health, damage, coolDownTime, probabilityAttack, probabilityDamage);
				monsters.add(m);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("Caught FileNotFoundException: " + e.getMessage());
		}
	}
	
	public void readTreasures() {
		// Reads in treasures.txt file, creates treasures, and stores them in an ArrayList
		try {
			FileReader fin = new FileReader("bin/treasures.txt");
			Scanner scan = new Scanner(fin);
			int num = scan.nextInt();
			for (int i = 0; i < num; i++) {
				scan.nextLine();
				scan.nextLine();
				String name = scan.nextLine();
				treasureNames.add(name);
				String image = scan.nextLine();
				int gold = scan.nextInt();
				int health = scan.nextInt();
				int width = scan.nextInt();
				int height = scan.nextInt();
				int xCoordinate = scan.nextInt();
				int yCoordinate = scan.nextInt();
				Treasure t = new Treasure(name, image, gold, health, width, height, xCoordinate, yCoordinate);
				treasures.add(t);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("Caught FileNotFoundException: " + e.getMessage());
		}
	}

	public Room[][] getRooms() {
		return rooms;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
