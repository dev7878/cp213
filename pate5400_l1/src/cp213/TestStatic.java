package cp213;

public class TestStatic {
	int num1 = 6;
	static int num2 = 10;

	public static void main(String args[]) {
		TestStatic s1 = new TestStatic();
		TestStatic s2 = new TestStatic();
		s1.num1 = 15;
		s1.num2 = 17;
		s2.num1 = 22;
		s2.num2 = 28;
		System.out.println(s1.num1 + " " + s1.num2 + " " + s2.num1 + " " + s2.num2);
	}

}
