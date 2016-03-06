package textBasedGame;

public class Map extends Item{

	public Map(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}
	
	public static void printMap(Locations world, Player player){
		String s = "";
		s+= "\n     _   \n";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++){
				if (world.getRow()== i && world.getColumn()==j){
					s+= "[X] ";
				} else {
					s+= "[ ] ";
				}
			}
			s+="\n";
		}
		System.out.println(s);
	}
}
