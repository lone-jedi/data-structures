package com.luxoft.datastructures.list.linkedlist;

import com.luxoft.datastructures.list.ListTest;
import org.junit.jupiter.api.BeforeEach;

public class LinkedListTest extends ListTest {

    @Override
    @BeforeEach
    public void before() {
        list = new LinkedList();
    }
}

