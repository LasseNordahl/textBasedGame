package textBasedGame;

public class Room extends Place{
	private static int roomNum = 0;
	boolean isLocked = true;
	private Puzzle puzzle;

	public Room(String name, String description, boolean lockStatus, int num) {
		super(name, description);
		isLocked = lockStatus;
		setRoom(num);
		// TODO Auto-generated constructor stub
	}
	
	public void addCommand(String s){
		possibleCommands.add(s);		
	}
	
	public void createPuzzle(int puzzleType){
		if (puzzleType == 1){
			puzzle = new Puzzle1();
		} else if (puzzleType == 2){
			puzzle = new Puzzle2();
		} else if (puzzleType == 3){
			puzzle = new Puzzle3();
		} else if (puzzleType == 4){
			//puzzle = new Puzzle4();
		} else if (puzzleType == 5){
			//puzzle = new Puzzle5();
		} else if (puzzleType == 6){
			//puzzle = 
		}
	}
	
	public Puzzle getPuzzle(){
		return puzzle;
	}
	
	public String getCommands(){
		String s = "";
		for (int i = 0; i < possibleCommands.size(); i++){
			s += "\n- " + possibleCommands.get(i);
		}
		return s;
	}
	public static void setRoom(int num){
		roomNum = num;
		
	}
	

}
