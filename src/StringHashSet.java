import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * A hash set implementation for Strings. Cannot insert null into the set. Other
 * requirements are given with each method.
 *
 * @author Matt Boutell and <<TODO: your name here >>>. Created Oct 6, 2014.
 */
public class StringHashSet {

	// The initial size of the internal array.
	private static final int DEFAULT_CAPACITY = 5;

	private int size;
	private int capacity;
	private Node[] array;

	/**
	 * A LinkedList<String> designed for the StringHashSet program
	 */
	static class Node implements Iterable<String> {
		private String data;
		private Node next;

		Node() {
			this.data = null;
		}

		Node(String data) {
			this.data = data;
		}

		/**
		 * Add a new item to the LinkedList
		 * @param item The string to be added
		 * @return If the add was successful
		 */
		boolean add(String item) {
			if (this.data == null) this.data = item;
			else {
				Node node = new Node(this.data);
				node.next = this.next;
				this.next = node;
				this.data = item;
			}
			return true;
		}

		/**
		 * Remove an item from the LinkedList
		 * @param item The string to be removed
		 * @return If the remove was successful
		 */
		boolean remove(String item) {
			if (this.data.equals(item)) {
				this.data = this.next != null ? this.next.data : null;
				this.next = this.next != null ? this.next.next : null;
				return true;
			} else if (this.next != null) {
				if (this.next.data.equals(item)) {
					this.next = this.next.next;
					return true;
				}
				else return this.next.remove(item);
			}
			return false;
		}

		/**
		 * Remove and return the first item in the list
		 * @return The first item of the list
		 */
		String pop() {
			String data = this.data;
			this.remove(data);
			return data;
		}

		/**
		 * Run through the list and check if an item exists
		 * @param item The string being searched for in the list
		 * @return If the search was successful
		 */
		boolean get(String item) {
			if (this.data.equals(item)) return true;
			return this.next != null && this.next.get(item);
		}

		/**
		 * Move an item from anywhere in the list to the front
		 * @param item The string being moved to the front
		 * @return If the operation was successful
		 */
		boolean moveToFront(String item) {
			return this.remove(item) && this.add(item);
		}

		public String toString() {
			return this.data + (this.next != null ? ", " + this.next : "");
		}

		public Iterator<String> iterator() {
			return new NodeIterator(this);
		}

		private class NodeIterator implements Iterator<String> {
			Node node;

			NodeIterator(Node node) {
				this.node = node;
			}

			@Override
			public boolean hasNext() {
				return this.node != null;
			}

			@Override
			public String next() throws NoSuchElementException {
				if (!this.hasNext()) throw new NoSuchElementException();
				String data = this.node.data;
				this.node = this.node.next;
				return data;
			}
		}
	}

	/**
	 * Creates a Hash Set with the default capacity.
	 */
	public StringHashSet() {
		// Recall that using this as a method calls another constructor
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Creates a Hash Set with the given capacity.
	 */
	public StringHashSet(int initialCapacity) {
		initialize(initialCapacity);
	}

	private void initialize(int initialCapacity) {
		this.size = 0;
		this.capacity = initialCapacity;
		this.array = new Node[this.capacity];
	}

	/**
	 * Calculates the hash code for Strings, using the x=31*x + y pattern.
	 * Follow the specification in the String.hashCode() method in the Java API.
	 * Note that the hashcode can overflow the max integer, so it can be
	 * negative. Later, in another method, you'll need to account for a negative
	 * hashcode by adding Integer.MAX_VALUE + 1 before you mod by the capacity
	 * (table size) to get the index.
	 *
	 * This method is NOT the place to calculate the index though.
	 *
	 * @param item
	 * @return The hash code for this String
	 */
	public static int stringHashCode(String item) {
		int hash = 0;
		for (char c : item.toCharArray()) {
			hash *= 31;
			hash += c;
		}
		return hash;
	}

	/**
	 * Adds a new node if it is not there already. If there is a collision, then
	 * add a new node to the -front- of the linked list.
	 * 
	 * Must operate in amortized O(1) time, assuming a good hashcode function.
	 *
	 * If the number of nodes in the hash table would be over double the
	 * capacity (that is, lambda > 2) as a result of adding this item, then
	 * first double the capacity and then rehash all the current items into the
	 * double-size table.
	 *
	 * @param item
	 * @return true if the item was successfully added (that is, if that hash
	 *         table was modified as a result of this call), false otherwise.
	 */
	public boolean add(String item) {
		// TODO: Write this
		return true;
	}

	/**
	 * Prints an array value on each line. Each line will be an array index
	 * followed by a colon and a list of Node data values, ending in null. For
	 * example, inserting the strings in the testAddSmallCollisions example
	 * gives "0: shalom hola null 1 bonjour null 2 caio hello null 3 null 4 hi
	 * null". Use a StringBuilder, so you can build the string in O(n) time.
	 * (Repeatedly concatenating n strings onto a growing string gives O(n^2)
	 * time)
	 * 
	 * @return A slightly-formatted string, mostly used for debugging
	 */
	public String toRawString() {
		// TODO: Write this
		return null;
	}

	/**
	 * 
	 * Checks if the given item is in the hash table.
	 * 
	 * Must operate in O(1) time, assuming a good hashcode function.
	 *
	 * @param item
	 * @return True if and only if the item is in the hash table.
	 */
	public boolean contains(String item) {
		// TODO: Write this
		return true;
	}

	/**
	 * Returns the number of items added to the hash table. Must operate in O(1)
	 * time.
	 *
	 * @return The number of items in the hash table.
	 */
	public int size() {
		return this.size;
	}

	/**
	 * @return True iff the hash table contains no items.
	 */
	public boolean isEmpty() {
		// TODO: Write this
		return true;
	}

	/**
	 * Removes all the items from the hash table. Resets the capacity to the
	 * DEFAULT_CAPACITY
	 */
	public void clear() {
		// TODO: Write this. Should take 1 line if you read carefully above.
	}

	/**
	 * Removes the given item from the hash table if it is there. You do NOT
	 * need to resize down if the load factor decreases below the threshold.
	 * 
	 * @param item
	 * @return True If the item was in the hash table (or equivalently, if the
	 *         table changed as a result).
	 */
	public boolean remove(String item) {
		// TODO: Write this.
		return true;
	}

	/**
	 * Adds all the items from the given collection to the hash table.
	 *
	 * @param collection
	 * @return True if the hash table is modified in any way.
	 */
	public boolean addAll(Collection<String> collection) {
		// TODO: Write this.
		return true;
	}

	/**
	 * 
	 * Challenge Feature: Returns an iterator over the set. Return the items in
	 * any order that you can do efficiently. Should throw a
	 * NoSuchElementException if there are no more items and next() is called.
	 * Should throw a ConcurrentModificationException if next() is called and
	 * the set has been mutated since the iterator was created.
	 *
	 * @return an iterator.
	 */
	public Iterator<String> iterator() {
		return null;
	}

	// Challenge Feature: If you have an iterator, this is easy. Use a
	// StringBuilder, so you can build the string in O(n) time. (Repeatedly
	// concatenating n strings onto a string gives O(n^2) time)
	// Format it like any other Collection's toString (like [a, b, c])
	@Override
	public String toString() {
		return null;
	}
}
