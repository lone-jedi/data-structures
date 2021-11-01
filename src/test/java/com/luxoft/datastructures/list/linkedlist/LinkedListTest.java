package com.luxoft.datastructures.list.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {
    @Test
    public void testAddToListAndSize() {
        LinkedList linkedList = new LinkedList();

        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Pizza");
        linkedList.add("Cake");

        assertEquals(4, linkedList.size());
    }

    @Test
    public void testAddToListNull() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(NullPointerException.class, () ->
                linkedList.add(null));
    }

    @Test
    public void testAddToListHugeAmountOfItemsAndSize() {
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 10_000_000; i++) {
            linkedList.add(i);
        }

        assertEquals(10_000_000, linkedList.size());
    }

    @Test
    public void testAddAndGetItems() {
        LinkedList linkedList = new LinkedList();

        linkedList.add("Pizza");
        linkedList.add("Burger");
        linkedList.add("Cheese");

        assertEquals("Cheese", linkedList.get(2));
        assertEquals("Pizza", linkedList.get(0));
        assertEquals("Burger", linkedList.get(1));
    }

    @Test
    public void testAddAndGetWithIncorrectIndex() {
        LinkedList linkedList = new LinkedList();

        linkedList.add(2.4);
        linkedList.add(0.23);
        linkedList.add(-12.4);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(3));
    }

    @Test
    public void testSetItems() {
        LinkedList linkedList = new LinkedList();

        linkedList.add("Apple");
        linkedList.add("Cola");

        linkedList.set("Cheese", 1);
        linkedList.set("Pasta", 0);

        assertEquals("Cheese", linkedList.get(1));
        assertEquals("Pasta", linkedList.get(0));
    }

    @Test
    public void testSetItemsWithIncorrectIndex() {
        LinkedList linkedList = new LinkedList();

        linkedList.add("Apple");
        linkedList.add("Cola");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                linkedList.set("Hello", -1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                linkedList.set("Error!!!", 2));
    }

    @Test
    public void testSetNullItem() {
        LinkedList linkedList = new LinkedList();

        linkedList.add("Hello");

        Assertions.assertThrows(NullPointerException.class, () ->
                linkedList.set(null, 0));
        Assertions.assertThrows(NullPointerException.class, () ->
                linkedList.set(null, 1));
    }

    @Test
    public void testSetToEmptyList() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                linkedList.set("Yo", 0));
    }

    @Test
    public void testGetFromEmptyList() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                linkedList.get(0));
    }

    @Test
    public void testAddByIndex() {
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }

        linkedList.add(100, 4);
        assertEquals(100, linkedList.get(4));
    }

    @Test
    public void testAddByFirstIndex() {
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }

        linkedList.add(100, 0);
        assertEquals(100, linkedList.get(0));
    }

    @Test
    public void testAddByLastIndex() {
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }

        linkedList.add(100, 9);
        assertEquals(100, linkedList.get(9));
    }

    @Test
    public void testAddAfterAllElenemts() {
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }

        linkedList.add(111, 10);
        assertEquals(111, linkedList.get(10));
    }

    @Test
    public void testAddNByIncorrectIndex() {
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                linkedList.add(102, -1));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                linkedList.add(102, 11));
    }

    @Test
    public void testAddNullValueByIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("Hi");

        Assertions.assertThrows(NullPointerException.class, () ->
                linkedList.add(null, 0));
        Assertions.assertThrows(NullPointerException.class, () ->
                linkedList.add(null, 1));
    }

    @Test
    public void testSizeWhenListIsEmpty() {
        LinkedList linkedList = new LinkedList();
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testIsEmptyWhenListContainsItems() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        assertEquals(false, linkedList.isEmpty());
    }

    @Test
    public void testIsEmptyWhenListNotContainsItems() {
        LinkedList linkedList = new LinkedList();
        assertEquals(true, linkedList.isEmpty());
    }

    @Test
    public void testClearAndSizeAndAdd() {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
        assertEquals(10, linkedList.size());
        linkedList.clear();
        assertEquals(0, linkedList.size());
        linkedList.clear();
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testClearAndSizeWhenListIsEmpty() {
        LinkedList linkedList = new LinkedList();
        linkedList.clear();
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testRemove() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("Apple");
        linkedList.add("Melon");
        linkedList.add("Vine");
        linkedList.add("Papaya");

        linkedList.remove(2);
        assertEquals(3, linkedList.size());

        assertEquals("Apple", linkedList.get(0));
        assertEquals("Melon", linkedList.get(1));
        assertEquals("Papaya", linkedList.get(2));
    }

    @Test
    public void testRemoveFirstItem() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("Apple");
        linkedList.add("Melon");
        linkedList.add("Vine");
        linkedList.add("Papaya");

        linkedList.remove(0);
        assertEquals(3, linkedList.size());

        assertEquals("Melon", linkedList.get(0));
        assertEquals("Vine", linkedList.get(1));
        assertEquals("Papaya", linkedList.get(2));
    }

    @Test
    public void testRemoveLastItem() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("Apple");
        linkedList.add("Melon");
        linkedList.add("Vine");
        linkedList.add("Papaya");

        linkedList.remove(3);
        assertEquals(3, linkedList.size());

        assertEquals("Apple", linkedList.get(0));
        assertEquals("Melon", linkedList.get(1));
        assertEquals("Vine", linkedList.get(2));
    }

    @Test
    public void testRemoveManyItems() {
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 1000; i++) {
            linkedList.add(i);
        }

        for (int i = 0; i < 1000; i++) {
            assertEquals(1000 - i, linkedList.size());
            assertEquals( i, linkedList.remove(0));
        }

        assertEquals(0, linkedList.size());
    }

    @Test
    public void testRemoveWhenListEmpty() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                linkedList.remove(0));
    }

    @Test
    public void testRemoveWithIncorrectIndex() {
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                linkedList.remove(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                linkedList.remove(10));
    }

    @Test
    public void testContains() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("Apple");
        linkedList.add("Melon");
        linkedList.add("Vine");
        linkedList.add("Papaya");

        assertEquals(true, linkedList.contains("Apple"));
        assertEquals(true, linkedList.contains("Melon"));
        assertEquals(true, linkedList.contains("Vine"));
        assertEquals(true, linkedList.contains("Papaya"));

        assertEquals(false, linkedList.contains("Pizza"));
        assertEquals(false, linkedList.contains(-1));
    }

    @Test
    public void testContainsWhenListIsEmpty() {
        LinkedList linkedList = new LinkedList();
        assertEquals(false, linkedList.contains("Pizza"));
    }

    @Test
    public void testContainsWhenSearchedValueIsNull() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(NullPointerException.class, () ->
                linkedList.contains(null));
    }

    @Test
    public void testIndexOf() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("Apple");
        linkedList.add("Melon");
        linkedList.add("Melon");
        linkedList.add("Papaya");

        assertEquals(0, linkedList.indexOf("Apple"));
        assertEquals(1, linkedList.indexOf("Melon"));
        assertEquals(1, linkedList.indexOf("Melon"));
        assertEquals(3, linkedList.indexOf("Papaya"));

        assertEquals(-1, linkedList.indexOf("Pizza"));
        assertEquals(-1, linkedList.indexOf("Paprika"));
    }

    @Test
    public void testIndexOfWhenSeachedValueIsNull() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(NullPointerException.class, () ->
                linkedList.indexOf(null));
    }

    @Test
    public void testIndexOfWhenListIsEmpty() {
        LinkedList linkedList = new LinkedList();
        assertEquals(-1, linkedList.indexOf("Hi"));
    }

    @Test
    public void testLastIndexOf() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("Apple");
        linkedList.add("Melon");
        linkedList.add("Melon");
        linkedList.add("Papaya");

        assertEquals(0, linkedList.lastIndexOf("Apple"));
        assertEquals(2, linkedList.lastIndexOf("Melon"));
        assertEquals(2, linkedList.lastIndexOf("Melon"));
        assertEquals(3, linkedList.lastIndexOf("Papaya"));

        assertEquals(-1, linkedList.lastIndexOf("Pizza"));
        assertEquals(-1, linkedList.lastIndexOf("Paprika"));
    }

    @Test
    public void testLastIndexOfWhenSeachedValueIsNull() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(NullPointerException.class, () ->
                linkedList.lastIndexOf(null));
    }

    @Test
    public void testLastIndexOfWhenListIsEmpty() {
        LinkedList linkedList = new LinkedList();
        assertEquals(-1, linkedList.lastIndexOf("Hi"));
    }


    @Test
    public void testToStringList() {
        LinkedList linkedList = new LinkedList();

        linkedList.add("Apple");
        linkedList.add("Pineapple");
        linkedList.add("Banana");

        String expected = "[Apple, Pineapple, Banana]";

        assertEquals(expected, linkedList.toString());
    }

    @Test
    public void testToStringIfListIsEmpty() {
        LinkedList linkedList = new LinkedList();
        assertEquals("[]", linkedList.toString());
    }
}

