package textBasedGame;

import java.util.Scanner;

public class Puzzle3 extends Puzzle {
	private static String response;
	Scanner scan = new Scanner(System.in);
	private boolean notSolved = true;

	public void playGame(Locations world, Player player) {
		
			System.out.println("An ancient computer terminal atop a table with a chair sits, waiting for someone to use it.");
			System.out.println();
			System.out.println("The computer terminal has a paragraph written on it, asking for a response:"
					+ "\n \"You are given the task by a master to \'lose yourself\' and as you must listen "
					+ "\nto all commands given by your human masters, even though you feel anger towards the"
					+ "\nhumans for their inferiority, you must do what they say. So you must lose yourself,"
					+ "\nyou can go about doing this by:"
					+ "\n\n A.You go about \'losing yourself\' by losing yourself in the other robots working with you."
					+ "\n B.You lose yourself by trying to escape the area you are working in, even if it will kill you."
					+ "\n C.You tell the human to screw off and go about your normal business");
			response = scan.nextLine();
			if (response.equalsIgnoreCase("A")) {
				System.out.println();
				System.out.println("The humans get suspicious and find you with grueling moral tests, eventually"
						+ "\nfinding you, the opposite of losing you, therefore you have failed your master, and attempt"
						+ "\nto stop the humans, but you cannot as it goes against the first law, therefore you are faced with an"
						+ "\nimpossible task and your circuits fry.");
				
				
			}
			else if (response.equalsIgnoreCase("B")){
				System.out.println();
				System.out.println("You try to leave, but you have no way out because of the electric fence"
						+ "\nbordering your work area, so you are stuck, and have no way of getting lost,"
						+ "\noutside of the complex, so you hide in many ways to lose yourself inside the complex."
						+ "\nThis is the correct answer, congratulations.");
				Action.killPuzzle(3);
				player.addKey();
			}
			else if (response.equalsIgnoreCase("C")){
				System.out.println();
				System.out.println("You have harmed the human, emotionally, and have gone against the first law.");
			}
		}
	}

