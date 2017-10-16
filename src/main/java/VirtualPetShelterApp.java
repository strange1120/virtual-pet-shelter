import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPetShelter reptileHouse = new VirtualPetShelter();

		reptileHouse.petIntake(
				new VirtualPet("Sally", "Stuck in the 1950's. Wears a pink poodle skirt.", "Snake", 35, 31, 13));
		reptileHouse.petIntake(new VirtualPet("Diablo", "From hell. An actual demon.", "Scorpion", 39, 28, 6));
		reptileHouse.petIntake(new VirtualPet("Craig", "Unbearably happy all the time.", "Gecko", 34, 23, 12));
		reptileHouse
				.petIntake(new VirtualPet("Aragog", "Has hundreds of kids. Needs a vasectomy.", "Spider", 34, 38, 10));

		System.out.println("Welcome to Haus of Strange Reptile Rehab Center!");
		reptileInfo(reptileHouse);
		menu();
		int selection = input.nextInt();
		while (selection < 1 || selection > 7) {
			System.out.println("You have entered an invalid choice.");
			reptileInfo(reptileHouse);
			menu();
			selection = input.nextInt();
		}
		while (selection >= 1 && selection <= 7) {
			if (selection == 1) {
				System.out.println("You have fed the reptiles");
				reptileHouse.feedAll();
			}

			if (selection == 2) {
				System.out.println("You have given all the reptiles water");
				reptileHouse.waterAll();
			}
			if (selection == 3) {
				System.out.println("You want to handle one of the reptiles." + "Please choose one.");
				descriptionStats(reptileHouse);
				String name = nameMatch(input, reptileHouse);
				System.out.println(
						"You have handled " + name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase());
				reptileHouse.reptiles.get(name).play();
			}
			if (selection == 4) {
				System.out.println("You would like to adopt a reptile.");
				descriptionStats(reptileHouse);
				System.out.println("Which reptile would you like to adopt?");
				String name = nameMatch(input, reptileHouse);
				System.out.println(
						"You have adopted " + name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase());
				System.out.println(name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase()
						+ "is looking forward to their forever home!");
				reptileHouse.adoption(name);
			}
			if (selection == 5) {
				System.out.println("You would like to admit a reptile for rehab.\n"
						+ "I will need some information about this reptile.");
				System.out.println("What kind of reptile is this?");
				String type = input.next();
				System.out.println("What is it's name?");
				String name = input.next();
				System.out.println("How would you describe " + name.substring(0, 1).toUpperCase()
						+ name.substring(1).toLowerCase() + "?");
				input.nextLine();
				String description = input.nextLine();
				reptileHouse.petIntake(new VirtualPet(name, description, type));
			}
			if (selection == 6) {
				System.out.println("You want to clean one of the reptile's cages." + " Please choose one.");
				descriptionStats(reptileHouse);
				String name = nameMatch(input, reptileHouse);
				System.out.println("You have cleaned " + name.substring(0, 1).toUpperCase()
						+ name.substring(1).toLowerCase() + "'s cage.");
				reptileHouse.cleanCage(name);
			}
			if (selection == 7) {
				System.out.println("Thanks for stopping by and volunteering. The Strange reptiles appreciate it!");
				System.exit(0);
			}
			reptileHouse.tickAll(selection);
			reptileInfo(reptileHouse);
			menu();
			selection = input.nextInt();
		}
	}

	public static void descriptionStats(VirtualPetShelter reptileHouse) {
		for (VirtualPet current : reptileHouse.reptileInfo()) {
			System.out.println(current.getName() + " (" + current.getType() + ") - " + current.getDescription());
		}
	}

	public static void reptileInfo(VirtualPetShelter reptileHouse) {
		System.out.println("This is the current status of the reptiles: \n"
				+ "Name\t|Hunger\t|Thirst\t|Boredom|Cleanliness\n" + "--------|-------|-------|-------|-----------");
		for (VirtualPet current : reptileHouse.reptileInfo()) {
			System.out.println(current.getName() + "\t|" + current.getHunger() + "\t|" + current.getThirst() + "\t|"
					+ current.getBoredom() + "\t|" + current.getCleanliness());
		}
	}

	public static void menu() {
		System.out.println("What would you like to do next? " + "\n1. Feed the reptiles"
				+ "\n2. Refill water for the reptiles" + "\n3. Handle a reptile" + "\n4. Adopt a reptile"
				+ "\n5. Admit a reptile" + "\n6. Clean a reptile's cage." + "\n7. Quit");
	}

	public static String nameMatch(Scanner input, VirtualPetShelter reptileHouse) {
		String name = input.next().toLowerCase();
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
