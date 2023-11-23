import org.example.ArrayListImpl;
import org.example.StringList;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.AssertJUnit.*;
import static org.testng.FileAssert.fail;

public class ArrayListImplTest {

    @Test
    public void testAdd() {
        StringList stringList = new ArrayListImpl();
        assertEquals("Apple", stringList.add("Apple"));
        assertEquals("Banana", stringList.add("Banana"));
        assertEquals("Orange", stringList.add("Orange"));
        assertEquals(3, stringList.size());
    }

    @Test
    public void testAddAtIndex() {
        StringList stringList = new ArrayListImpl();
        stringList.add("Apple");
        stringList.add("Orange");

        stringList.add(1, "Banana");
        assertEquals("Banana", stringList.get(1));
        assertEquals("Orange", stringList.get(2));
        assertEquals(3, stringList.size());

        // Test adding at the beginning
        stringList.add(0, "Grapes");
        assertEquals("Grapes", stringList.get(0));
        assertEquals("Apple", stringList.get(1));
        assertEquals(4, stringList.size());
    }

    @Test
    public void testSet() {
        StringList stringList = new ArrayListImpl();
        stringList.add("Apple");
        stringList.add("Banana");

        assertEquals("Banana", stringList.set(1, "Orange"));
        assertEquals("Orange", stringList.get(1));

        // Test setting at the beginning
        assertEquals("Apple", stringList.set(0, "Grapes"));
        assertEquals("Grapes", stringList.get(0));
    }

    @Test
    public void testRemove() {
        StringList stringList = new ArrayListImpl();
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");

        assertEquals("Banana", stringList.remove("Banana"));
        assertEquals(2, stringList.size());
        assertFalse(stringList.contains("Banana"));

        // Test removing non-existing item
        try {
            stringList.remove("Grapes");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void testRemoveAtIndex() {
        StringList stringList = new ArrayListImpl();
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");

        assertEquals("Banana", stringList.remove(1));
        assertEquals(2, stringList.size());
        assertFalse(stringList.contains("Banana"));

        // Test removing at the beginning
        assertEquals("Apple", stringList.remove(0));
        assertEquals("Orange", stringList.get(0));
        assertEquals(1, stringList.size());

        // Test removing at the end
        assertEquals("Orange", stringList.remove(0));
        assertTrue(stringList.isEmpty());
    }

    @Test
    public void testContains() {
        StringList stringList = new ArrayListImpl();
        stringList.add("Apple");
        stringList.add("Banana");

        assertTrue(stringList.contains("Apple"));
        assertTrue(stringList.contains("Banana"));
        assertFalse(stringList.contains("Orange"));
    }

    @Test
    public void testIndexOf() {
        StringList stringList = new ArrayListImpl();
        stringList.add("Apple");
        stringList.add("Banana");

        assertEquals(0, stringList.indexOf("Apple"));
        assertEquals(1, stringList.indexOf("Banana"));
        assertEquals(-1, stringList.indexOf("Orange"));
    }

    @Test
    public void testLastIndexOf() {
        StringList stringList = new ArrayListImpl();
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Apple");

        assertEquals(2, stringList.lastIndexOf("Apple"));
        assertEquals(1, stringList.lastIndexOf("Banana"));
        assertEquals(-1, stringList.lastIndexOf("Orange"));
    }

    @Test
    public void testGet() {
        StringList stringList = new ArrayListImpl();
        stringList.add("Apple");
        stringList.add("Banana");

        assertEquals("Apple", stringList.get(0));
        assertEquals("Banana", stringList.get(1));

        // Test getting from an invalid index
        try {
            stringList.get(2);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

    @Test
    public void testEquals() {
        StringList list1 = new ArrayListImpl();
        list1.add("Apple");
        list1.add("Banana");

        StringList list2 = new ArrayListImpl();
        list2.add("Apple");
        list2.add("Banana");

        assertTrue(list1.equals(list2));

        list2.add("Orange");
        assertFalse(list1.equals(list2));
    }

    @Test
    public void testSize() {
        StringList stringList = new ArrayListImpl();
        assertEquals(0, stringList.size());

        stringList.add("Apple");
        stringList.add("Banana");
        assertEquals(2, stringList.size());
    }

    @Test
    public void testIsEmpty() {
        StringList stringList = new ArrayListImpl();
        assertTrue(stringList.isEmpty());

        stringList.add("Apple");
        assertFalse(stringList.isEmpty());
    }

    @Test
    public void testClear() {
        StringList stringList = new ArrayListImpl();
        stringList.add("Apple");
        stringList.add("Banana");

        stringList.clear();
        assertTrue(stringList.isEmpty());
        assertEquals(0, stringList.size());
    }

    @Test
    public void testToArray() {
        StringList stringList = new ArrayListImpl();
        stringList.add("Apple");
        stringList.add("Banana");

        String[] array = stringList.toArray();
        assertArrayEquals(new String[]{"Apple", "Banana"}, array);
    }
}