package com.sollers.test;

import com.sollers.Task;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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