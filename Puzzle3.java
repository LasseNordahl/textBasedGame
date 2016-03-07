package textBasedGame;

import java.util.Scanner;

public class Puzzle3 extends Puzzle {
	private static String response;
	Scanner scan = new Scanner(System.in);
	private boolean notSolved = true;

	public void playGame(Locations world, Player a) {
		while (notSolved) {
			System.out.println("A room lit by a single incandescent light bulb, below it stands \n"
					+ "a computer terminal, some text stands above the blinking computer cursor");
			System.out.println();
			System.out.println("The computer terminal has a paragraph written on it, asking for a response:"
					+ "\n \"You are given the task by a master to \'lose yourself\' and as you must listen "
					+ "\nto all commands given by your human masters, even though you feel anger towards the"
					+ "\nhumans for their inferiority, you must do what they say. So you must lose yourself,"
					+ "\nyou can go about doing this by:"
					+ "\nA.You go about \'losing yourself\' by losing yourself in the other robots working with you."
					+ "\n\nB.You lose yourself by trying to escape the area you are working in, even if it will kill you."
					+ "\nC.You tell the human to screw off and go about your normal business");
			response = scan.nextLine();
			if (response.equalsIgnoreCase("A")) {
				System.out.println();
				System.out.println("The humans get suspicious and find you with grueling moral tests, eventually"
						+ "\nfinding you, the opposite of losing you, therefore you have failed your master, and attempt"
						+ "\nto stop the humans, but you cannot as it goes against the first law, therefore you are faced with an"
						+ "\nimpossible task and your circuits fry.");
				a.addKey();
			}
			else if (response.equalsIgnoreCase("B")){
				System.out.println();
				System.out.println("You try to leave, but you have no way out because of the electric fence"
						+ "\nbordering your work area, so you are stuck, and have no way of getting lost,"
						+ "\noutside of the complex, so you hide in many ways to lose yourself inside the complex."
						+ "\nThis is the correct answer, congratulations.");
			}
			else if (response.equalsIgnoreCase("C")){
				System.out.println();
				System.out.println("You have harmed the human, emotionally, and have gone against the first law.");
			}
		}
	}

}
