package ua.lviv.lgs.task001;

import java.util.Scanner;
import java.util.function.Supplier;

public class Application {

	public static void main(String[] args) {

		VerkhovnaRada vr = new VerkhovnaRada();

		Supplier<Integer> menu = () -> {
			System.out.println("-----------------------------------------------");
			System.out.println("������ 1 ��� ������ �������");
			System.out.println("������ 2 ��� �������� ��������� �������");
			System.out.println("������ 3 ��� ������� �� �������");
			System.out.println("������ 4 ��� �������� ��������� �������");
			System.out.println("������ 5 ��� ������� ��������� �������");
			System.out.println("������ 6 ��� ������ �������� � �������");
			System.out.println("������ 7 ��� �������� �������� � �������");
			System.out.println("������ 8 ��� ������� ������ ���������");
			System.out.println("������ 9 ��� ������� ���������� ���������");
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
