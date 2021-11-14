package com.luxoft.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

abstract public class ListTest {
    protected AbstractList list;

    @BeforeEach
    abstract public void before();
    
    @Test
    public void testAddToListAndSize() {
        list.add("Apple");
        list.add("Banana");
        list.add("Pizza");
        list.add("Cake");

        assertEquals(4, list.size());
    }

    @Test
    public void testAddToListNull() {
        Assertions.assertThrows(NullPointerException.class, () ->
                list.add(null));
    }

    @Test
    public void testAddToListHugeAmountOfItemsAndSize() {
        for (int i = 0; i < 10_000_000; i++) {
            list.add(i);
        }

        assertEquals(10_000_000, list.size());
    }

    @Test
    public void testAddAndGetItems() {
        list.add("Pizza");
        list.add("Burger");
        list.add("Cheese");

        assertEquals("Cheese", list.get(2));
        assertEquals("Pizza", list.get(0));
        assertEquals("Burger", list.get(1));
    }

    @Test
    public void testAddAndGetWithIncorrectIndex() {
        list.add(2.4);
        list.add(0.23);
        list.add(-12.4);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    public void testSetItems() {
        list.add("Apple");
        list.add("Cola");

        list.set("Cheese", 1);
        list.set("Pasta", 0);

        assertEquals("Cheese", list.get(1));
        assertEquals("Pasta", list.get(0));
    }

    @Test
    public void testSetItemsWithIncorrectIndex() {
        list.add("Apple");
        list.add("Cola");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                list.set("Hello", -1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                list.set("Error!!!", 2));
    }

    @Test
    public void testSetNullItem() {
        list.add("Hello");

        Assertions.assertThrows(NullPointerException.class, () ->
                list.set(null, 0));
        Assertions.assertThrows(NullPointerException.class, () ->
                list.set(null, 1));
    }

    @Test
    public void testSetToEmptyList() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                list.set("Yo", 0));
    }

    @Test
    public void testGetFromEmptyList() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                list.get(0));
    }

    @Test
    public void testAddByIndex() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.add(100, 4);
        assertEquals(100, list.get(4));
    }

    @Test
    public void testAddByFirstIndex() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.add(100, 0);
        assertEquals(100, list.get(0));
    }

    @Test
    public void testAddByLastIndex() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.add(100, 9);
        assertEquals(100, list.get(9));
    }

    @Test
    public void testAddAfterAllElenemts() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.add(111, 10);
        assertEquals(111, list.get(10));
    }

    @Test
    public void testAddNByIncorrectIndex() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                list.add(102, -1));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                list.add(102, 11));
    }

    @Test
    public void testAddNullValueByIndex() {
        list.add("Hi");

        Assertions.assertThrows(NullPointerException.class, () ->
                list.add(null, 0));
        Assertions.assertThrows(NullPointerException.class, () ->
                list.add(null, 1));
    }

    @Test
    public void testSizeWhenListIsEmpty() {
        assertEquals(0, list.size());
    }

    @Test
    public void testIsEmptyWhenListContainsItems() {
        list.add(1);
        assertEquals(false, list.isEmpty());
    }

    @Test
    public void testIsEmptyWhenListNotContainsItems() {
        assertEquals(true, list.isEmpty());
    }

    @Test
    public void testClearAndSizeAndAdd() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(10, list.size());
        list.clear();
        assertEquals(0, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testClearAndSizeWhenListIsEmpty() {
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testRemove() {
        list.add("Apple");
        list.add("Melon");
        list.add("Vine");
        list.add("Papaya");

        list.remove(2);
        assertEquals(3, list.size());

        assertEquals("Apple", list.get(0));
        assertEquals("Melon", list.get(1));
        assertEquals("Papaya", list.get(2));
    }

    @Test
    public void testRemoveFirstItem() {
        list.add("Apple");
        list.add("Melon");
        list.add("Vine");
        list.add("Papaya");

        list.remove(0);
        assertEquals(3, list.size());

        assertEquals("Melon", list.get(0));
        assertEquals("Vine", list.get(1));
        assertEquals("Papaya", list.get(2));
    }

    @Test
    public void testRemoveLastItem() {
        list.add("Apple");
        list.add("Melon");
        list.add("Vine");
        list.add("Papaya");

        list.remove(3);
        assertEquals(3, list.size());

        assertEquals("Apple", list.get(0));
        assertEquals("Melon", list.get(1));
        assertEquals("Vine", list.get(2));
    }

    @Test
    public void testRemoveManyItems() {
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        for (int i = 0; i < 1000; i++) {
            assertEquals(1000 - i, list.size());
            assertEquals( i, list.remove(0));
        }

        assertEquals(0, list.size());
    }

    @Test
    public void testRemoveWhenListEmpty() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                list.remove(0));
    }

    @Test
    public void testRemoveWithIncorrectIndex() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                list.remove(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                list.remove(10));
    }

    @Test
    public void testContains() {
        list.add("Apple");
        list.add("Melon");
        list.add("Vine");
        list.add("Papaya");

        assertEquals(true, list.contains("Apple"));
        assertEquals(true, list.contains("Melon"));
        assertEquals(true, list.contains("Vine"));
        assertEquals(true, list.contains("Papaya"));

        assertEquals(false, list.contains("Pizza"));
        assertEquals(false, list.contains(-1));
    }

    @Test
    public void testContainsWhenListIsEmpty() {
        assertEquals(false, list.contains("Pizza"));
    }

    @Test
    public void testContainsWhenSearchedValueIsNull() {
        Assertions.assertThrows(NullPointerException.class, () ->
                list.contains(null));
    }

    @Test
    public void testIndexOf() {
        list.add("Apple");
        list.add("Melon");
        list.add("Melon");
        list.add("Papaya");

        assertEquals(0, list.indexOf("Apple"));
        assertEquals(1, list.indexOf("Melon"));
        assertEquals(1, list.indexOf("Melon"));
        assertEquals(3, list.indexOf("Papaya"));

        assertEquals(-1, list.indexOf("Pizza"));
        assertEquals(-1, list.indexOf("Paprika"));
    }

    @Test
    public void testIndexOfWhenSeachedValueIsNull() {
        Assertions.assertThrows(NullPointerException.class, () ->
                list.indexOf(null));
    }

    @Test
    public void testIndexOfWhenListIsEmpty() {
        assertEquals(-1, list.indexOf("Hi"));
    }

    @Test
    public void testLastIndexOf() {
        
        list.add("Apple");
        list.add("Melon");
        list.add("Melon");
        list.add("Papaya");

        assertEquals(0, list.lastIndexOf("Apple"));
        assertEquals(2, list.lastIndexOf("Melon"));
        assertEquals(2, list.lastIndexOf("Melon"));
        assertEquals(3, list.lastIndexOf("Papaya"));

        assertEquals(-1, list.lastIndexOf("Pizza"));
        assertEquals(-1, list.lastIndexOf("Paprika"));
    }

    @Test
    public void testLastIndexOfWhenSeachedValueIsNull() {
        Assertions.assertThrows(NullPointerException.class, () ->
                list.lastIndexOf(null));
    }

    @Test
    public void testLastIndexOfWhenListIsEmpty() {
        assertEquals(-1, list.lastIndexOf("Hi"));
    }


    @Test
    public void statustestToStringList() {
        list.add("Apple");
        list.add("Pineapple");
        list.add("Banana");

        String expected = "[Apple, Pineapple, Banana]";

        assertEquals(expected, list.toString());
    }

    @Test
    public void testToStringIfListIsEmpty() {
        assertEquals("[]", list.toString());
    }

    @Test
    public void runIteratorOnStringList() {
        list.add("Apple");
        list.add("Pineapple");
        list.add("Banana");

        Iterator iterator = list.iterator();
        assertTrue(iterator.hasNext());

        Object value = iterator.next();
        assertEquals("Apple", value);
        assertTrue(iterator.hasNext());
        value = iterator.next();
        assertEquals("Pineapple", value);
        assertTrue(iterator.hasNext());
        value = iterator.next();
        assertEquals("Banana", value);
        assertFalse(iterator.hasNext());
    }
    
    @Test
    public void runIteratorWhenEmptyList() {
        Iterator iterator = list.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void removeItemFromListUsingIterator() {
        list.add("Apple");
        list.add("Pineapple");
        list.add("Banana");

        Iterator iterator = list.iterator();

        assertTrue(iterator.hasNext());
        Object value = iterator.next();
        assertEquals("Apple", value);

        assertTrue(iterator.hasNext());
        iterator.remove(); // Pineapple

        assertTrue(iterator.hasNext());
        value = iterator.next();
        assertEquals("Banana", value);

        assertFalse(iterator.hasNext());


        Iterator secondIterator = list.iterator();

        assertTrue(secondIterator.hasNext());
        secondIterator.remove(); // Apple

        assertTrue(secondIterator.hasNext());
        secondIterator.remove(); // Banana

        assertFalse(secondIterator.hasNext());

        Iterator thirdIterator = list.iterator();
        assertFalse(thirdIterator.hasNext());
    }
}

