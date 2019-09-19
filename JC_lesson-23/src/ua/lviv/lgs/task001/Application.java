package ua.lviv.lgs.task001;

import java.util.Scanner;
import java.util.function.Supplier;

public class Application {

	public static void main(String[] args) {

		VerkhovnaRada vr = new VerkhovnaRada();

		Supplier<Integer> menu = () -> {
			System.out.println("-----------------------------------------------");
			System.out.println("Введіть 1 щоб додати фракція");
			System.out.println("Введіть 2 щоб видалити конкретну фракцію");
			System.out.println("Введіть 3 щоб вивести усі фракції");
			System.out.println("Введіть 4 щоб очистити конкретну фракцію");
			System.out.println("Введіть 5 щоб вивести конкретну фракцію");
			System.out.println("Введіть 6 щоб додати депутата в фракцію");
			System.out.println("Введіть 7 щоб видалити депутата з фракції");
			System.out.println("Введіть 8 щоб вивести список хабарників");
			System.out.println("Введіть 9 щоб вивести найбільшого хабарника");
			System.out.println("-----------------------------------------------");
			Scanner sc = new Scanner(System.in);
			int number = sc.nextInt();
			return number;
		};

		while (true) {

			switch (menu.get()) {
			case 1: {
				vr.addFaction();
				System.out.println();
				break;
			}
			case 2: {
				vr.deleteFaction();
				System.out.println();
				break;
			}
			case 3: {
				vr.printAllFaction();
				System.out.println();
				break;
			}
			case 4: {
				vr.deleteAllDeputyFromFaction();
				System.out.println();
				break;
			}
			case 5: {
				vr.printEnteredFaction();
				break;
			}
			case 6: {
				vr.addDeputyToFaction();
				break;
			}
			case 7: {
				vr.deleteDeputyFromFaction();
				break;
			}
			case 8: {
				vr.printAllBriberInFaction();
				break;
			}
			case 9: {
				vr.printMainBriberInFaction();
				break;
			}
			}
		}

	}

}
