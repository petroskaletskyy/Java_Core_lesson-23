package ua.lviv.lgs.task001;

import java.util.Scanner;
import java.util.function.Supplier;

import ua.lviv.lgs.task001.Human;

public class Deputy extends Human {

	public String surname;
	public String name;
	public int age;
	public boolean bribeTaker;
	public int bribeSize;

	public Deputy(int weight, int height) {
		super(weight, height);
	}

	public Deputy(String surname, String name) {
		this.surname = surname;
		this.name = name;
	}

	public Deputy(int weight, int height, String surname, String name, int age, boolean bribeTaker) {
		super(weight, height);
		this.surname = surname;
		this.name = name;
		this.age = age;
		this.bribeTaker = bribeTaker;
	}

	public Deputy(int weight, int height, String surname, String name, int age, boolean bribeTaker, int bribeSize) {
		super(weight, height);
		this.surname = surname;
		this.name = name;
		this.age = age;
		this.bribeTaker = bribeTaker;
		this.bribeSize = bribeSize;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBribeTaker() {
		return bribeTaker;
	}

	public void setBribeTaker(boolean bribeTaker) {
		this.bribeTaker = bribeTaker;
	}

	public int getBribeSize() {
		return bribeSize;
	}

	public void setBribeSize(int bribeSize) {
		this.bribeSize = bribeSize;
	}

	@Override
	public String toString() {
		return "Прізвище депутата= " + surname + ", імя= " + name + ", вік= " + age + "р., бере хабарі= " + bribeTaker
				+ ", розмір хабаря= " + getBribeSize() + "]";
	}

	Supplier<Integer> getBriebSum = () -> {
		Scanner scan = new Scanner(System.in);
		int sumBrieb = scan.nextInt();
		return sumBrieb;
	};

	/**
	 * @param int sumBribe
	 * @return void
	 */
	public void takeBribe() {
		if (this.bribeTaker == false) {
			System.out.println("Цей депутат не бере хабарів");
		} else {
			System.out.println("Ведіть суму хабаря");
			int sumBribe = getBriebSum.get();
			if (sumBribe > 5000) {
				System.out.println("Поліція увязнить депутата");
			} else {
				this.bribeSize = sumBribe;
			}
		}
	}

}
