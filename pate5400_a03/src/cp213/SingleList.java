package cp213;

/**
 * A single linked list structure of <code>Node T</code> objects. These data
 * objects must be Comparable - i.e. they must provide the compareTo method.
 * Only the <code>T</code> value contained in the priority queue is visible
 * through the standard priority queue methods. Extends the
 * <code>SingleLink</code> class.
 *
 * @author your name, id, email here
 * @version 2022-10-26
 * @param <T> this SingleList data type.
 */
public class SingleList<T extends Comparable<T>> extends SingleLink<T> {

	/**
	 * Searches for the first occurrence of key in this SingleList. Private helper
	 * methods - used only by other ADT methods.
	 *
	 * @param key The value to look for.
	 * @return A pointer to the node previous to the node containing key.
	 */
	private SingleNode<T> linearSearch(final T key) {

		// your code here
		SingleNode<T> current = null, prev = null;
		boolean found = false;
		current = this.front;
		while (!found && current != null) {
			if (current.getDatum().compareTo(key) == 0) {
				found = true;
				break;
			}
			prev = current;
			current = current.getNext();
		}
		if (!found) {
			prev = null;
		} else if (prev == null) {
			prev = current;

		}
		return prev;
	}

	/**
	 * Appends data to the end of this SingleList.
	 *
	 * @param datum The value to append.
	 */
	public void append(final T datum) {

		// your code here
		SingleNode<T> node = new SingleNode<T>(datum, null);
		if (this.front == null) {
			this.front = node;
			this.rear = node;
		} else {
			this.rear.setNext(node);
			this.rear = node;
		}
		this.length++;
		return;
	}

	/**
	 * Removes duplicates from this SingleList. The list contains one and only one
	 * of each value formerly present in this SingleList. The first occurrence of
	 * each value is preserved.
	 */
	public void clean() {

		// your code here
		SingleNode<T> current = this.front;
		SingleNode<T> pointer = null;
		while (current != null) {
			pointer = current;
			while (pointer.getDatum() != null) {
				if (current.getDatum().compareTo(pointer.getNext().getDatum()) == 0) {
					pointer.setNext(pointer.getNext().getNext());
				} else {
					pointer = pointer.getNext();
				}
			}
			current = current.getNext();
		}

		return;
	}

	/**
	 * Combines contents of two lists into a third. Values are alternated from the
	 * origin lists into this SingleList. The origin lists are empty when finished.
	 * NOTE: data must not be moved, only nodes.
	 *
	 * @param left  The first list to combine with this SingleList.
	 * @param right The second list to combine with this SingleList.
	 */
	public void combine(final SingleList<T> left, final SingleList<T> right) {

		// your code here
		while (right.front != null) {
			SingleNode<T> node = right.front;
			node.setNext(null);
			right.front = right.front.getNext();
			if (this.front == null) {
				this.front = node;
				this.rear = node;
			} else {
				this.rear.setNext(node);
				this.rear = node;
			}
		}

		return;
	}

	/**
	 * Determines if this SingleList contains key.
	 *
	 * @param key The key value to look for.
	 * @return true if key is in this SingleList, false otherwise.
	 */
	public boolean contains(final T key) {

		// your code here

		return (linearSearch(key) != null);
	}

	/**
	 * Finds the number of times key appears in list.
	 *
	 * @param key The value to look for.
	 * @return The number of times key appears in this SingleList.
	 */
	public int count(final T key) {

		// your code here
		int count = 0;
		SingleNode<T> current = this.front;
		while (current != null) {
			if (current.getDatum().compareTo(key) == 0) {
				if (current.getDatum().compareTo(key) == 0)
					count++;
				current = current.getNext();
			}
		}
		return count;
	}

	/**
	 * Finds and returns the value in list that matches key.
	 *
	 * @param key The value to search for.
	 * @return The value that matches key, null otherwise.
	 */
	public T find(final T key) {
		// your code here
		SingleNode<T> node = linearSearch(key);
		if (node == null) {
			return null;
		}

		return node.getNext().getDatum();
	}

	/**
	 * Get the nth item in this SingleList.
	 *
	 * @param n The index of the item to return.
	 * @return The nth item in this SingleList.
	 * @throws ArrayIndexOutOfBoundsException if n is not a valid index.
	 */
	public T get(final int n) throws ArrayIndexOutOfBoundsException {

		// your code here
		SingleNode<T> current = this.front;
		int i = 0;
		while (current != null && i < n) {
			current = current.getNext();
			i++;

		}

		return current.getDatum();
	}

	/**
	 * Determines whether two lists are identical.
	 *
	 * @param source The list to compare against this SingleList.
	 * @return true if this SingleList contains the same values in the same order as
	 *         source, false otherwise.
	 */
	public boolean identical(final SingleList<T> source) {

		// your code here
		boolean check = true;
		if (this.front == null) {
			if (source.front == null) {
				return check;
			} else {
				check = false;
				return check;
			}
		}
		SingleNode<T> current = this.front;
		SingleNode<T> current_source = source.front;
		while (current != null && check) {
			if (current.getDatum().compareTo(current_source.getDatum()) != 0) {
				check = false;
			}
			current = current.getNext();
			current_source = current_source.getNext();

		}

		return check;
	}

	/**
	 * Finds the first location of a value by key in this SingleList.
	 *
	 * @param key The value to search for.
	 * @return The index of key in this SingleList, -1 otherwise.
	 */
	public int index(final T key) {

		// your code here
		boolean found = false;
		int itr = 0;
		SingleNode<T> current = this.front;

		while (current != null && !found) {
			if (current.getDatum().compareTo(key) == 0)
				found = true;
			else {
				current = current.getNext();
				itr++;
			}
		}
		if (!found)
			return -1;

		return itr;
	}

	/**
	 * Inserts value into this SingleList at index i. If i greater than the length
	 * of this SingleList, append data to the end of this SingleList.
	 *
	 * @param i     The index to insert the new data at.
	 * @param datum The new value to insert into this SingleList.
	 */
	public void insert(int i, final T datum) {

		// your code here
		SingleNode<T> node = new SingleNode<T>(datum, null);
		if (this.front == null) {
			this.front = node;
			this.rear = node;
		} else {
			int index = 0;
			SingleNode<T> current = this.front;
			while (current != null && index < i - 1) {
				current = current.getNext();
				index++;
			}
			if (current == null) {
				this.rear.setNext(node);
				this.rear = node;
			} else {
				SingleNode<T> temp = current.getNext();
				current.setNext(node);
				node.setNext(temp);
			}
		}
		this.length++;
		return;
	}

	/**
	 * Creates an intersection of two other SingleLists into this SingleList. Copies
	 * data to this SingleList. left and right SingleLists are unchanged. Values
	 * from left are copied in order first, then values from right are copied in
	 * order.
	 *
	 * @param left  The first SingleList to create an intersection from.
	 * @param right The second SingleList to create an intersection from.
	 */
	public void intersection(final SingleList<T> left, final SingleList<T> right) {

		// your code here
		SingleNode<T> current = left.front;

		while (current != null) {
			T value = current.getDatum();
			SingleNode<T> node = right.linearSearch(value);

			if (node != null) {
				node = this.linearSearch(value);

				if (node == null) {
					this.append(value);
				}
			}
			current = current.getNext();
		}

		return;
	}

	/**
	 * Finds the maximum value in this SingleList.
	 *
	 * @return The maximum value.
	 */
	public T max() {

		// your code here
		if (this.front == null) {
			return null;
		}
		SingleNode<T> current = this.front;
		T maximum = current.getDatum();

		while (current != null) {
			if (maximum.compareTo(current.getDatum()) < 0)
				maximum = current.getDatum();
			current = current.getNext();
		}

		return maximum;
	}

	/**
	 * Finds the minimum value in this SingleList.
	 *
	 * @return The minimum value.
	 */
	public T min() {

		// your code here
		if (this.front == null) {
			return null;
		}
		SingleNode<T> current = this.front;
		T minimum = current.getDatum();

		while (current != null) {
			if (minimum.compareTo(current.getDatum()) > 0)
				minimum = current.getDatum();
			current = current.getNext();
		}

		return minimum;

	}

	/**
	 * Inserts value into the front of this SingleList.
	 *
	 * @param datum The value to insert into the front of this SingleList.
	 */
	public void prepend(final T datum) {

		// your code here
		SingleNode<T> node = new SingleNode<T>(datum, null);
		if (this.front == null) {
			this.front = node;
			this.rear = node;
		} else {
			node.setNext(this.front);
			this.front = node;
		}
		this.length++;
		return;
	}

	/**
	 * Finds, removes, and returns the value in this SingleList that matches key.
	 *
	 * @param key The value to search for.
	 * @return The value matching key, null otherwise.
	 */
	public T remove(final T key) {

		// your code here

		T value = null;
		SingleNode<T> current = this.front;
		if (current.getDatum().compareTo(key) == 0) {
			value = current.getDatum();
			this.front = this.front.getNext();
			this.length--;
			return value;
		}
		while (current.getNext() != null) {
			if (current.getNext().getDatum().compareTo(key) == 0) {
				if (current.getNext() == this.rear) {
					this.rear = current;
				}
				value = current.getNext().getDatum();
				current.setNext(current.getNext().getNext());
				break;
			} else {
				current = current.getNext();
			}
		}
		if (value != null)
			this.length--;
		return value;
	}

	/**
	 * Removes the value at the front of this SingleList.
	 *
	 * @return The value at the front of this SingleList.
	 */
	public T removeFront() {

		// your code here

		T value = null;
		if (this.front == null) {
			return null;
		}
		value = this.front.getDatum();
		this.front = this.front.getNext();
		this.length--;
		return value;
	}

	/**
	 * Finds and removes all values in this SingleList that match key.
	 *
	 * @param key The value to search for.
	 */
	public void removeMany(final T key) {

		// your code here
		while (this.front != null && this.front.getDatum().compareTo(key) == 0) {
			this.front = this.front.getNext();
			this.length--;
		}
		if (this.front == null) {
			this.rear = null;
			this.length = 0;
		}
		SingleNode<T> current = this.front;

		while (current != null && current.getNext() != null) {
			if (current.getNext().getDatum().compareTo(key) == 0) {
				this.length--;
				if (this.rear == current.getNext()) {
					this.rear = current;
				}
				current.setNext(current.getNext().getNext());
			} else {
				current = current.getNext();
			}
		}

		return;
	}

	/**
	 * Reverses the order of the values in this SingleList.
	 */
	public void reverse() {

		// your code here
		this.rear = this.front;
		SingleNode<T> current = this.front;
		SingleNode<T> prev = null;

		while (current != null) {
			SingleNode<T> temp = current.getNext();
			current.setNext(prev);
			prev = current;
			current = temp;
		}
		this.front = prev;

		return;
	}

	/**
	 * Splits the contents of this SingleList into the left and right SingleLists.
	 * Moves nodes only - does not move value or call the high-level methods insert
	 * or remove. this SingleList is empty when done. The first half of this
	 * SingleList is moved to left, and the last half of this SingleList is moved to
	 * right. If the resulting lengths are not the same, left should have one more
	 * item than right. Order is preserved.
	 *
	 * @param left  The first SingleList to move nodes to.
	 * @param right The second SingleList to move nodes to.
	 */
	public void split(final SingleList<T> left, final SingleList<T> right) {

		// your code here
		int count = 0, i = 0;
		SingleNode<T> current = this.front;

		while (current != null) {
			current = current.getNext();
			count++;
		}
		current = this.front;
		if (count == 1) {
			left.front = current;
			left.rear = current;
		}

		for (i = 0; i <= (count / 2); i++) {
			SingleNode<T> temp = current;
			current = current.getNext();
			temp.setNext(null);
			if (left.front == null) {
				left.front = temp;
				left.rear = temp;
			} else {
				left.rear.setNext(temp);
				left.rear = temp;
			}
		}

		while (current != null) {
			SingleNode<T> temp = current;
			current = current.getNext();
			temp.setNext(null);
			if (right.front == null) {
				right.front = temp;
				right.rear = temp;
			} else {
				right.rear.setNext(temp);
				right.rear = temp;
			}
		}

		return;
	}

	/**
	 * Splits the contents of this SingleList into the left and right SingleLists.
	 * Moves nodes only - does not move value or call the high-level methods insert
	 * or remove. this SingleList is empty when done. Nodes are moved alternately
	 * from this SingleList to left and right. Order is preserved.
	 *
	 * @param left  The first SingleList to move nodes to.
	 * @param right The second SingleList to move nodes to.
	 */
	public void splitAlternate(final SingleList<T> left, final SingleList<T> right) {

		// your code here

		boolean even = true;
		SingleNode<T> current = this.front;

		while (current != null) {
			SingleNode<T> temp = current;
			current = current.getNext();
			temp.setNext(null);
			if (even) {
				if (left.front == null) {
					left.front = temp;
					left.rear = temp;
				} else {
					left.rear.setNext(temp);
					left.rear = temp;
				}
			} else {
				if (right.front == null) {
					right.front = temp;
					right.rear = temp;
				} else {
					right.rear.setNext(temp);
					right.rear = temp;
				}
			}
			even = !even;
		}

		return;
	}

	/**
	 * Creates a union of two other SingleLists into this SingleList. Copies value
	 * to this list. left and right SingleLists are unchanged. Values from left are
	 * copied in order first, then values from right are copied in order.
	 *
	 * @param left  The first SingleList to create a union from.
	 * @param right The second SingleList to create a union from.
	 */
	public void union(final SingleList<T> left, final SingleList<T> right) {

		// your code here
		SingleNode<T> current1 = left.front;

		while (current1 != null) {
			T value = current1.getDatum();
			SingleNode<T> node = this.linearSearch(value);

			if (node == null) {
				this.append(value);
			}
			current1 = current1.getNext();
		}
		current1 = right.front;
		while (current1 != null) {
			T value = current1.getDatum();
			SingleNode<T> node = this.linearSearch(value);

			if (node == null) {
				this.append(value);
			}
			current1 = current1.getNext();
		}

		return;
	}
}
