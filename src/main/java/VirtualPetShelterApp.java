import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPetShelter reptileHouse = new VirtualPetShelter();

		reptileHouse.petIntake("Sally",
				new VirtualPet("Sally", "Stuck in the 1950's. Wears a pink poodle skirt", "snake", 35, 31, 13));
		reptileHouse.petIntake("Diablo", new VirtualPet("Diablo", "Has a temper like a demon.", "scorpion", 39, 28, 6));
		reptileHouse.petIntake("Craig", new VirtualPet("Craig", "Unbearably happy all the time.", "gecko", 34, 23, 12));
		reptileHouse.petIntake("Aragog",
				new VirtualPet("Aragog", "Has hundreds of kids. Needs a vasectomy.", "spider", 34, 38, 10));

		System.out.println("Welcome House of Strange Reptile Rehab Center!");
		stats(reptileHouse);
		menu();
		int selection = input.nextInt();
		while (selection < 1 || selection > 6) {
			System.out.println("You have entered an invalid choice.");
			stats(reptileHouse);
			menu();
			selection = input.nextInt();
		}
		while (selection >= 1 && selection <= 6) {
			if (selection == 1) {
				System.out.println("You have fed the reptiles");
				reptileHouse.feed();
			}

			if (selection == 2) {
				System.out.println("You have given all the reptiles water");
				reptileHouse.waterAll();
			}
			if (selection == 3) {
				System.out.println("You want to handle one of the reptiles." + "Please choose one.");
				descriptionStats(reptileHouse);
				String name = nameMatch(input, reptileHouse);
				System.out.println("You have selected " + name);
				reptileHouse.pets.get(name).play();
			}
			if (selection == 4) {
				System.out.println("You would like to adopt a reptile.");
				descriptionStats(reptileHouse);
				System.out.println("Which reptile would you like to adopt?");
				String name = nameMatch(input, reptileHouse);
				System.out.println("You want to adopt " + name);
				reptileHouse.adoption(name);
			}
			if (selection == 5) {
				System.out.println("You would like to admit a reptile for rehab.\n"
						+ "I will need some information about this reptile.");
				System.out.println("What kind of reptile is this?");
				String type = input.next();
				System.out.println("What is it's name?");
				String name = input.next();
				System.out.println("How would you describe " + name + "?");
				String description = input.nextLine();
				input.nextLine();
				reptileHouse.petIntake(name, new VirtualPet(name, description, type));
			}
			if (selection == 6) {
				System.out.println("Thanks for stopping by and volunteering. The Strange reptiles appreciate it!");
				System.exit(0);
			}
			reptileHouse.tickAll(selection);
			stats(reptileHouse);
			menu();
			selection = input.nextInt();
		}
	}
	public static void descriptionStats(VirtualPetShelter reptileHouse) {
		for (VirtualPet current : reptileHouse.stats()) {
			System.out.println(current.getName() + " " + current.getType() + " " + current.getDescription());
		}
	}
	public static void stats(VirtualPetShelter reptileHouse) {
		System.out.println("This is the current status of the reptiles: \n" + "Name\t|Hunger\t|Thirst\t|Boredom\n"
				+ "--------|-------|-------|-------");
		for (VirtualPet current : reptileHouse.stats()) {
			System.out.println(current.getName() + "\t|" + current.getHunger() + "\t|" + current.getThirst() + "\t|"
					+ current.getBoredom());
		}
	}
	public static void menu() {
		System.out.println("What would you like to do next? " + "\n1. Feed the pets" + "\n2. Water the pets"
				+ "\n3. Play with a pet" + "\n4. Adopt a pet" + "\n5. Admit a pet" + "\n6. Quit");
	}
	public static String nameMatch(Scanner input, VirtualPetShelter reptileHouse) {
		String name = input.next();
		input.nextLine();
		while (!reptileHouse.selectPet(name)) {
			System.out.println("Sorry we don't have a reptile by that name.");
			descriptionStats(reptileHouse);
			System.out.println("Please choose one.");
			name = input.next();
			input.nextLine();
		}
		return name;
	}
}
