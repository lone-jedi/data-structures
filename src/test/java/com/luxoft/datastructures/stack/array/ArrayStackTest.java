package com.luxoft.datastructures.stack.array;

import com.luxoft.datastructures.stack.StackTest;
import org.junit.jupiter.api.BeforeEach;

public class ArrayStackTest extends StackTest {
    @Override
    @BeforeEach
    public void before() {
        stack = new ArrayStack();
    }
}
