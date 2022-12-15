package cp213;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Stores a HashMap of MenuItem objects and the quantity of each MenuItem
 * ordered. Each MenuItem may appear only once in the HashMap.
 *
 * @author your name here
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2022-11-20
 */
public class Order implements Printable {

	/**
	 * The current tax rate on menu items.
	 */
	public static final BigDecimal TAX_RATE = new BigDecimal(0.13);

	// Attributes

	// your code here

	/**
	 * Increments the quantity of a particular MenuItem in an Order with a new
	 * quantity. If the MenuItem is not in the order, it is added.
	 *
	 * @param item     The MenuItem to purchase - the HashMap key.
	 * @param quantity The number of the MenuItem to purchase - the HashMap value.
	 */
	public void add(final MenuItem item, final int quantity) {

		Object items;
		// your code here
		if (items.containsKey(item)) {
			items.replace(item, items.get(item) + quantity);
		} else {
			item.putIfAbsent(item, quantity);
		}
	}

	/**
	 * Calculates the total value of all MenuItems and their quantities in the
	 * HashMap.
	 *
	 * @return the total price for the MenuItems ordered.
	 */
	public BigDecimal getSubTotal() {

		// your code here
		BigDecimal subTotal = new BigDecimal("0");
		for (Map.Entry<MenuItem, Integer> set : items.entrySet()) {
			subTotal = subTotal.add(set.getKey().getPrice().multiply(new BigDecimal(set.getValue().toString())));
		}
		return subTotal;
	}

	/**
	 * Calculates and returns the total taxes to apply to the subtotal of all
	 * MenuItems in the order. Tax rate is TAX_RATE.
	 *
	 * @return total taxes on all MenuItems
	 */
	public BigDecimal getTaxes() {

		// your code here
		BigDecimal Taxoz = new BigDecimal(String.format("%.4s", (this.getSubTotal().multiply(TAX_RATE)).toString()));
		return Taxoz;
	}

	/**
	 * Calculates and returns the total price of all MenuItems order, including tax.
	 *
	 * @return total price
	 */
	public BigDecimal getTotal() {

		// your code here
		BigDecimal subtotal = this.getSubTotal();
		BigDecimal Taxoz = this.getTaxes();
		BigDecimal Total = new BigDecimal(String.format("%.4s", (subtotal.add(Taxoz)).toString()));
		return Total;

	}

	/*
	 * Implements the Printable interface print method. Prints lines to a Graphics2D
	 * object using the drawString method. Prints the current contents of the Order.
	 */
	@Override
	public int print(final Graphics graphics, final PageFormat pageFormat, final int pageIndex)
			throws PrinterException {
		int result = PAGE_EXISTS;

		if (pageIndex == 0) {
			final Graphics2D g2d = (Graphics2D) graphics;
			g2d.setFont(new Font("MONOSPACED", Font.PLAIN, 12));
			g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
			// Now we perform our rendering
			final String[] lines = this.toString().split("\n");
			int y = 100;
			final int inc = 12;

			for (final String line : lines) {
				g2d.drawString(line, 100, y);
				y += inc;
			}
		} else {
			result = NO_SUCH_PAGE;
		}
		return result;
	}

	/**
	 * Returns a String version of a receipt for all the MenuItems in the order.
	 */
	@Override
	public String toString() {

		// your code here

		String Bill = "";
		for (Map.Entry<MenuItem, Integer> set : items.entrySet()) {
			Bill += String.format("%-15s", set.getKey().getName()) + String.format("%-2s", set.getValue()) + "@ $"
					+ String.format("%5.2f", set.getKey().getPrice().doubleValue()) + " = $"
					+ String.format("%6s",
							set.getKey().getPrice().multiply(new BigDecimal(set.getValue().toString())).toString())
					+ "\n";
		}
		Bill += String.format("%-28s", "Subtotal:") + "$" + String.format("%6.2f", this.getSubTotal().doubleValue())
				+ "\n";
		Bill += String.format("%-28s", "Taxes:") + "$" + String.format("%6.2f", this.getTaxes().doubleValue()) + "\n";
		Bill += String.format("%-28s", "Total:") + "$" + String.format("%6.2f", this.getTotal().doubleValue()) + "\n";
		return Bill;
	}

	/**
	 * Replaces the quantity of a particular MenuItem in an Order with a new
	 * quantity. If the MenuItem is not in the order, it is added. If quantity is 0
	 * or negative, the MenuItem is removed from the Order.
	 *
	 * @param item     The MenuItem to update
	 * @param quantity The quantity to apply to item
	 */
	public void update(final MenuItem item, final int quantity) {

		if (!items.containsKey(item)) {
			items.put(item, quantity);
		} else if (items.containsKey(item) & (quantity == 0 | quantity == -1)) {
			items.remove(item);
		} else {
			items.replace(item, quantity);
		}

	}
}