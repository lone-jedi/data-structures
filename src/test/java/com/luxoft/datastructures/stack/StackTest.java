package com.luxoft.datastructures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

abstract public class StackTest {
    protected Stack stack;
    
    @BeforeEach
    abstract public void before();
    
    @Test
    public void testPushAndPopWorkCorrectlyAndChangeSize() {
        stack.push("A");
        stack.push("B");

        assertEquals(2, stack.size());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushOverInitialCapacityAndPopWorkCorrectlyAndChangeSize() {
        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertEquals(3, stack.size());
        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());

        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushAndPeek() {
        stack.push("A");
        stack.push("B");

        assertEquals(2, stack.size());
        assertEquals("B", stack.peek());
        assertEquals("B", stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    public void testIsEmptyReturnTrueOnNewStack() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseOnStackWithData() {
        stack.push("A");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnStackAfterClear() {
        stack.push("A");
        stack.push("B");

        stack.clear();

        assertTrue(stack.isEmpty());
    }

    @Test
    public void testContainsReturnTrue() {
        stack.push("A");
        stack.push("B");

        assertTrue(stack.contains(new String("A")));
    }

    @Test
    public void testContainsReturnFalse() {
        stack.push("A");
        stack.push("B");

        assertFalse(stack.contains("C"));
    }

    @Test
    public void testContainsReturnFalseOnEmptyStack() {
        assertFalse(stack.contains("C"));
    }

    @Test
    public void testThrowIllegalStateExceptionWhenPopOnEmptyStack() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            stack.pop();
        });
    }
}
