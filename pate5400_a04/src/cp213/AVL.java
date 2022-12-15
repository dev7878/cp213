package cp213;

/**
 * Implements an AVL (Adelson-Velsky Landis) tree. Extends BST.
 *
 * @author your name here
 * @author David Brown
 * @version 2022-05-12
 */
public class AVL<T extends Comparable<T>> extends BST<T> {

	/**
	 * Returns the balance item of node. If greater than 1, then left heavy, if less
	 * than -1, then right heavy. If in the range -1 to 1 inclusive, the node is
	 * balanced. Used to determine whether to rotate a node upon insertion.
	 *
	 * @param node The TreeNode to analyze for balance.
	 * @return A balance number.
	 */
	private int balance(final TreeNode<T> node) {

		// your code here
		if (node == null || (node.getLeft() == null && node.getRight() == null)) {
			return 0;
		}
		if (node.getLeft() == null) {
			return 0 - node.getHeight();
		}
		if (node.getRight() == null) {
			return node.getHeight();
		}

		return node.getLeft().getHeight() - node.getRight().getHeight();
	}

	/**
	 * Performs a left rotation around node.
	 *
	 * @param node The subtree to rotate.
	 * @return The new root of the subtree.
	 */
	private TreeNode<T> rotateLeft(final TreeNode<T> node) {

		// your code here
		TreeNode<T> right_node = node.getRight();
		TreeNode<T> center_node = node.getLeft();
		right_node.setLeft(node);
		node.setRight(center_node);
		node.updateHeight();
		right_node.updateHeight();
		return right_node;
	}

	/**
	 * Performs a right rotation around node.
	 *
	 * @param node The subtree to rotate.
	 * @return The new root of the subtree.
	 */
	private TreeNode<T> rotateRight(final TreeNode<T> node) {

		// your code here
		TreeNode<T> Left_node = node.getLeft();
		TreeNode<T> center_node = node.getRight();
		Left_node.setRight(node);
		node.setLeft(center_node);
		node.updateHeight();
		Left_node.updateHeight();
		return Left_node;

	}

	/**
	 * Auxiliary method for insert. Inserts data into this AVL.
	 *
	 * @param node The current node (TreeNode).
	 * @param cs   Data to be inserted into the node.
	 * @return The inserted node.
	 */
	@Override
	protected TreeNode<T> insertAux(TreeNode<T> node, final CountedStore<T> cs) {

		// your code here
		if (node == null) {
			TreeNode<T> new_node = new TreeNode<T>(cs);
			this.size++;
			return new_node;
		} else if (cs.compareTo(node.getCs()) > 0) {
			node.setRight(insertAux(node.getRight(), cs));

		} else if (cs.compareTo(node.getCs()) < 0) {
			node.setLeft(insertAux(node.getLeft(), cs));
		}
		node.updateHeight();

		return rotatenode(node);
	}

	private TreeNode<T> rotatenode(TreeNode<T> node) {
		int balance = balance(node);
		// bal > 1 so right branch has more child
		if (balance > 1) {
			if (balance(node.getLeft()) < 0) {
				node.setLeft(rotateLeft(node.getLeft()));
			}
			return rotateRight(node);
		} else if (balance < -1) {
			if (balance(node.getRight()) > 0) {
				node.setRight(rotateRight(node.getRight()));
			}
			return rotateLeft(node);
		}
		return node;

	}

	/**
	 * Auxiliary method for valid. Determines if a subtree based on node is a valid
	 * subtree. An AVL must meet the BST validation conditions, and additionally be
	 * balanced in all its subtrees - i.e. the difference in height between any two
	 * children must be no greater than 1.
	 *
	 * @param node The root of the subtree to test for validity.
	 * @return true if the subtree base on node is valid, false otherwise.
	 */
	@Override
	protected boolean isValidAux(final TreeNode<T> node, TreeNode<T> minNode, TreeNode<T> maxNode) {

		// your code here
		if (node == null) {
			return true;
		} else if (minNode != null) {
			if (minNode.getCs().compareTo(node.getCs()) > 0) {
				return false;
			}
		} else if (maxNode != null) {
			if (maxNode.getCs().compareTo(node.getCs()) < 0) {
				return false;
			}
		}

		return isValidAux(node.getLeft(), minNode, node) && isValidAux(node.getRight(), node, maxNode);
	}

	/**
	 * Determines whether two AVLs are identical.
	 *
	 * @param target The AVL to compare this AVL against.
	 * @return true if this AVL and target contain nodes that match in position,
	 *         item, count, and height, false otherwise.
	 */
	public boolean equals(final AVL<T> target) {
		return super.equals(target);
	}

}
