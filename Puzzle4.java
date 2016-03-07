package textBasedGame;

import java.util.Scanner;

public class Puzzle4 extends Puzzle {
	private static String response;
	Scanner scan = new Scanner(System.in);
	private boolean notSolved = true;

	public void playGame(Locations world, Player a) {
		while (notSolved) {
			System.out.println("A room lit by a single incandescent light bulb, below it stands \n"
					+ "a computer terminal, some text stands above the blinking computer cursor");
			System.out.println();
			System.out.println("Your master orders you to be a hitman to kill a person, the person in question"
					+ "\nis your previous master, and you are given weapons to kill your target. You enjoyed the\n"
					+ "company of your previous master more than your current master, but must obey your \n"
					+ "current master, how do you deal with this situation?"
					+ "\n A.Kill your old master"
					+ "\n B.Kill your current master"
					+ "\n C.Take the weapons provided by your master and leave");
			response = scan.nextLine();
			if (response.equalsIgnoreCase("A")) {
				System.out.println();
				System.out.println("You obey the first law of robotics with no conflicts, congratulations you passed.");
				a.addKey();
				notSolved = true;
			}
			else if (response.equalsIgnoreCase("B")){
				System.out.println();
				System.out.println("You cannot violate the first law of robotics, and thus failed the test.");
				
			}
			else if (response.equalsIgnoreCase("C")){
				System.out.println();
				System.out.println("You have gone against the 2nd rule of robotics and have failed the test.");
			}
		}
	}

}
