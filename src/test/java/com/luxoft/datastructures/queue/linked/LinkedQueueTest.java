package com.luxoft.datastructures.queue.linked;

import com.luxoft.datastructures.queue.QueueTest;
import org.junit.jupiter.api.BeforeEach;

public class LinkedQueueTest extends QueueTest {
    @Override
    @BeforeEach
    public void before() {
        queue = new LinkedQueue();
    }
}
