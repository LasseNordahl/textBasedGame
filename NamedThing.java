package textBasedGame;

public class NamedThing {
	
	private String name;
	private String description;
	
	public NamedThing(String name, String description) {
		this.name = name;
		this.setDescription(description);
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		//return "Name: " + name + " Description: " + description;
		/*
		if (description.equals("Hallway")){
			return "You're in a " + description;
		} else {
			return "You're in " + description;
		}
		*/
		
		return name + getDescription();
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
