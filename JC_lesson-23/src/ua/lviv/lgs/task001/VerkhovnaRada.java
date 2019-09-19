package ua.lviv.lgs.task001;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class VerkhovnaRada {

	Faction faction;
	ArrayList<Faction> factions = new ArrayList<Faction>();

	Supplier<Faction> getFaction = () -> {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введіть назву фракції:");
		String newFaction = scanner.nextLine();
		return new Faction(newFaction);
	};

	public Optional<Faction> findFaction() {
		Faction factionType = getFaction.get();
		Predicate<Faction> isPredicateFaction = f -> f.getName().equalsIgnoreCase(factionType.getName());
		Optional<Faction> factionFound = factions.stream().filter(isPredicateFaction).findFirst();
		return factionFound;
	}

// 1 - Add new faction	
	public void addFaction() {
		Faction faction = getFaction.get();
		boolean isCreated = false;

		isCreated = factions.stream().anyMatch(f -> f.getName().equalsIgnoreCase(faction.getName()));

		if (!isCreated) {
			factions.add(faction);
			System.out.println("Фракція успішно додана");
		} else {
			System.out.println("Така фракція вже існує");
		}

	}

// 2 - Delete faction
	public void deleteFaction() {
		Optional<Faction> factionToDelete = findFaction();

		if (factionToDelete.isPresent()) {
			factions.remove(factionToDelete.get());
			System.out.println("Фракція " + factionToDelete.get().toString() + " успішно видалена");
		} else {
			System.out.println("Шкода, та такої фракції немає");
		}
	}

//3 - Print all faction
	public void printAllFaction() {
		factions.forEach(System.out::println);
	}

//5 - Print entered faction
	public void printEnteredFaction() {
		Optional<Faction> enteredFaction = findFaction();

		if (enteredFaction.isPresent()) {
			System.out.println(enteredFaction.get().toString());
			enteredFaction.get().printAllDeputy();
		} else {
			System.out.println("Шкода, та такої фракції немає");
		}
	}

//5 - Clean entered faction
	public void deleteAllDeputyFromFaction() {
		Optional<Faction> enteredFaction = findFaction();

		if (enteredFaction.isPresent()) {
			enteredFaction.get().deleteAllDeputy();
		} else {
			System.out.println("Шкода, та такої фракції немає");
		}
	}

//6 - Add deputy to entered faction
	public void addDeputyToFaction() {
		Optional<Faction> enteredFaction = findFaction();

		if (enteredFaction.isPresent()) {
			enteredFaction.get().addDeputy();
		} else {
			System.out.println("Шкода, та такої фракції немає");
		}
	}

//7 - Delete deputy
	public void deleteDeputyFromFaction() {
		Optional<Faction> enteredFaction = findFaction();

		if (enteredFaction.isPresent()) {
			enteredFaction.get().deleteDeputy();
		} else {
			System.out.println("Шкода, та такої фракції немає");
		}
	}

//8 - Print all bribe taker in faction
	public void printAllBriberInFaction() {
		Optional<Faction> enteredFaction = findFaction();

		if (enteredFaction.isPresent()) {
			enteredFaction.get().printAllBriber();
		} else {
			System.out.println("Шкода, та такої фракції немає");
		}
	}

//9 - Print main bribe taker in faction
	public void printMainBriberInFaction() {
		Optional<Faction> enteredFaction = findFaction();

		if (enteredFaction.isPresent()) {
			enteredFaction.get().printMostBriberTaker();
		} else {
			System.out.println("Шкода, та такої фракції немає");
		}
	}

//6 - Print all deputy in faction	
	public void printAllDeputyInFaction() {
		Optional<Faction> enteredFaction = findFaction();

		if (enteredFaction.isPresent()) {
			enteredFaction.get().printAllDeputy();
		} else {
			System.out.println("Шкода, та такої фракції немає");
		}
	}

	@Override
	public String toString() {
		return "Верховна Рада= " + faction + "]";
	}

}
