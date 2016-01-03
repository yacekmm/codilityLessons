package com.codility.test.lessons;

import com.codility.Task
import spock.lang.Specification

public class TaskSolutionTest extends Specification {

    private Task task;

    void setup(){
        task = new Task()
    }

    def solution() {
        given:

        when:
        def result = task.s1(3, 5, [1, 2, 4, 6, 7] as Integer[])

        then:
        result == -1
    }
}