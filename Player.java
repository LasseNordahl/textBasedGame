package textBasedGame;

import java.util.ArrayList;

public class Player extends Entity{
	
	ArrayList<Item> items = new ArrayList<Item>();
	private int keyCount = 0;
	

	public Player(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
		items.add(new Map("Map", "Map of facility"));
		
	}
	
	public void addItem(Item item) {
		items.add(item);
		
	}
	
	public void addKey() {
		items.add(new Item("key", "description"));
		keyCount++;
		
	}
	
	public int getKeyCount() {
		return keyCount;
	}
	
	public boolean checkForItem(String item){
		for ( int i = 0; i < items.size(); i++) {
			if (items.get(i).getName().equalsIgnoreCase(item)){
				return true;	
			}
		}
		return false;
	}
	
	

}
