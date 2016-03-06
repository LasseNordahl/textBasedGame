package textBasedGame;

public class Action {

	public Action() {

	}

	public static void move(Locations world, String a, Player player) {
		if (a.equalsIgnoreCase("move forward")) {
			if (world.getColumn() == 1) {
				world.moveUp();
			} else {
				System.out.println("There is no door there");
			}
		} else {
			if (a.equalsIgnoreCase("move backward")) {
				if (world.getColumn() == 1) {
					world.moveDown();
				} else {
					System.out.println("There is no door there");
				}
			} else {
				if (a.equalsIgnoreCase("move left")) {
					world.moveLeft();
				} else {
					if (a.equalsIgnoreCase("move right")) {
						world.moveRight();
					} else {
						System.out.println("You can't do that");
					}
				}

			}

		}
		Action.choosePuzzle(world, player);
	}

	public static void help(Locations world, String a) {
		System.out.println(world.getPlace().getCommands());
	}

	public static void openDoor(Locations world, Player p, String a) {
		// System.out.println("got here");
		if (world.getPlace().hasFinalDoor() == true) {
			if (p.getKeyCount() == 6) {
				System.out.println("You beat the game!");
				// System.exit(0);
			} else {
				System.out.println("Not enough keys");
			}
		} else {
			System.out.println("You can't do that here");
		}
	}

	public static void useMap(Locations world, Player p) {
		if (p.checkForItem("map")) {
			Map.printMap(world, p);
		}
	}

	public static void lookAround(Locations world) {
		System.out.println(world.getPlace().getDescription());
	}

	public static void inspectWall(Locations world) {
		if (checkForRoom(world, 2, 2)) {
			System.out.println("The wall says: \n"
					+ "A robot may not injure a human being or, through inaction, allow a human being to come to harm."
					+ "\nA robot must obey the orders given it by human beings except where such orders would conflict with the First Law."
					+ "\nA robot must protect its own existence as long as such protection does not conflict with the First or Second Laws.");
		} else {
			System.out.println(world.getDescription());
		}
	}

	public static void choosePuzzle(Locations world, Player player) {
		if (checkForRoom(world, 2, 0)) {
			Action.playPuzzle2(world, player);
		} else if (checkForRoom(world, 1, 0)) {
			Action.playPuzzle1(world);
		}
	}

	public static boolean checkForRoom(Locations world, int r, int c) {
		if (world.getRow() == r && world.getColumn() == c) {
			return true;
		} else {
			return false;
		}
	}

	public static void playPuzzle1(Locations world) {
		Puzzle puzzle = world.getPlace().getPuzzle();
		puzzle.playGame(world);
	}

	public static void playPuzzle2(Locations world, Player player) {
		Puzzle puzzle = world.getPlace().getPuzzle();
		puzzle.playGame(world);
	}

}
