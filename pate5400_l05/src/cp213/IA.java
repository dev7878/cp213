package cp213;

/**
 * Inherited class in simple example of inheritance / polymorphism.
 *
 * @author David Brown
 * @version 2022-02-25
 */
public class IA extends Student {
	// your code here
	/**
	 * IA constructor
	 *
	 * @param lastName  Student last name (surname): defined in Person
	 * @param firstName Student first name (given name): defined in Person
	 * @param id        Student id number
	 * @param course    Student Course name
	 */
	protected String course = null;

	public IA(final String lastName, final String firstName, final String id, final String course) {
		super(lastName, firstName, id);
		this.course = course;
	}

	public String getCourse() {
		return this.course;
	}

	@Override
	public String toString() {
		return (super.toString() + "\n" + "Course: " + this.course);
	}

}
