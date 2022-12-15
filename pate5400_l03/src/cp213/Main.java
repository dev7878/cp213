package cp213;

import java.time.LocalDate;

/**
 * Tests the Student class.
 *
 * @author Dev Patel, 212325400, pate5400@mylaurier.ca
 * @version 2022-10-05
 */
public class Main {

	public static void main(String[] args) {
		final String line = "-".repeat(40);
		int id = 123456;
		String surname = "Brown";
		String forename = "David";
		LocalDate birthDate = LocalDate.parse("1962-10-25");
		Student student = new Student(id, surname, forename, birthDate);
		System.out.println("New Student:");
		System.out.println(student);
		System.out.println(line);
		System.out.println("Test Getters");

		// call getters here
		System.out.println("Forename  : " + student.getForename());
		System.out.println("Surname   : " + student.getSurname());
		System.out.println("Id        : " + student.getId());
		System.out.println("BirthDate : " + student.getBirthDate());

		System.out.println(line);
		System.out.println("Test Setters");

		// call setters here
		student.setId(212325400);
		student.setForename("AB");
		student.setSurname("AAA");
		LocalDate new_birDate = LocalDate.parse("1990-11-01");
		student.setBirthDate(new_birDate);

		System.out.println("Updated Student:");
		System.out.println(student);
		System.out.println(line);
		System.out.println("Test compareTo");

		// create new Students - call comparisons here
		int id1 = 11111111;
		String surname1 = "AAA";
		String forename1 = "AB";
		LocalDate birthDate1 = LocalDate.parse("1972-01-20");
		Student student1 = new Student(id1, surname1, forename1, birthDate1);
		System.out.println("New Student:");
		System.out.println(student1);
		System.out.println(line);
		System.out.println(student1.compareTo(student));
	}

}
