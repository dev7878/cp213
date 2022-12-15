package cp213;

/**
 * A single linked queue structure of <code>Node T</code> objects. Only the
 * <code>T</code> value contained in the queue is visible through the standard
 * queue methods. Extends the <code>SingleLink</code> class.
 *
 * @author your name, id, email here
 * @version 2022-10-26
 * @param <T> the SingleQueue data type.
 */
public class SingleQueue<T> extends SingleLink<T> {

	/**
	 * Combines the contents of the left and right SingleQueues into the current
	 * SingleQueue. Moves nodes only - does not refer to values in any way, or call
	 * the high-level methods insert or remove. left and right SingleQueues are
	 * empty when done. Nodes are moved alternately from left and right to this
	 * SingleQueue.
	 *
	 * You have two source queues named left and right. Move all nodes from these
	 * two queues to the current queue. It does not make a difference if the current
	 * queue is empty or not, just get nodes from the right and left queues and add
	 * them to the current queue. You may use any appropriate SingleLink helper
	 * methods available.
	 *
	 * Do not assume that both right and left queues are of the same length.
	 *
	 * @param left  The first SingleQueue to extract nodes from.
	 * @param right The second SingleQueue to extract nodes from.
	 */
	public void combine(final SingleQueue<T> left, final SingleQueue<T> right) {

		// your code here
		while (left.front != null && right.front != null) {
			SingleNode<T> node = left.front;
			left.front = left.front.getNext();
			left.movefronttorear(node, this);
			SingleNode<T> node_r = right.front;
			right.front = right.front.getNext();
			right.movefronttorear(node_r, this);
		}
		while (left.front != null) {
			SingleNode<T> node = left.front;
			left.front = left.front.getNext();
			left.movefronttorear(node, this);
		}
		while (right.front != null) {
			SingleNode<T> node_r = right.front;
			right.front = right.front.getNext();
			right.movefronttorear(node_r, this);
		}
		return;
	}

	/**
	 * Adds value to the rear of the queue. Increments the queue length.
	 *
	 * @param datum The value to added to the rear of the queue.
	 */
	public void insert(final T datum) {

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
	 * Returns the front value of the queue and removes that value from the queue.
	 * The next node in the queue becomes the new first node. Decrements the queue
	 * length.
	 *
	 * @return The value at the front of the queue.
	 */
	public T remove() {
		assert this.front != null;
		// your code here
		T value = this.front.getDatum();
		this.front = this.front.getNext();
		this.length--;

		return value;
	}

	private void movefronttorear(SingleNode<T> node, final SingleQueue<T> queue) {
		node.setNext(null);
		if (queue.front == null) {
			queue.front = node;
			queue.rear = node;
		} else {
			queue.rear.setNext(node);
			queue.rear = node;
		}
		queue.length++;
		this.length--;
		return;
	}

	/**
	 * Splits the contents of the current SingleQueue into the left and right
	 * SingleQueues. Moves nodes only - does not move value or call the high-level
	 * methods insert or remove. this SingleQueue is empty when done. Nodes are
	 * moved alternately from this SingleQueue to left and right. left and right may
	 * already contain values.
	 *
	 * This is the opposite of the combine method.
	 *
	 * @param left  The first SingleQueue to move nodes to.
	 * @param right The second SingleQueue to move nodes to.
	 */
	public void splitAlternate(final SingleQueue<T> left, final SingleQueue<T> right) {

		// your code here
		boolean change = true;
		while (this.front != null) {
			if (change) {
				SingleNode<T> node = this.front;
				this.front = this.front.getNext();
				this.movefronttorear(node, left);
			} else {
				SingleNode<T> node_r = this.front;
				this.front = this.front.getNext();
				this.movefronttorear(node_r, right);
			}
			change = !change;
		}
		this.front = null;
		this.rear = null;
		this.length = 0;
		return;
	}
}