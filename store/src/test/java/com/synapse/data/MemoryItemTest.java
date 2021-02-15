package com.synapse.data;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MemoryItemTest {
    @Test
    public void test1() {
        MemoryItem memoryItem1 = new MemoryItem("one",1);
        MemoryItem memoryItem2 = new MemoryItem("one",1);
        MemoryItem memoryItem3 = new MemoryItem("two",1);
        MemoryItem memoryItem4 = new MemoryItem("three",3);

        assertTrue(memoryItem1.equals(memoryItem2));
        assertTrue(Arrays.equals("one".toCharArray(),memoryItem1.getToken()));
        assertEquals(1L,memoryItem2.getCode());
        assertFalse(memoryItem1.equals(memoryItem3));
        assertTrue(memoryItem1.hashCode()==memoryItem2.hashCode());
        assertFalse(memoryItem1.hashCode()==memoryItem3.hashCode());
    }
}
