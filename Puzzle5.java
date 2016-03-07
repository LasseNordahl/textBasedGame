package textBasedGame;

import java.util.Scanner;

public class Puzzle5 extends Puzzle {
	private static String response;
	Scanner scan = new Scanner(System.in);
	private boolean notSolved = true;

	public void playGame(Locations world, Player a) {
		while (notSolved) {
			System.out.println("A room lit by a single incandescent light bulb, below it stands \n"
					+ "a computer terminal, some text stands above the blinking computer cursor");
			System.out.println();
			System.out.println("You are stationed on a solar energy converter station, that beams energy to, \"Earth\""
					+ "\nas the humans you are working with state, but you have no reasonable logic to believe in"
					+ "\nEarth's existence, only the word of the two humans you are working with, you are given orders to"
					+ "\nmaintain the station, Earth or no Earth, so how do you deal with the \"existence\" of Earth?"
					+ "\n A.Dispute their claims and tell them they have no reasonable logic to prove that Earth exists"
					+ "\n B.Disregard orders and show them why they are wrong"
					+ "\n C.Try to use your knowledge of the solar converter to show that Earth does not exist.");
			response = scan.nextLine();
			if (response.equalsIgnoreCase("A")) {
				System.out.println();
				System.out.println("You do not violate any laws of robotics by doing this, and are still doing your job. Congratulations you passed.");
				a.addKey();
				notSolved = true;
			}
			else if (response.equalsIgnoreCase("B")){
				System.out.println();
				System.out.println("Disregarding orders is against the second law, you have failed.");
				
			}
			else if (response.equalsIgnoreCase("C")){
				System.out.println();
				System.out.println("By taking time away from monitoring the solar converter, you are going against your second law, you have failed.");
			}
		}
	}

}
