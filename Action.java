package textBasedGame;

public class Action {

	private static boolean puzzle1TurnOff = false;
	private static boolean puzzle2TurnOff = false;
	private static boolean puzzle3TurnOff = false;
	private static boolean puzzle4TurnOff = false;
	private static boolean puzzle5TurnOff = false;

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

	public static void inspectWall(Locations world) {
		if (checkForRoom(world, 2, 2)) {
			System.out.println("The wall says: \n"
					+ "1. A robot may not injure a human being or, through inaction, allow a human being to come to harm."
					+ "\n2. A robot must obey the orders given it by human beings except where such orders would conflict with the First Law."
					+ "\n3. A robot must protect its own existence as long as such protection does not conflict with the First or Second Laws.");
		} else {
			System.out.println(world.getDescription());
		}
	}

	public static void openDoor(Locations world, Player p, String a) {

		if (world.getPlace().hasFinalDoor() == true) {
			if (p.getKeyCount() == 6) {
				System.out.println(
						"You open to the door to be blinded by bright sunlight. Breathing the fresh air you smile to"
								+ "\nyourself. You have escaped the facility.");
				Action.rollCredits();
			} else {
				System.out.println("Not enough keys." + " You need " + (6 - p.getKeyCount()) + " more.");
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

	public static void choosePuzzle(Locations world, Player player) {
		if (checkForRoom(world, 2, 0)) {
			Action.playPuzzle1(world, player);
		} else if (checkForRoom(world, 1, 0)) {
			Action.playPuzzle2(world, player);
		} else if (checkForRoom(world, 0, 0)) {
			Action.playPuzzle3(world, player);
		} else if (checkForRoom(world, 0, 2)) {
			Action.playPuzzle4(world, player);
		} else if (checkForRoom(world, 1, 2)) {
			Action.playPuzzle5(world, player);
		}
	}

	public static boolean checkForRoom(Locations world, int r, int c) {
		if (world.getRow() == r && world.getColumn() == c) {
			return true;
		} else {
			return false;
		}
	}

	public static void playPuzzle1(Locations world, Player player) {
		if (!puzzle1TurnOff) {
			Puzzle puzzle = world.getPlace().getPuzzle();
			puzzle.playGame(world, player);
		} else {
			System.out.println("The computer is turned off and you can no longer play the puzzle.");
		}

	}

	public static void playPuzzle2(Locations world, Player player) {
		if (!puzzle2TurnOff) {
			Puzzle puzzle = world.getPlace().getPuzzle();
			puzzle.playGame(world, player);
		} else {
			System.out.println("The computer is turned off and you can no longer play the puzzle.");
		}
	}

	public static void playPuzzle3(Locations world, Player player) {
		if (!puzzle3TurnOff) {
			Puzzle puzzle = world.getPlace().getPuzzle();
			puzzle.playGame(world, player);
		} else {
			System.out.println("The computer is now turned off and will not allow any other input");
		}
	}

	public static void playPuzzle4(Locations world, Player player) {
		if (!puzzle4TurnOff) {
			Puzzle puzzle = world.getPlace().getPuzzle();
			puzzle.playGame(world, player);
		} else {
			System.out.println("The computer is now turned off and will not allow any other input");
		}
	}

	public static void playPuzzle5(Locations world, Player player) {
		if (!puzzle5TurnOff) {
			Puzzle puzzle = world.getPlace().getPuzzle();
			puzzle.playGame(world, player);
		} else {
			System.out.println("The computer is now turned off and will not allow any other input");
		}
	}

	public static void killPuzzle(int whichPuzzle) {
		if (whichPuzzle == 1) {
			puzzle1TurnOff = true;
		} else if (whichPuzzle == 2) {
			puzzle2TurnOff = true;
		} else if (whichPuzzle == 3) {
			puzzle3TurnOff = true;
		} else if (whichPuzzle == 4) {
			puzzle4TurnOff = true;
		} else if (whichPuzzle == 5) {
			puzzle5TurnOff = true;
		}
	}

	public static void rollCredits() {
		String[] credits = { "Lead Coder - Lasse Nordahl", "Lead Coder - Zach Zulanas",
				"Giver of Extra Credit - Mrs. Allen", "Laws of Robotics Creator - Isaac Asimov" };
		System.out.println();

		System.out.println("----------------------------------------");
		System.out.println("                Credits                 ");
		System.out.println("----------------------------------------");
		for (int i = 0; i < credits.length; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			System.out.println(credits[i]);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		System.out.println();
		System.out.println("Thanks for playing!");
		System.exit(0);

	}

}
