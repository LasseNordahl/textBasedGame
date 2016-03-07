package textBasedGame;

import java.util.Random;
import java.util.Scanner;

public class Puzzle1 extends Puzzle {

	// testing tic tac toe
	/*
	 * public static void main(String[] args) { Puzzle1 p = new Puzzle1();
	 * p.playGame((Player) null); }
	 */
	// Name-constants to represent the seeds and cell contents
	public static final int EMPTY = 0;
	public static final int PLAYER = 1; // human player
	public static final int COMPUTER = 2; // computer player

	// Name-constants to represent the various states of the game
	public static final int PLAYING = 0;
	public static final int DRAW = 1;
	public static final int HUMAN_WON = 2;
	public static final int COMPUTER_WON = 3;

	// The game board and the game status
	public static final int ROWS = 3, COLS = 3;
	public static int[][] board = new int[ROWS][COLS];

	public static int currentState;
	public static int currentPlayer;
	public static int currntRow, currentCol; // current seed's row and column

	public static Scanner in = new Scanner(System.in); // the input Scanner

	public void playGame(Locations world, Player player) {
		System.out.println();
		System.out.println("You walk into the room to see a computer sitting on a desk. 4 crossed lines "
				+ "\nform the shape of a tic tac toe board. Above the computer hangs a poster "
				+ "\nthat reads \"A robot is always able to solve a puzzle\".");
		// Initialize the game-board and current status
		initGame();
		System.out.println();
		printBoard();

		// play the game until the player or the computer wins

		do {
			//
			if (currentPlayer == PLAYER) {
				playerMove(currentPlayer);
			} else {
				computerMove(COMPUTER);
			}

			// updates the game state
			updateGame(currentPlayer, currntRow, currentCol);
			printBoard();

			// Print message if game-over
			if (currentState == HUMAN_WON) {
				System.out.println("You have beaten the computer. A key drops from the ceiling and you pick it up");
				player.addKey();
			} else if (currentState == COMPUTER_WON) {
				System.out.println("You have been beaten by the computer, the game will restart");
				initGame();
				printBoard();
			} else if (currentState == DRAW) {
				System.out.println("You have not beaten the computer, the game will restart");
				initGame();
				printBoard();
			}
			// Switch player
			currentPlayer = (currentPlayer == PLAYER) ? COMPUTER : PLAYER;
		} while (currentState == PLAYING); // repeat if not game-over

	}

	public void initGame() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				board[row][col] = EMPTY; // all cells empty
			}
		}
		currentState = PLAYING; // ready to play
		currentPlayer = PLAYER; // cross plays first
	}

	public void computerMove(int currentPlayer) {
		/*
		 * 
		 * if (row >= 0 && row < ROWS && col >= 0 && col < COLS &&
		 * board[row][col] == EMPTY) { currntRow = row; currentCol = col;
		 * board[currntRow][currentCol] = whichPlayer; // update game-board //
		 * content }
		 */
		boolean validInput = false; // for input validation
		do {
			Random r = new Random();
			int row = (int) r.nextInt(3);
			int col = (int) r.nextInt(3);

			System.out.println("The computer plays [ " + row + "] [ " + col + "]");

			// row = in.nextInt() - 1; // array index starts at 0 instead of 1
			// col = in.nextInt() - 1;
			/*
			 * if (whichPlayer == NOUGHT) { row = ((int)Math.random() 3) - 1; //
			 * array index starts at 0 instead of 1 col = ((int)Math.random() 3)
			 * - 1; }
			 */
			if (row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col] == EMPTY) {
				currntRow = row;
				currentCol = col;
				board[currntRow][currentCol] = currentPlayer; // update
				// game-board
				// content
				validInput = true; // input okay, exit loop
			} else {
				// System.out.println("This move at (" + (row + 1) + ","
				// + (col + 1) + ") is not valid. Try again...");
			}
		} while (!validInput); // repeat until input is valid
	}

	public void playerMove(int currentPlayer) {
		boolean validInput = false; // for input validation
		do {

			int row = 0;
			int col = 0;

			System.out.print("Player, enter your move (row[1-3] column[1-3]): ");

			row = in.nextInt() - 1; // array index starts at 0 instead of 1
			col = in.nextInt() - 1;
			/*
			 * if (whichPlayer == NOUGHT) { row = ((int)Math.random() 3) - 1; //
			 * array index starts at 0 instead of 1 col = ((int)Math.random() 3)
			 * - 1; }
			 */
			if (row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col] == EMPTY) {
				currntRow = row;
				currentCol = col;
				board[currntRow][currentCol] = currentPlayer; // update
				// game-board
				// content
				validInput = true; // input okay, exit loop
			} else {
				System.out.println("This move at (" + (row + 1) + "," + (col + 1) + ") is not valid. Try again...");
			}
		} while (!validInput); // repeat until input is valid
	}

	public void updateGame(int currentPlayer, int currentRow, int currentCol) {
		if (hasWon(currentPlayer, currentRow, currentCol)) { // check if winning
			// move
			currentState = (currentPlayer == PLAYER) ? HUMAN_WON : COMPUTER_WON;
		} else if (isDraw()) { // check for draw
			currentState = DRAW;
		}
		// Otherwise, no change to currentState (still PLAYING).
	}

	// TODO: Shall declare draw if no player can "possibly" win
	public boolean isDraw() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				if (board[row][col] == EMPTY) {
					return false; // an empty cell found, not draw, exit
				}
			}
		}
		return true; // no empty cell, it's a draw
	}

	public boolean hasWon(int currentPlayer, int currentRow, int currentCol) {
		return (board[currentRow][0] == currentPlayer // 3-in-the-row
				&& board[currentRow][1] == currentPlayer && board[currentRow][2] == currentPlayer
				|| board[0][currentCol] == currentPlayer // 3-in-the-column
						&& board[1][currentCol] == currentPlayer && board[2][currentCol] == currentPlayer
				|| currentRow == currentCol // 3-in-the-diagonal
						&& board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer
				|| currentRow + currentCol == 2 // 3-in-the-opposite-diagonal
						&& board[0][2] == currentPlayer && board[1][1] == currentPlayer
						&& board[2][0] == currentPlayer);
	}

	public void printBoard() {
		System.out.println();
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				printCell(board[row][col]); // print each of the cells
				if (col != COLS - 1) {
					System.out.print("|"); // print vertical partition
				}
			}
			System.out.println();
			if (row != ROWS - 1) {
				System.out.println("-----------"); // print horizontal partition
			}
		}
		System.out.println();
	}

	public void printCell(int content) {
		if (content == EMPTY) {
			System.out.print("   ");
		} else if (content == COMPUTER) {
			System.out.print(" O ");
		} else if (content == PLAYER) {
			System.out.print(" X ");
		}
	}

}