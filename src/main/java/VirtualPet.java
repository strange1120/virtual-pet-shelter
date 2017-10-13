
public class VirtualPet {

	private int hunger;
	private int thirst;
	private int boredom;
	private String name;
	private String description;
	
	
	public VirtualPet (String name, String description) {
		this.name= name;
		this.description= description;
		this.thirst = 35;
		this.hunger = 35;
		this.boredom = 5;
	}
	
	public VirtualPet(String name, String description, int hunger, int thirst, int boredom) {
		this.name = name;
		this.description = description;
		this.thirst = thirst;
		this.hunger = hunger;
		this.boredom = boredom;
	}
	
	public int getHunger() {
		return hunger;
	}
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
	public int getThirst() {
		return thirst;
	}
	public void setThirst(int thirst) {
		this.thirst = thirst;
	}
	public int getBoredom() {
		return boredom;
	}
	public void setBoredom(int boredom) {
		this.boredom = boredom;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
