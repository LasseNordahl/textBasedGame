package textBasedGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Puzzle2 extends Puzzle{
	
	//5 booleans in an array
	boolean[] gameLights = {false, false, false, false, false};
	/*
	for (int i = 0; i < gameLights.length; i++){
		gameLights[i] = false;
	}
	*/
	
	Scanner scan = new Scanner(System.in);	
	
	public void playGame(Locations world, Player player){
		System.out.println();
		System.out.println("A light puzzle stands before you, you try to light them all up");
		int choice;
		
		boolean isGameBeat = false;
		
		printLights(isGameBeat);
		while (!checkAllLights()){
			choice = scan.nextInt();
			changeLights((choice - 1));
			if (checkAllLights()){
				isGameBeat = true;
			}
			printLights(isGameBeat);
			
		}
		System.out.println("You have beaten the puzzle, a key drops from the middle light");
		player.addKey();
		//world.moveRight();
	}
	
	public void changeLights(int c) {
	
		if (c > 0 && c < 4){
			if (gameLights[c]){
				gameLights[c] = false;
			} else {
				gameLights[c] = true;
			}
			if (gameLights[c-1]){
				gameLights[c-1] = false;
			} else {
				gameLights[c-1] = true;
			}
			
			if (gameLights[c+1]){
				gameLights[c+1] = false;
			} else {
				gameLights[c+1] = true;
			}
		}
		
		if (c == 0) {
			if (gameLights[c]){
				gameLights[c] = false;
			} else {
				gameLights[c] = true;
			}
			if (gameLights[c+1]){
				gameLights[c+1] = false;
			} else {
				gameLights[c+1] = true;
			}
		}
		if (c == 4) {
			if (gameLights[c]){
				gameLights[c] = false;
			} else {
				gameLights[c] = true;
			}
			if (gameLights[c-1]){
				gameLights[c-1] = false;
			} else {
				gameLights[c-1] = true;
			}
		}
		
	}
			
	public void printLights(boolean beat){
		String s = " 1   2   3   4   5 \n";
		
		for(boolean a: gameLights){
			
			if (a){
				s+="[X] ";
			} else {
				s+="[ ] ";
			} 
		}
		
		System.out.println(s);
		System.out.println();
		if (!beat) {
			System.out.print("Which cell do you choose? (1,2,3,4, or 5)  ");
		}
	}
	
	public boolean checkAllLights(){
		int count = 0;
		for (boolean a: gameLights){
			if (a){
				count++;
			} else {
				return false;
			}
		}
		if (count == 5){
			return true;
		}
		return false;
	}

}
