import java.util.Random;

public class VirtualPet {

	Random rand = new Random();

	private int hunger;
	private int thirst;
	private int boredom;
	private String name;
	private String description;
	private String type;
	private int cleanliness;

	public VirtualPet(String name, String description, String type) {
		this.name = name;
		this.description = description;
		this.type = type;
		this.thirst = 35;
		this.hunger = 35;
		this.boredom = 15;
		this.cleanliness = 40;
	}

	public VirtualPet(String name, String description, String type, int hunger, int thirst, int boredom) {
		this.name = name;
		this.description = description;
		this.type = type;
		this.thirst = thirst;
		this.hunger = hunger;
		this.boredom = boredom;
		this.cleanliness = 40;
	}

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public int getBoredom() {
		return boredom;
	}

	public String getName() {
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}

	public int getCleanliness() {
		return cleanliness;
	}

	public void setCleanliness() {
		this.cleanliness = 50;
	}

	public String getDescription() {
		return description.substring(0, 1).toUpperCase() + description.substring(1).toLowerCase();
	}

	public String getType() {
		return type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase();
	}

	private int createRandomFrom1ToInt(int max) {
		return rand.nextInt(max) + 1;
	}

	public void feed() {
		hunger += createRandomFrom1ToInt(5);
		thirst -= createRandomFrom1ToInt(5);
		cleanliness -= createRandomFrom1ToInt(5);
	}

	public void water() {
		hunger -= createRandomFrom1ToInt(5);
		thirst += createRandomFrom1ToInt(5);
		cleanliness -= createRandomFrom1ToInt(5);
	}

	public void tick(int selection) {
		if (selection == 1) {
			thirst -= createRandomFrom1ToInt(3);
			boredom += createRandomFrom1ToInt(3);
		}
		if (selection == 2) {
			hunger -= createRandomFrom1ToInt(3);
			boredom += createRandomFrom1ToInt(3);
		}
		if (selection >= 3 && selection <= 5) {
			hunger -= createRandomFrom1ToInt(3);
			boredom += createRandomFrom1ToInt(3);
			thirst -= createRandomFrom1ToInt(3);
		}
		if (hunger > 50) {
			hunger = 50;
		}
		if (thirst > 50) {
			thirst = 50;
		}
		if (boredom > 50) {
			boredom = 50;
		}
		if (cleanliness > 50) {
			cleanliness = 50;
		}
		if (hunger < 0) {
			hunger = 0;
		}
		if (boredom < 0) {
			boredom = 0;
		}
		if (thirst < 0) {
			thirst = 0;
		}
		if (cleanliness < 0) {
			cleanliness = 0;
		}
	}

	public void play() {
		boredom -= 5;
		hunger -= createRandomFrom1ToInt(5);
		thirst -= createRandomFrom1ToInt(5);

	}
}
