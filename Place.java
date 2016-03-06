package textBasedGame;

import java.util.ArrayList;

public class Place extends NamedThing{
	boolean isLocked = true;
	protected boolean hasPuzzle = false;
	
	protected ArrayList<String> possibleCommands = new ArrayList<String>();
	

	public Place(String name, String description) {
		super(name, description);
		
		// TODO Auto-generated constructor stub
	}
	
	public void addCommand(String s){
		possibleCommands.add(s);		
	}
	
	public String getCommands(){
		String s = "";
		for (int i = 0; i < possibleCommands.size(); i++){
			s += "\n- " + possibleCommands.get(i);
		}
		return s;
	}
	
	public boolean hasFinalDoor(){
		return true;
	}

	public Puzzle getPuzzle() {
		// TODO Auto-generated method stub
		return null;
	}

	public void createPuzzle(int i) {
		// TODO Auto-generated method stub
		
	}

	
	

}
