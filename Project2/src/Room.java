
public class Room {
	
	private Monster monster;
	private Treasure treasure;
	private boolean north;
	private boolean east;
	private boolean south;
	private boolean west;
	private String texture;
	private Player player;
	
	public Room(Monster monster, Treasure treasure, boolean north, boolean east, boolean south, boolean west, String texture) {
		this.monster = monster;
		this.treasure = treasure;
		this.north = north;
		this.east = east;
		this.south = south;
		this.west = west;
		this.texture = texture;
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public Treasure getTreasure() {
		return treasure;
	}

	public void setTreasure(Treasure treasure) {
		this.treasure = treasure;
	}

	public boolean isNorth() {
		return north;
	}

	public void setNorth(boolean north) {
		this.north = north;
	}

	public boolean isEast() {
		return east;
	}

	public void setEast(boolean east) {
		this.east = east;
	}

	public boolean isSouth() {
		return south;
	}

	public void setSouth(boolean south) {
		this.south = south;
	}

	public boolean isWest() {
		return west;
	}

	public void setWest(boolean west) {
		this.west = west;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
