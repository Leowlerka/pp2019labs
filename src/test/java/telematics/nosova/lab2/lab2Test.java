package telematics.nosova.lab2;

import org.junit.Test;
import org.junit.Assert;

import java.util.Queue;
import java.util.LinkedList;

public class lab2Test {
    @Test
    public void test_constructor() {
        Queue<Integer> b = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            b.add(i);
        }
        MyQueue<Integer> a = new MyQueue<Integer>(b);
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(a.remove(), b.remove());
        }
    }

    @Test
    public void test_add_remove() {
        MyQueue<Integer> a = new MyQueue<Integer>();
        Queue<Integer> b = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            a.add(i);
            b.add(i);
        }
        Assert.assertEquals(true, true);
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(a.remove(), b.remove());
        }
        Assert.assertNull(a.remove());
    }

    @Test
    public void test_size() {
        MyQueue<Integer> a = new MyQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            a.add(i);
        }
        Assert.assertEquals(10, a.size());
        a.remove();
        a.remove();
        Assert.assertEquals(8, a.size());
    }

    @Test
    public void test_contains() {
        MyQueue<Integer> a = new MyQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            a.add(i);
        }
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(a.contains(i));
        }
        Assert.assertFalse(a.contains(10));
    }

    @Test
    public void test_get() {
        MyQueue<Integer> a = new MyQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            a.add(i);
        }
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals((int) a.get(i), 9 - i);
        }
    }
}


