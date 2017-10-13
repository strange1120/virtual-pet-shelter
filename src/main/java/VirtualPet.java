import java.util.Random;

public class VirtualPet {

	Random rand = new Random();

	private int hunger;
	private int thirst;
	private int boredom;
	private String name;
	private String description;
	private String type;

	public VirtualPet(String name, String type, String description) {
		this.name = name;
		this.description = description;
		this.type = type;
		this.thirst = 35;
		this.hunger = 35;
		this.boredom = 15;
	}

	public VirtualPet(String name, String description, String type, int hunger, int thirst, int boredom) {
		this.name = name;
		this.description = description;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void tick(int selection) {
		int amount2 = rand.nextInt(3) + 1;
		if (selection == 1) {
			thirst -= amount2;
			boredom = amount2;
		}
		if (selection == 2) {
			hunger -= amount2;
			boredom += amount2;
		}
		if (selection >= 3 && selection <= 5) {
			hunger -= amount2;
			boredom += amount2;
			thirst -= amount2;
		}
	}

	public void play() {
		boredom -= 5;
		hunger -= 5;
		thirst -= 5;
	}
}
