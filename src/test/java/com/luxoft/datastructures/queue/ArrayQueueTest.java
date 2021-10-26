package com.luxoft.datastructures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayQueueTest {
    @Test
    public void testEnqueueAndSize() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("Apple");
        arrayQueue.enqueue("Pineapple");
        arrayQueue.enqueue("Banana");

        assertEquals(3, arrayQueue.size());
    }

    @Test
    public void testEnqueueAndDequeue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("Apple");
        arrayQueue.enqueue("Pineapple");
        arrayQueue.enqueue("Banana");

        assertEquals("Apple", arrayQueue.dequeue());
        assertEquals("Pineapple", arrayQueue.dequeue());
        assertEquals("Banana", arrayQueue.dequeue());
    }

    @Test
    public void testSizeAndEnqueueAndDequeue() {
        ArrayQueue arrayQueue = new ArrayQueue();

        assertEquals(0, arrayQueue.size());
        arrayQueue.enqueue("Apple");
        assertEquals(1, arrayQueue.size());
        arrayQueue.enqueue("Pineapple");
        assertEquals(2, arrayQueue.size());
        arrayQueue.enqueue("Banana");
        assertEquals(3, arrayQueue.size());
        assertEquals("Apple", arrayQueue.dequeue());
        assertEquals(2, arrayQueue.size());
        assertEquals("Pineapple", arrayQueue.dequeue());
        assertEquals(1, arrayQueue.size());
        assertEquals("Banana", arrayQueue.dequeue());
        assertEquals(0, arrayQueue.size());
    }

    @Test
    public void testDequeueIfQueueIsEmpty() {
        ArrayQueue arrayQueue = new ArrayQueue();

        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayQueue.dequeue();
        });
    }

    @Test
    public void testPeekAndEnqueue() {
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.enqueue("Apple");
        arrayQueue.enqueue("Pineapple");
        arrayQueue.enqueue("Banana");

        assertEquals("Apple", arrayQueue.peek());
    }

    @Test
    public void testPeekIfQueueIsEmpty() {
        ArrayQueue arrayQueue = new ArrayQueue();

        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayQueue.peek();
        });
    }

    @Test
    public void testIsEmptyIfQueueIsEmpty() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertEquals(true, arrayQueue.isEmpty());
    }

    @Test
    public void testIsEmptyIfQueueNotEmpty() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("Apple");
        assertEquals(false, arrayQueue.isEmpty());
    }

    @Test
    public void testContains() {
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.enqueue("Apple");
        arrayQueue.enqueue("Pineapple");
        arrayQueue.enqueue("Banana");
        arrayQueue.enqueue("Tomato");
        arrayQueue.enqueue("Berry");
        arrayQueue.enqueue("Cherry");
        arrayQueue.enqueue("Potato");
        arrayQueue.enqueue("Pasta");
        arrayQueue.enqueue("Egg");
        arrayQueue.enqueue("Bread");

        assertEquals(true, arrayQueue.contains("Cherry"));
    }

    @Test
    public void testContainsFirstElement() {
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.enqueue("Apple");
        arrayQueue.enqueue("Pineapple");
        arrayQueue.enqueue("Banana");
        arrayQueue.enqueue("Tomato");
        arrayQueue.enqueue("Berry");
        arrayQueue.enqueue("Cherry");
        arrayQueue.enqueue("Potato");
        arrayQueue.enqueue("Pasta");
        arrayQueue.enqueue("Egg");
        arrayQueue.enqueue("Bread");

        assertEquals(true, arrayQueue.contains("Apple"));
    }

    @Test
    public void testContainsLastElement() {
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.enqueue("Apple");
        arrayQueue.enqueue("Pineapple");
        arrayQueue.enqueue("Banana");
        arrayQueue.enqueue("Tomato");
        arrayQueue.enqueue("Berry");
        arrayQueue.enqueue("Cherry");
        arrayQueue.enqueue("Potato");
        arrayQueue.enqueue("Pasta");
        arrayQueue.enqueue("Egg");
        arrayQueue.enqueue("Bread");

        assertEquals(true, arrayQueue.contains("Bread"));
    }

    @Test
    public void testContainsIfElementDoesNotExist() {
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.enqueue("Apple");
        arrayQueue.enqueue("Pineapple");
        arrayQueue.enqueue("Banana");
        arrayQueue.enqueue("Tomato");
        arrayQueue.enqueue("Berry");
        arrayQueue.enqueue("Cherry");
        arrayQueue.enqueue("Potato");
        arrayQueue.enqueue("Pasta");
        arrayQueue.enqueue("Egg");
        arrayQueue.enqueue("Bread");

        assertEquals(false, arrayQueue.contains("Egg2"));
    }

    @Test
    public void testContainsIfQueueIsEmpty() {
        ArrayQueue arrayQueue = new ArrayQueue();

        assertEquals(false, arrayQueue.contains("Egg"));
    }

    @Test
    public void testClearAndEnqueueAndIsEmpty() {
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.enqueue("Apple");
        arrayQueue.enqueue("Pineapple");
        arrayQueue.enqueue("Banana");
        arrayQueue.enqueue("Tomato");

        arrayQueue.clear();

        assertEquals(true, arrayQueue.isEmpty());
    }

    @Test
    public void testClearAndSizeIfQueueIsEmpty() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.clear();
        assertEquals(true, arrayQueue.isEmpty());
    }

    @Test
    public void testToStringAndEnqueue() {
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.enqueue("Apple");
        arrayQueue.enqueue("Pineapple");
        arrayQueue.enqueue("Banana");

        String expected = "[Apple, Pineapple, Banana]";

        assertEquals(expected, arrayQueue.toString());
    }

    @Test
    public void testToStringIfQueueIsEmpty() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertEquals("[]", arrayQueue.toString());
    }
}
