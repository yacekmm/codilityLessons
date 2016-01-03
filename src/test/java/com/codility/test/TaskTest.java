package com.codility.test;

import com.codility.Task;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskTest {

    Task task;

    @Before
    public void setUp() throws Exception {
        task = new Task();
    }

    @Test
    public void testRun() throws Exception {

        int actual = task.run(1, 5);

        assertEquals(6, actual);
    }
}