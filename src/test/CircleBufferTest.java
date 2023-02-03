package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import cb.CircleBuffer;

public class CircleBufferTest {
    @Test
    public void bufferPopulatedWithOneElement() {
        CircleBuffer<Integer> buffer = new CircleBuffer<>(3);
        buffer.push(5);
        assertFalse(buffer.isEmpty());
    }

    @Test
    public void bufferCanHoldDataUpToCapacity() {
        CircleBuffer<Integer> buffer = new CircleBuffer<>(3);
        buffer.push(5);
        buffer.push(10);
        buffer.push(15);
        assertEquals(5, buffer.get(0).intValue());
        assertEquals(10, buffer.get(1).intValue());
        assertEquals(15, buffer.get(2).intValue());
    }

    @Test
    public void bufferCanReplaceOldestItemAtCapacity() {
        CircleBuffer<Integer> buffer = new CircleBuffer<>(3);
        buffer.push(5);
        buffer.push(10);
        buffer.push(15);
        assertEquals(5, buffer.get(0).intValue());
        buffer.push(20);
        assertEquals(10, buffer.get(0).intValue());
        assertEquals(15, buffer.get(1).intValue());
    }

    @Test
    public void bufferItemsCanBeCompletelyReplaced() {
        CircleBuffer<Integer> buffer = new CircleBuffer<>(3);
        buffer.push(5);
        buffer.push(10);
        buffer.push(15);
        assertEquals(5, buffer.get(0).intValue());
        assertEquals(10, buffer.get(1).intValue());
        assertEquals(15, buffer.get(2).intValue());
        buffer.push(20);
        buffer.push(25);
        buffer.push(30);
        assertEquals(20, buffer.get(0).intValue());
        assertEquals(25, buffer.get(1).intValue());
        assertEquals(30, buffer.get(2).intValue());
    }


}
