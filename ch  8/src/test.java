
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner keybScanner = new Scanner(System.in);
		int n = keybScanner.nextInt();
		String s1 = keybScanner.nextLine();
		String s2 = keybScanner.nextLine();
		System.out.println(n);
		System.out.println(s1);
		System.out.println(s2);
		name();
	}

	public final static void name() {
		System.out.println("final test");
	}
}
