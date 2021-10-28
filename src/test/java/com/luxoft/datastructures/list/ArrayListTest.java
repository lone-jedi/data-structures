package com.luxoft.datastructures.list;

import com.luxoft.datastructures.queue.ArrayQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayListTest {
    @Test
    public void testAddToListAndSize() {
        ArrayList arrayList = new ArrayList();

        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Pizza");
        arrayList.add("Cake");

        assertEquals(4, arrayList.size());
    }

    @Test
    public void testAddToListNull() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(NullPointerException.class, () ->
                arrayList.add(null));
    }

    @Test
    public void testAddToListHugeAmountOfItemsAndSize() {
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 10_000_000; i++) {
            arrayList.add(i);
        }

        assertEquals(10_000_000, arrayList.size());
    }

    @Test
    public void testAddAndGetItems() {
        ArrayList arrayList = new ArrayList();

        arrayList.add("Pizza");
        arrayList.add("Burger");
        arrayList.add("Cheese");

        assertEquals("Cheese", arrayList.get(2));
        assertEquals("Pizza", arrayList.get(0));
        assertEquals("Burger", arrayList.get(1));
    }

    @Test
    public void testAddAndGetWithIncorrectIndex() {
        ArrayList arrayList = new ArrayList();

        arrayList.add(2.4);
        arrayList.add(0.23);
        arrayList.add(-12.4);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(3));
    }

    @Test
    public void testSetItems() {
        ArrayList arrayList = new ArrayList();

        arrayList.add("Apple");
        arrayList.add("Cola");

        arrayList.set("Cheese", 1);
        arrayList.set("Pasta", 0);

        assertEquals("Cheese", arrayList.get(1));
        assertEquals("Pasta", arrayList.get(0));
    }

    @Test
    public void testSetItemsWithIncorrectIndex() {
        ArrayList arrayList = new ArrayList();

        arrayList.add("Apple");
        arrayList.add("Cola");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                arrayList.set("Hello", -1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                arrayList.set("Error!!!", 2));
    }

    @Test
    public void testSetNullItem() {
        ArrayList arrayList = new ArrayList();

        arrayList.add("Hello");

        Assertions.assertThrows(NullPointerException.class, () ->
                arrayList.set(null, 0));
        Assertions.assertThrows(NullPointerException.class, () ->
                arrayList.set(null, 1));
    }

    @Test
    public void testSetToEmptyList() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                arrayList.set("Yo", 0));
    }

    @Test
    public void testGetFromEmptyList() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                arrayList.get(0));
    }

    @Test
    public void testAddByIndex() {
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }

        arrayList.add(100, 4);
        assertEquals(100, arrayList.get(4));
    }

    @Test
    public void testAddByFirstIndex() {
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }

        arrayList.add(100, 0);
        assertEquals(100, arrayList.get(0));
    }

    @Test
    public void testAddByLastIndex() {
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }

        arrayList.add(100, 9);
        assertEquals(100, arrayList.get(9));
    }

    @Test
    public void testAddAfterAllElenemts() {
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }

        arrayList.add(111, 10);
        assertEquals(111, arrayList.get(10));
    }

    @Test
    public void testAddNByIncorrectIndex() {
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                arrayList.add(102, -1));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                arrayList.add(102, 11));
    }

    @Test
    public void testAddNullValueByIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Hi");

        Assertions.assertThrows(NullPointerException.class, () ->
                arrayList.add(null, 0));
        Assertions.assertThrows(NullPointerException.class, () ->
                arrayList.add(null, 1));
    }

    @Test
    public void testSizeWhenListIsEmpty() {
        ArrayList arrayList = new ArrayList();
        assertEquals(0, arrayList.size());
    }

    @Test
    public void testIsEmptyWhenListContainsItems() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        assertEquals(false, arrayList.isEmpty());
    }

    @Test
    public void testIsEmptyWhenListNotContainsItems() {
        ArrayList arrayList = new ArrayList();
        assertEquals(true, arrayList.isEmpty());
    }

    @Test
    public void testClearAndSizeAndAdd() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        assertEquals(10, arrayList.size());
        arrayList.clear();
        assertEquals(0, arrayList.size());
        arrayList.clear();
        assertEquals(0, arrayList.size());
    }

    @Test
    public void testClearAndSizeWhenListIsEmpty() {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        assertEquals(0, arrayList.size());
    }

    @Test
    public void testRemove() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Apple");
        arrayList.add("Melon");
        arrayList.add("Vine");
        arrayList.add("Papaya");

        arrayList.remove(2);
        assertEquals(3, arrayList.size());

        assertEquals("Apple", arrayList.get(0));
        assertEquals("Melon", arrayList.get(1));
        assertEquals("Papaya", arrayList.get(2));
    }

    @Test
    public void testRemoveFirstItem() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Apple");
        arrayList.add("Melon");
        arrayList.add("Vine");
        arrayList.add("Papaya");

        arrayList.remove(0);
        assertEquals(3, arrayList.size());

        assertEquals("Melon", arrayList.get(0));
        assertEquals("Vine", arrayList.get(1));
        assertEquals("Papaya", arrayList.get(2));
    }

    @Test
    public void testRemoveLastItem() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Apple");
        arrayList.add("Melon");
        arrayList.add("Vine");
        arrayList.add("Papaya");

        arrayList.remove(3);
        assertEquals(3, arrayList.size());

        assertEquals("Apple", arrayList.get(0));
        assertEquals("Melon", arrayList.get(1));
        assertEquals("Vine", arrayList.get(2));
    }

    @Test
    public void testRemoveManyItems() {
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
        }

        for (int i = 0; i < 1000; i++) {
            assertEquals(1000 - i, arrayList.size());
            assertEquals( i, arrayList.remove(0));
        }

        assertEquals(0, arrayList.size());
    }

    @Test
    public void testRemoveWhenListEmpty() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                arrayList.remove(0));
    }

    @Test
    public void testRemoveWithIncorrectIndex() {
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                arrayList.remove(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                arrayList.remove(10));
    }

    @Test
    public void testContains() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Apple");
        arrayList.add("Melon");
        arrayList.add("Vine");
        arrayList.add("Papaya");

        assertEquals(true, arrayList.contains("Apple"));
        assertEquals(true, arrayList.contains("Melon"));
        assertEquals(true, arrayList.contains("Vine"));
        assertEquals(true, arrayList.contains("Papaya"));

        assertEquals(false, arrayList.contains("Pizza"));
        assertEquals(false, arrayList.contains(-1));
    }

    @Test
    public void testContainsWhenListIsEmpty() {
        ArrayList arrayList = new ArrayList();
        assertEquals(false, arrayList.contains("Pizza"));
    }

    @Test
    public void testContainsWhenSearchedValueIsNull() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(NullPointerException.class, () ->
                arrayList.contains(null));
    }

    @Test
    public void testIndexOf() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Apple");
        arrayList.add("Melon");
        arrayList.add("Melon");
        arrayList.add("Papaya");

        assertEquals(0, arrayList.indexOf("Apple"));
        assertEquals(1, arrayList.indexOf("Melon"));
        assertEquals(1, arrayList.indexOf("Melon"));
        assertEquals(3, arrayList.indexOf("Papaya"));

        assertEquals(-1, arrayList.indexOf("Pizza"));
        assertEquals(-1, arrayList.indexOf("Paprika"));
    }

    @Test
    public void testIndexOfWhenSeachedValueIsNull() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(NullPointerException.class, () ->
                arrayList.indexOf(null));
    }

    @Test
    public void testIndexOfWhenListIsEmpty() {
        ArrayList arrayList = new ArrayList();
        assertEquals(-1, arrayList.indexOf("Hi"));
    }

    @Test
    public void testLastIndexOf() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Apple");
        arrayList.add("Melon");
        arrayList.add("Melon");
        arrayList.add("Papaya");

        assertEquals(0, arrayList.lastIndexOf("Apple"));
        assertEquals(2, arrayList.lastIndexOf("Melon"));
        assertEquals(2, arrayList.lastIndexOf("Melon"));
        assertEquals(3, arrayList.lastIndexOf("Papaya"));

        assertEquals(-1, arrayList.lastIndexOf("Pizza"));
        assertEquals(-1, arrayList.lastIndexOf("Paprika"));
    }

    @Test
    public void testLastIndexOfWhenSeachedValueIsNull() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(NullPointerException.class, () ->
                arrayList.lastIndexOf(null));
    }

    @Test
    public void testLastIndexOfWhenListIsEmpty() {
        ArrayList arrayList = new ArrayList();
        assertEquals(-1, arrayList.lastIndexOf("Hi"));
    }

    @Test
    public void testCustomSizeConstructor() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ArrayList(-1));
    }

    @Test
    public void testToStringList() {
        ArrayList arrayList = new ArrayList();

        arrayList.add("Apple");
        arrayList.add("Pineapple");
        arrayList.add("Banana");

        String expected = "[Apple, Pineapple, Banana]";

        assertEquals(expected, arrayList.toString());
    }

    @Test
    public void testToStringIfListIsEmpty() {
        ArrayList arrayList = new ArrayList();
        assertEquals("[]", arrayList.toString());
    }
}
