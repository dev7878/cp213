package cp213;

import java.time.LocalDate;

/**
 * Student class definition.
 *
 * @author Dev Patel, 212325400, pate5400@mylaurier.ca
 * @version 2022-10-05
 */
public class Student implements Comparable<Student> {

	// Attributes
	private LocalDate birthDate = null;
	private String forename = "";
	private int id = 0;
	private String surname = "";

	/**
	 * Instantiates a Student object.
	 *
	 * @param id        student ID number
	 * @param surname   student surname
	 * @param forename  name of forename
	 * @param birthDate birthDate in 'YYYY-MM-DD' format
	 */
	public Student(final int id, final String surname, final String forename, final LocalDate birthDate) {

		// assign attributes here
		this.id = id;
		this.surname = surname;
		this.forename = forename;
		this.birthDate = birthDate;

		return;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString() Creates a formatted string of student data.
	 */
	@Override
	public String toString() {
		String string = "";

		// your code here
		String line = "Name:      " + this.surname + ", " + this.forename + "\r\n" + "ID:        " + this.id + " \r\n"
				+ "Birthdate: " + this.birthDate;
		string = line;
		return string;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(final Student target) {
		int result = 0;

		// your code here
		int sur_Compare;
		int fore_Compare;
		int int_compare;
		sur_Compare = this.surname.compareTo(target.getSurname());
		fore_Compare = this.forename.compareTo(target.getForename());
		int_compare = Integer.compare(this.id, target.getId());
		result = sur_Compare;
		if (result == 0) {
			result += fore_Compare;
			if (result == 0) {
				result += int_compare;
			}
		}

		return result;

	}

	// getters and setters defined here
	public int getId() {
		return id;

	}

	public String getSurname() {
		return surname;

	}

	public String getForename() {
		return forename;

	}

	public LocalDate getBirthDate() {
		return birthDate;

	}

	public void setId(int new_id) {
		id = new_id;

	}

	public void setForename(String new_forename) {
		forename = new_forename;

	}

	public void setSurname(String new_surname) {
		surname = new_surname;

	}

	public void setBirthDate(LocalDate new_BD) {
		birthDate = new_BD;

	}

}
