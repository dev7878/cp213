package cp213;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * Stores a List of MenuItems and provides a method return these items in a
 * formatted String. May be constructed from an existing List or from a file
 * with lines in the format:
 *
 * <pre>
1.25 hot dog
10.00 pizza
...
 * </pre>
 * 
 * @author your name here
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2022-11-20
 */
public class Menu {

	// Attributes.

	// your code here

	/**
	 * Creates a new Menu from an existing Collection of MenuItems. MenuItems are
	 * copied into the Menu List.
	 *
	 * @param items an existing Collection of MenuItems.
	 */
	public Menu(Collection<MenuItem> items) {

		// your code here

	}

	private List<MenuItem> items = new ArrayList<MenuItem>();

	/**
	 * Constructor from a Scanner of MenuItem strings. Each line in the Scanner
	 * corresponds to a MenuItem. You have to read the Scanner line by line and add
	 * each MenuItem to the List of items.
	 *
	 * @param fileScanner A Scanner accessing MenuItem String data.
	 */
	public Menu(Scanner fileScanner) {

		// your code here
		Scanner sc = new Scanner(System.in);
	}

	/**
	 * Returns the List's i-th MenuItem.
	 *
	 * @param i Index of a MenuItem.
	 * @return the MenuItem at index i
	 */
	public MenuItem getItem(int i) {

		// your code here
		MenuItem item = this.getItem(i);
		return item;
	}

	/**
	 * Returns the number of MenuItems in the items List.
	 *
	 * @return Size of the items List.
	 */
	public int size() {

		// your code here
		return items.size();

	}

	/**
	 * Returns the Menu items as a String in the format:
	 *
	 * <pre>
	5) poutine      $ 3.75
	6) pizza        $10.00
	 * </pre>
	 *
	 * where n) is the index + 1 of the MenuItems in the List.
	 */
	@Override
	public String toString() {

		// your code here
		String menuString = "";
		if (items.size() > 0) {
			int count = 1;
			menuString = String.format("%2s", count) + ") " + this.items.get(0).toString();
			if (items.size() > 1) {
				count++;
				for (int i = 1; i < items.size(); i++) {
					menuString += "/n" + String.format("%2s", count) + ") " + items.get(i).toString();
					count++;

				}
			}

		}
		return menuString;
	}
}