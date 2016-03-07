package textBasedGame;

public class Locations extends NamedThing {

	Place[][] locations = new Place[3][3];
	private int r = 2;
	private int c = 1;

	public Locations(String name, String description) {
		super(name, description);

		// when a Locations object is created, a world is built
		buildWorld();
	}

	public void buildWorld(){
			locations[0][0] = new Room("Room 0030 ", "A blank room lit by a single incandescent light bulb surrounds you, below it stands " +
	"\na table, with a dust-ridden computer terminal, it looks semi damaged too.", true, 3);
		locations[0][0].addCommand("move right");
		locations[0][0].addCommand("look at map");
		locations[0][0].createPuzzle(3);
			locations[1][0] = new Room("Room 0029 ", "Before you stands a boring old room, maybe the room builders should add some detail." +
		"\nA computer terminal stands in the middle of the room, covered in dust and with a blinking cursor", true, 2);
		locations[1][0].addCommand("move right");
		locations[1][0].addCommand("look at map");
		locations[1][0].createPuzzle(2);
		
			locations[2][0] = new Room("Room 0028 ", "A Room lit by flourescent light, barren of detail surrounds you," +
		 "\nonly blocky lights are present in the back of the room.", false, 1);
		locations[2][0].addCommand("move right");
		locations[2][0].addCommand("look at map");
		locations[2][0].createPuzzle(1);
			locations[0][1] = new Hallway("Hallway ", "A section of the hallway surrounds you, " +
		"a door stands in front of you with 6 locks.");
		locations[0][1].addCommand("move forward");
		locations[0][1].addCommand("move backward");
		locations[0][1].addCommand("move right");
		locations[0][1].addCommand("move left");
		locations[0][1].addCommand("look around");
		locations[0][1].addCommand("open door");
		locations[0][1].addCommand("look at map");
			locations[1][1] = new Hallway("Hallway ", "A section of the hallway surrounds you, " +
		"a door stands at the end of the hallway.");
		locations[1][1].addCommand("move forward");
		locations[1][1].addCommand("move backward");
		locations[1][1].addCommand("move right");
		locations[1][1].addCommand("move left");
		locations[1][1].addCommand("look around");
		locations[1][1].addCommand("look at map");
			locations[2][1] = new Hallway("Hallway ", "A section of the hallway surrounds you, " +
		"a door stands at the end of the hallway.");
		locations[2][1].addCommand("move forward");
		locations[2][1].addCommand("move backward");
		locations[2][1].addCommand("move right");
		locations[2][1].addCommand("move left");
		locations[2][1].addCommand("look around");
		locations[2][1].addCommand("look at map");
		locations[0][2] = new Room("Room 0051 ", "In front of you stands a table, upon that is a dusty old computer terminal." +
				"a computer terminal", true, 4);
		locations[0][2].addCommand("move left");
		locations[0][2].addCommand("look at map");
		locations[1][2] = new Room("Room 0052 ", "A computer terminal, dullish, covered in dust is in front of you, you think you've seen this before", true, 5);
		locations[1][2].addCommand("move left");
		locations[1][2].addCommand("look at map");
		locations[2][2] = new Room("Room 0053 ",
				"A room lit by only the hallway light is in front of you with text etched on the wall", true, 6);
		locations[2][2].addCommand("move left");
		locations[2][2].addCommand("look at map");
		locations[2][2].addCommand("inspect wall");
	}

	public void moveUp() {
		if (r > 0) {
			r--;
		} else {
			System.out.println("\nInvalid Move");
		}
	}

	public void moveDown() {
		if (r < 2) {
			r++;
		} else {
			System.out.println("\nInvalid Move");
		}
	}

	public void moveLeft() {
		if (c > 0) {
			c--;
		} else {
			System.out.println("\nInvalid Move");
		}
	}

	public void moveRight() {
		if (c < 2) {
			c++;
		} else {
			System.out.println("\nInvalid Move");
		}
	}

	public int getColumn() {
		return c;
	}

	public int getRow() {
		return r;
	}

	public Place getPlace() {
		return locations[r][c];
	}

}
