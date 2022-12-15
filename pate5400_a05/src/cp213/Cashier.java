
package cp213;

import java.util.Scanner;

/**
 * Wraps around an Order object to ask for MenuItems and quantities.
 *
 * @author your name here
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2022-11-20
 */
public class Cashier {

	// Attributes
	private Menu menu = null;

	/**
	 * Constructor.
	 *
	 * @param menu A Menu.
	 */
	public Cashier(Menu menu) {
		this.menu = menu;
	}

	/**
	 * Prints the menu.
	 */
	private void printCommands() {
		System.out.println("\nMenu:");
		System.out.println(menu.toString());
		System.out.println("Press 0 when done.");
		System.out.println("Press any other key to see the menu again.\n");
	}

	/**
	 * Asks for commands and quantities. Prints a receipt when all orders have been
	 * placed.
	 *
	 * @return the completed Order.
	 */
	public Order takeOrder() {
		System.out.println("Welcome to WLU Foodorama!");

		// your code here
		Order current = new Order();
		Scanner sc = new Scanner(System.in);
		String errorMsg = "Not a valid number";
		String menuStr = "\nMenu:\n" + this.menu.toString() + "\nPress 0 when done.\n"
				+ "Press any other key to see the menu again.\n";

		if (menu != null) {
			System.out.println("Welcome to WLU Foodorama!");
			System.out.println(menuStr);

			String userInput = "";

			while (!userInput.equals("0")) {

				System.out.print("Command: ");
				userInput = sc.nextLine();

				if (!userInput.equals("0")) {
					try {
						int inputAsInt = Integer.parseInt(userInput);

						if (inputAsInt > this.menu.size()) {
							System.out.println(menuStr);
						} else if (0 < inputAsInt & inputAsInt <= this.menu.size()) {
							System.out.print("How many do you want? ");
							String quantity = sc.nextLine();
							try {
								int quantityInt = Integer.parseInt(quantity);
								if (quantityInt > 0) {
									current.add(this.menu.getItem(inputAsInt - 1), quantityInt);
								} else {
									System.out.println(errorMsg);
								}
							} catch (NumberFormatException nfe) {
								System.out.println(errorMsg);
							}
						}
					} catch (NumberFormatException nfe) {
						System.out.println(errorMsg);
					}
				}
			}
			System.out.println("----------------------------------------");
			System.out.println("Receipt");
			System.out.println(current.toString());
		}
		return current;
	}

}