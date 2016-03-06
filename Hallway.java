package textBasedGame;

public class Hallway extends Place{
	private boolean finalDoor = false;
	public Hallway(String name, String description) {
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
	



}