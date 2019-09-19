package ua.lviv.lgs.task002;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public class Application {

	public static void main(String[] args) {

		Set<Student> setofStudents = new HashSet<>();
		Consumer<Student> addStudent = student -> setofStudents.add(student);
		addStudent.accept(new Student("Oliver", 21));
		addStudent.accept(new Student("Jack", 22));
		addStudent.accept(new Student("Harry", 26));
		addStudent.accept(new Student("Jacob", 28));
		addStudent.accept(new Student("Charlie", 21));
		addStudent.accept(new Student("Thomas", 23));
		addStudent.accept(new Student("George", 24));
		addStudent.accept(new Student("Oscar", 25));
		addStudent.accept(new Student("James", 21));
		addStudent.accept(new Student("William", 25));
		addStudent.accept(new Student("George", 24));
		addStudent.accept(new Student("Oscar", 25));
		addStudent.accept(new Student("James", 21));
		addStudent.accept(new Student("William", 25));

		setofStudents.forEach(System.out::println);
		System.out.println();
		System.out.println("/****************************************/");
		System.out.println();

		Set<Student> sortedStudents = new TreeSet<>();
		sortedStudents.addAll(setofStudents);
		sortedStudents.stream().sorted(new AllFieldsComparator()).forEach(System.out::println);;

	}

}

