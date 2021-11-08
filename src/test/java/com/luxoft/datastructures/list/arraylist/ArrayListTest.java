package com.luxoft.datastructures.list.arraylist;

import com.luxoft.datastructures.list.ListTest;
import org.junit.jupiter.api.BeforeEach;

public class ArrayListTest extends ListTest {

    @Override
    @BeforeEach
    public void before() {
        list = new ArrayList();
    }
}
