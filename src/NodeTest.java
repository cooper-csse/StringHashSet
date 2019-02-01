import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class NodeTest {
	private StringHashSet.Node numbers;

	@Before
	public void setupNodes() {
	}

	private void populateNumbers() {
		numbers = new StringHashSet.Node();
		numbers.add("five");
		numbers.add("four");
		numbers.add("three");
		numbers.add("two");
		numbers.add("one");
	}

	@Test
	public void testAdd() {
		populateNumbers();
		assertEquals("one, two, three, four, five", numbers.toString());
	}

	@Test
	public void testGet() {
		populateNumbers();
		assertEquals("Find item 'one'", 0, numbers.get("one"));
		assertEquals("Find item 'two'", 0, numbers.get("two"));
		assertEquals("Find item 'three'", 0, numbers.get("three"));
		assertEquals("Find item 'four'", 0, numbers.get("four"));
		assertEquals("Find item 'five'", 0, numbers.get("five"));
		assertEquals("Find item 'six'", 5, numbers.get("six"));
		assertEquals("Find item 'null'", 5, numbers.get(null));
		assertEquals("Find item on empty list", 0, new StringHashSet.Node().get("seven"));
	}

	@Test
	public void testRemove() {
		populateNumbers();
		assertTrue("Remove item 'three'", numbers.remove("three"));
		assertEquals("one, two, four, five", numbers.toString());
		assertTrue("Remove item 'one'", numbers.remove("one"));
		assertEquals("two, four, five", numbers.toString());
		assertTrue("Remove item 'five'", numbers.remove("five"));
		assertEquals("two, four", numbers.toString());
		assertFalse("Remove item 'six'", numbers.remove("six"));
		assertEquals("two, four", numbers.toString());
		assertTrue("Remove item 'two'", numbers.remove("two"));
		assertEquals("four", numbers.toString());
		assertTrue("Remove item 'four'", numbers.remove("four"));
		assertEquals("null", numbers.toString());
	}

	@Test
	public void testPop() {
		populateNumbers();
		assertEquals("Pop item", "one", numbers.pop());
		assertEquals("two, three, four, five", numbers.toString());
		assertEquals("Pop item", "two", numbers.pop());
		assertEquals("three, four, five", numbers.toString());
		assertEquals("Pop item", "three", numbers.pop());
		assertEquals("four, five", numbers.toString());
		assertEquals("Pop item", "four", numbers.pop());
		assertEquals("five", numbers.toString());
		assertEquals("Pop item", "five", numbers.pop());
		assertEquals("null", numbers.toString());
	}

	@Test
	public void testMoveToFront() {
		populateNumbers();
		assertTrue("Move item 'one' to front", numbers.moveToFront("one"));
		assertEquals("one, two, three, four, five", numbers.toString());
		assertTrue("Move item 'three' to front", numbers.moveToFront("three"));
		assertEquals("three, one, two, four, five", numbers.toString());
		assertTrue("Move item 'five' to front", numbers.moveToFront("five"));
		assertEquals("five, three, one, two, four", numbers.toString());
		assertTrue("Move item 'four' to front", numbers.moveToFront("four"));
		assertTrue("Move item 'three' to front", numbers.moveToFront("three"));
		assertTrue("Move item 'two' to front", numbers.moveToFront("two"));
		assertTrue("Move item 'one' to front", numbers.moveToFront("one"));
		assertEquals("one, two, three, four, five", numbers.toString());
	}

	@Test
	public void testIterator() {
		populateNumbers();
		int index = 0;
		String[] expected = {"one", "two", "three", "four", "five"};
		for (Iterator<String> iter = numbers.iterator(); iter.hasNext();) {
			String item = iter.next();
			assertEquals(expected[index++], item);
		}
		index = 0;
		for (String item : numbers) assertEquals(expected[index++], item);
	}
}
