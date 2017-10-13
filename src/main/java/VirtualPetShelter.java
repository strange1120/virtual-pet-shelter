import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();

	public void petIntake(String name, VirtualPet pet) {
		pets.put(name, pet);
	}

	public Collection<VirtualPet> stats() {
		return pets.values();
	}

	public boolean selectPet(String name) {
		return pets.containsKey(name);
	}

	public void petAdoption(String name) {
		pets.remove(name);
	}
	
	int amount = 5;
	public void feed() {
		int newHunger = 0;
		int newThirst = 0;
		for (VirtualPet feed : pets.values()) {
				newHunger = feed.getHunger() + amount;
				feed.setHunger(newHunger);
				newThirst = feed.getThirst() - amount;
				feed.setThirst(newThirst);
			}
		}
	
	public void water() {
		int newThirst = 0;
		for (VirtualPet water : pets.values()) {
				newThirst = water.getThirst() + amount;
				water.setThirst(newThirst);
			}
		}
	
	public void play() {
		int newBoredom = 0;
		int newHunger = 0;
		int newThirst = 0;
		for (VirtualPet play : pets.values()) {
				newBoredom = play.getBoredom() - amount;
				play.setBoredom(newBoredom);
				newHunger = play.getHunger() - amount;
				play.setHunger(newHunger);
				newThirst = play.getThirst() - amount;
				play.setThirst(newThirst);
			}
		}
}
	
