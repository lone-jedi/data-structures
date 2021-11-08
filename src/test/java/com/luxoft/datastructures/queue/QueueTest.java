package com.luxoft.datastructures.queue;

import com.luxoft.datastructures.queue.array.ArrayQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract public class QueueTest {
    protected Queue queue;

    @BeforeEach
    abstract public void before();

    @Test
    public void testEnqueueAndSize() {
        queue.enqueue("Apple");
        queue.enqueue("Pineapple");
        queue.enqueue("Banana");

        assertEquals(3, queue.size());
    }

    @Test
    public void testEnqueueAndDequeue() {
        queue.enqueue("Apple");
        queue.enqueue("Pineapple");
        queue.enqueue("Banana");

        assertEquals("Apple", queue.dequeue());
        assertEquals("Pineapple", queue.dequeue());
        assertEquals("Banana", queue.dequeue());
    }

    @Test
    public void testSizeAndEnqueueAndDequeue() {
        assertEquals(0, queue.size());
        queue.enqueue("Apple");
        assertEquals(1, queue.size());
        queue.enqueue("Pineapple");
        assertEquals(2, queue.size());
        queue.enqueue("Banana");
        assertEquals(3, queue.size());
        assertEquals("Apple", queue.dequeue());
        assertEquals(2, queue.size());
        assertEquals("Pineapple", queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals("Banana", queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    public void testDequeueIfQueueIsEmpty() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            queue.dequeue();
        });
    }

    @Test
    public void testPeekAndEnqueue() {
        queue.enqueue("Apple");
        queue.enqueue("Pineapple");
        queue.enqueue("Banana");

        assertEquals("Apple", queue.peek());
    }

    @Test
    public void testPeekIfQueueIsEmpty() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            queue.peek();
        });
    }

    @Test
    public void testIsEmptyIfQueueIsEmpty() {
        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testIsEmptyIfQueueNotEmpty() {
        queue.enqueue("Apple");
        assertEquals(false, queue.isEmpty());
    }

    @Test
    public void testContains() {
        queue.enqueue("Apple");
        queue.enqueue("Pineapple");
        queue.enqueue("Banana");
        queue.enqueue("Tomato");
        queue.enqueue("Berry");
        queue.enqueue("Cherry");
        queue.enqueue("Potato");
        queue.enqueue("Pasta");
        queue.enqueue("Egg");
        queue.enqueue("Bread");

        assertEquals(true, queue.contains("Cherry"));
    }

    @Test
    public void testContainsFirstElement() {
        queue.enqueue("Apple");
        queue.enqueue("Pineapple");
        queue.enqueue("Banana");
        queue.enqueue("Tomato");
        queue.enqueue("Berry");
        queue.enqueue("Cherry");
        queue.enqueue("Potato");
        queue.enqueue("Pasta");
        queue.enqueue("Egg");
        queue.enqueue("Bread");

        assertEquals(true, queue.contains("Apple"));
    }

    @Test
    public void testContainsLastElement() {
        queue.enqueue("Apple");
        queue.enqueue("Pineapple");
        queue.enqueue("Banana");
        queue.enqueue("Tomato");
        queue.enqueue("Berry");
        queue.enqueue("Cherry");
        queue.enqueue("Potato");
        queue.enqueue("Pasta");
        queue.enqueue("Egg");
        queue.enqueue("Bread");

        assertEquals(true, queue.contains("Bread"));
    }

    @Test
    public void testContainsIfElementDoesNotExist() {
        queue.enqueue("Apple");
        queue.enqueue("Pineapple");
        queue.enqueue("Banana");
        queue.enqueue("Tomato");
        queue.enqueue("Berry");
        queue.enqueue("Cherry");
        queue.enqueue("Potato");
        queue.enqueue("Pasta");
        queue.enqueue("Egg");
        queue.enqueue("Bread");

        assertEquals(false, queue.contains("Egg2"));
    }

    @Test
    public void testContainsIfQueueIsEmpty() {
        assertEquals(false, queue.contains("Egg"));
    }

    @Test
    public void testClearAndEnqueueAndIsEmpty() {
        queue.enqueue("Apple");
        queue.enqueue("Pineapple");
        queue.enqueue("Banana");
        queue.enqueue("Tomato");

        queue.clear();

        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testClearAndSizeIfQueueIsEmpty() {
        queue.clear();
        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testToStringAndEnqueue() {
        queue.enqueue("Apple");
        queue.enqueue("Pineapple");
        queue.enqueue("Banana");

        String expected = "[Apple, Pineapple, Banana]";

        assertEquals(expected, queue.toString());
    }

    @Test
    public void testToStringIfQueueIsEmpty() {
        assertEquals("[]", queue.toString());
    }

    @Test
    public void testEnqueueWhenQueueIsEmpty() {
        queue.enqueue(10);
        queue.enqueue(13);
        queue.enqueue(1);
        queue.enqueue(-34);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        Assertions.assertThrows(IllegalStateException.class,
                () -> queue.dequeue());

        queue.enqueue(101);
        assertEquals(101, queue.dequeue());
    }

    @Test
    public void testExpandQueueSize() {
        for(int i = 0; i < 1_000_000; ++i) {
            queue.enqueue(i);
        }

        for(int i = 0; i < 1_000_000; ++i) {
            assertEquals(i, queue.dequeue());
        }

        for(int i = 0; i < 10; ++i) {
            Assertions.assertThrows(IllegalStateException.class, () -> {
                queue.dequeue();
            });
        }

        assertEquals(true, queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void testConstructorSizeLessThanZero() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ArrayQueue(-1));
    }

    @Test
    public void testEnqueueNullValue() {
        Assertions.assertThrows(NullPointerException.class,
                () -> queue.enqueue(null));
    }

    @Test
    public void testContainsNullValue() {
        Assertions.assertThrows(NullPointerException.class,
                () -> queue.contains(null));
    }
}
