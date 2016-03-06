package textBasedGame;

import java.util.ArrayList;

public class Entity extends NamedThing{
	
	private int strength;
	ArrayList<Item> items = new ArrayList<Item>();

	public Entity(String name, String description) {
		super(name, description);
		//this.strength = strength;
		// TODO Auto-generated constructor stub
	}
	
}
