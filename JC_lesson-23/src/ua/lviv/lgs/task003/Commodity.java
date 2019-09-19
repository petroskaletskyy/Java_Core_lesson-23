package ua.lviv.lgs.task003;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Commodity {

	private String name;
	private int length;
	private int width;
	private double weight;

	ArrayList<Commodity> list = new ArrayList<>();
	
	public Commodity() {
		
	}

	public Commodity(String name, int length, int width, double weight) {
		super();
		this.name = name;
		this.length = length;
		this.width = width;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Commodity [name=" + name + ", length=" + length + ", width=" + width + ", weight=" + weight + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + length;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + width;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commodity other = (Commodity) obj;
		if (length != other.length)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	Supplier<Commodity> getCommodity = () -> {
		System.out.println("Введіть назву товару:");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("Введіть довжину:");
		int length = sc.nextInt();
		System.out.println("Введіть ширину:");
		int width = sc.nextInt();
		System.out.println("Введіть вагу");
		double weight = sc.nextDouble();
		return new Commodity(name, length, width, weight);
	};

	public Optional<Commodity> findComodity() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введіть назву товару:");
		String findCommodity = sc.nextLine();

		Predicate<Commodity> isPredicate = commodity -> commodity.getName().equalsIgnoreCase(findCommodity);
		Optional<Commodity> comodityFound = list.stream().filter(isPredicate).findFirst();
		return comodityFound;
	}

	public void addCommodity() {
		Commodity commodity = getCommodity.get();
		list.add(commodity);
		System.out.println("Товар " + commodity.getName().toString() + " успішно доданий");
	}

	public void deleteCommodity() {
		Optional<Commodity> enteredCommodity = findComodity();

		if (enteredCommodity.isPresent()) {
			list.remove(enteredCommodity.get());
			System.out.println("Товар" + enteredCommodity.get().getName().toString() + "успішно видалено");
		} else {
			System.out.println("Шкода, та такого товару немає");
		}
	}

	public void changeCommodity() {
		Optional<Commodity> enteredCommodity = findComodity();
		
		if (enteredCommodity.isPresent()) {
			System.out.println("Введіть товар для заміни:");
			Commodity newCommodity = getCommodity.get();
			
			enteredCommodity.get().setName(newCommodity.getName());
			enteredCommodity.get().setLength(newCommodity.getLength());
			enteredCommodity.get().setWeight(newCommodity.getWeight());
			enteredCommodity.get().setWidth(newCommodity.getWidth());
			System.out.println("Товар " + enteredCommodity.get().getName() + " успішно замінений на " + newCommodity.getName());
		} else {
			System.out.println("Шкода, та такого товару немає");
		}
	}

	public void nameSorted() {
		System.out.println("До сортування:");
		list.forEach(System.out::println);
		System.out.println("Після сортування:");
		list.stream().sorted(Comparator.comparing(Commodity::getName)).forEach(System.out::println);
	}

	public void lenghtSorted() {
		System.out.println("До сортування:");
		list.forEach(System.out::println);
		System.out.println("Після сортування:");
		list.stream().sorted(Comparator.comparing(Commodity::getLength)).forEach(System.out::println);
	}

	public void widthSorted() {
		System.out.println("До сортування:");
		list.forEach(System.out::println);
		System.out.println("Після сортування:");
		list.stream().sorted(Comparator.comparing(Commodity::getWidth)).forEach(System.out::println);	}

	public void weightSorted() {
		System.out.println("До сортування:");
		list.forEach(System.out::println);
		System.out.println("Після сортування:");
		list.stream().sorted(Comparator.comparing(Commodity::getWeight)).forEach(System.out::println);
	}

	public void printEnteredCommodity() {
		System.out.println("Введіть порядковий номер товару:");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if ((list.size() < num - 1)||(num < 0)) {
			System.out.println("На жаль, такого порядкового номеру немає");
		} else {
			System.out.println(list.get(num));
		}
	}

	public void printList() {
		list.forEach(System.out::println);
	}

}
