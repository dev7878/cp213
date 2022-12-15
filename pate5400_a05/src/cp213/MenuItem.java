package cp213;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Defines the name and price of a menu item. Price is stored as a BigDecimal to
 * avoid rounding errors.
 *
 * @author your name here
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2022-11-20
 */
public class MenuItem {

	// Attributes
	private static final String itemFormat = "%-12s $%5.2f";
	private String name = null;
	private BigDecimal price = null;

	/**
	 * Constructor. Must set price to 2 decimal points for calculations.
	 *
	 * @param name  Name of the menu item.
	 * @param price Price of the menu item.
	 */
	public MenuItem(final String name, final BigDecimal price) {

		// your code here

		this.name = name;
		this.price = price.setScale(2, RoundingMode.HALF_EVEN);

	}

	/**
	 * Alternate constructor. Converts a double price to BigDecimal.
	 *
	 * @param name  Name of the menu item.
	 * @param price Price of the menu item.
	 */
	public MenuItem(final String name, final double price) {

		// your code here
		this(name, new BigDecimal(price));

	}

	/**
	 * name getter
	 *
	 * @return Name of the menu item.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * price getter
	 *
	 * @return Price of the menu item.
	 */
	public BigDecimal getPrice() {
		return this.price;
	}

	/**
	 * Returns a MenuItem as a String in the format:
	 *
	 * <pre>
	hot dog      $ 1.25
	pizza        $10.00
	 * </pre>
	 */
	@Override
	public String toString() {

		// your code here
		String item = String.format("%-13s$,5.2f", getName(), getPrice());

		return item;
	}
}