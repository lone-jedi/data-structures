package com.luxoft.datastructures.queue.array;

import com.luxoft.datastructures.queue.QueueTest;
import org.junit.jupiter.api.BeforeEach;

public class ArrayQueueTest extends QueueTest {

    @Override
    @BeforeEach
    public void before() {
        queue = new ArrayQueue();
    }
}
