import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class VirtualPetShelter {

	Map<String, VirtualPet> reptiles = new HashMap<String, VirtualPet>();
	Random rand = new Random();

	public void petIntake(VirtualPet reptile) {
		reptiles.put(reptile.getName().toLowerCase(), reptile);
	}

	public Collection<VirtualPet> reptileInfo() {
		return reptiles.values();
	}

	public boolean selectPet(String name) {
		return reptiles.containsKey(name);
	}

	public void adoption(String name) {
		reptiles.remove(name.toLowerCase());
	}

	public void cleanCage(String name) {
		for (VirtualPet cleanCage : reptiles.values()) {
			if (cleanCage.getName().toLowerCase().equals(name)) {
				cleanCage.setCleanliness();
			}
		}
	}

	public void feedAll() {
		for (VirtualPet feedAll : reptiles.values()) {
			feedAll.feed();
		}
	}

	public void waterAll() {
		for (VirtualPet waterAll : reptiles.values()) {
			waterAll.water();
		}
	}

	public void tickAll(int selection) {
		for (VirtualPet tickAll : reptiles.values()) {
			tickAll.tick(selection);
		}
	}
}
