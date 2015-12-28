package com.sollers.test;

import com.sollers.Task
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

    def "s2"(){
        given:
        int[][] input = [[2, 2, 4, 2], [0, 3, 0, 1], [1, 2, 2, 1], [4, 1, 2, 2]]

        when:
        int result = task.solution(input)

        then:
        result == 15
    }
}