package ua.lviv.lgs.task001;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Faction {

	Deputy deputy;
	private String name;

	ArrayList<Deputy> deputies = new ArrayList<Deputy>();

	Supplier<Deputy> createDeputy = () -> {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введіть вагу депутата:");
		int weight = scanner.nextInt();
		System.out.println("Введіть його ріст:");
		int height = scanner.nextInt();
		System.out.println("Введіть прізвище депутата:");
		String surname = scanner.next();
		System.out.println("Введіть імя депутата:");
		String name = scanner.next();
		System.out.println("Введіть його вік:");
		int age = scanner.nextInt();
		System.out.println("Чи є цей депутат хабарником (true/false)?");
		boolean bribeTaker = scanner.nextBoolean();
		return new Deputy(weight, height, surname, name, age, bribeTaker);
	};

	Supplier<Deputy> getDeputy = () -> {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введіть прізвище депутата:");
		String deputySurName = scanner.nextLine();
		System.out.println("Введіть імя депутата:");
		String deputyName = scanner.nextLine();
		return new Deputy(deputySurName, deputyName);
	};

// 1 - Add new deputy
	public void addDeputy() {
		Deputy deputy = createDeputy.get();
		
		if (deputy.isBribeTaker()) {
			deputy.takeBribe();
		} 
		deputies.add(deputy);
		System.out.println("Депутат успішно доданий до фракції");
	}

// 2 - Delete deputy
	public void deleteDeputy() {
		Deputy deputyToDelete = getDeputy.get();

		Predicate<Deputy> isPredicate = dep -> (dep.getSurname().equalsIgnoreCase(deputyToDelete.getSurname())
				&& (dep.getName().equalsIgnoreCase(deputyToDelete.getName())));
		Optional<Deputy> findDeputy = deputies.stream().filter(isPredicate).findFirst();

		if (findDeputy.isPresent()) {
			deputies.remove(findDeputy.get());
			System.out.println("Депутат " + findDeputy.get().getSurname().toString() + " " + findDeputy.get().getName().toString() + " видалений з фракції");
		} else {
			System.out.println("Шкода, та в нашій фракції такого депутата немає");
		}
	}

// 3 - Print all briber
	public void printAllBriber() {
		List<Deputy> allBriber = deputies.stream().filter(Deputy::isBribeTaker).collect(Collectors.toList());
		allBriber.forEach(System.out::println);
	}

//	4 - Print most briber taker
	public void printMostBriberTaker() {
		Comparator<Deputy> deputyBribeSizeComparator = (deputy1,
				deputy2) -> (deputy1.getBribeSize() > deputy2.getBribeSize() ? 1
						: (deputy1.getBribeSize() == deputy2.getBribeSize()) ? 0 : -1);
		Optional<Deputy> mostBriberTaker = deputies.stream().filter(Deputy::isBribeTaker)
				.max(deputyBribeSizeComparator);

		if (mostBriberTaker.isPresent()) {
			System.out.println("Найбільший хабарник - " + mostBriberTaker.get().toString());
		} else {
			System.out.println("Хабарників немає");
		}
	}

// 5 - Print all deputy	
	public void printAllDeputy() {
		deputies.forEach(System.out::println);
	}

// 6 - Delete all deputy	
	public void deleteAllDeputy() {
		deputies.clear();
		System.out.println("Всі депутати видалені з фракції!");
	}

	public Faction(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Фракція= " + name + "]";
	}

	public String toStringAllDeputy() {
		return "Фракція= " + name + ": Депутати= " + deputies + "]";
	}

}
