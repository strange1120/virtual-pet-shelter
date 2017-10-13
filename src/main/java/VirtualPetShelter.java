import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class VirtualPetShelter {

	Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();
	Random rand = new Random();

	public void petIntake(String name, VirtualPet pet) {
		pets.put(name, pet);
	}

	public Collection<VirtualPet> stats() {
		return pets.values();
	}

	public boolean selectPet(String name) {
		return pets.containsKey(name);
	}

	public void adoption(String name) {
		pets.remove(name);
	}

	int amount1 = rand.nextInt(5) + 1;

	public void feed() {
		int newHunger = 0;
		int newThirst = 0;
		int newBoredom = 0;
		for (VirtualPet feed : pets.values()) {
			newHunger = feed.getHunger() + amount1;
			feed.setHunger(newHunger);
			newThirst = feed.getThirst() - amount1;
			feed.setThirst(newThirst);
			newBoredom = feed.getBoredom() + amount1;
			feed.setBoredom(newBoredom);
		}
	}

	public void waterAll() {
		int newThirst = 0;
		int newHunger = 0;
		int newBoredom = 0;
		for (VirtualPet water : pets.values()) {
			newThirst = water.getThirst() + amount1;
			water.setThirst(newThirst);
			newHunger = water.getHunger() - amount1;
			water.setHunger(newHunger);
			newBoredom = water.getBoredom() + amount1;
			water.setBoredom(newBoredom);
		}
	}
//	for (VirtualPet waterAll : pets.values()) {
//		w
	public void tickAll(int selection) {
		for (VirtualPet tickAll : pets.values()) {
			tickAll.tick(selection);
		}
	}
}

// public void tick(int selection) {
// int newThirst = 0;
// int newHunger = 0;
// int newBoredom = 0;
// if (selection == 1) {
// for (VirtualPet tick : pets.values()) {
// newThirst = tick.getThirst() - amount2;
// tick.setThirst(newThirst);
// newBoredom = tick.getBoredom() + amount2;
// tick.setBoredom(newBoredom);
// }
// }
// if (selection == 2) {
// for (VirtualPet tick : pets.values()) {
// newHunger = tick.getHunger() - amount2;
// tick.setHunger(newHunger);
// newBoredom = tick.getBoredom() + amount2;
// tick.setBoredom(newBoredom);
// }
// }
// if (selection >= 3 && selection <=5) {
// for (VirtualPet water : pets.values()) {
// newThirst = water.getThirst() - amount2;
// water.setThirst(newThirst);
// newHunger = water.getHunger() - amount2;
// water.setHunger(newHunger);
// newBoredom = water.getBoredom() + amount2;
// water.setBoredom(newBoredom);
// }
// }
