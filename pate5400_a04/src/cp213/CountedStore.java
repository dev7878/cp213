package cp213;

/**
 * Stores a value and an occurrence count for that value. The value must be
 * Comparable so that it can be compared and sorted against other values of the
 * same type.
 *
 * @author David Brown
 * @version 2022-05-12
 */
public class CountedStore<T extends Comparable<T>> implements Comparable<CountedStore<T>> {

    // Attributes.
    private int count = 0; // datum count
    private T datum = null; // datum

    /**
     * Copy constructor.
     *
     * @param source Another CountedStore object.
     */
    public CountedStore(final CountedStore<T> source) {
	this.datum = source.datum;
	this.count = source.count;
    }

    /**
     * Constructor for key version of object. (datum count defaults to 0)
     *
     * @param datum The datum to be counted.
     */
    public CountedStore(final T datum) {
	this.datum = datum;
    }

    /**
     * Constructor.
     *
     * @param datum The datum to be counted.
     * @param count The datum count.
     */
    public CountedStore(final T datum, final int count) {
	this.datum = datum;
	this.count = count;
    }

    /**
     * Comparison method for datum values. Compares only the stored values, counts
     * are ignored. Returns:
     * <ul>
     * <li>0 if this equals target</li>
     * <li>&lt; 0 if this precedes target</li>
     * <li>&gt; 0 if this follows target</li>
     * </ul>
     *
     * @param target CountedStore object to compare against.
     * @return Comparison result.
     */
    @Override
    public int compareTo(CountedStore<T> target) {
	return this.datum.compareTo(target.datum);
    }

    /**
     * Decrements the datum count.
     */
    public void decrementCount() {
	this.count--;
    }

    /**
     * Returns this datum count.
     *
     * @return this datum count.
     */
    public int getCount() {
	return this.count;
    }

    /**
     * Returns this datum.
     *
     * @return this datum.
     */
    public T getDatum() {
	return this.datum;
    }

    /**
     * Increments the datum count.
     */
    public void incrementCount() {
	this.count++;
    }

    /**
     * Sets the datum count.
     *
     * @param count the new datum count.
     */
    public void setCount(final int count) {
	this.count = count;
	return;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return String.format("{%s: %d}", this.datum.toString(), this.count);
    }

}
