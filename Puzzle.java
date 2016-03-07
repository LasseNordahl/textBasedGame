package textBasedGame;
import java.util.Scanner;

public abstract class Puzzle {
	Scanner scan = new Scanner(System.in);

	public abstract void playGame(Locations world, Player player);
}
