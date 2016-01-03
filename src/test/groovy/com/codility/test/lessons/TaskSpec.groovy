package com.codility.test.lessons

import com.codility.Task
import spock.lang.Specification

class TaskSpec extends Specification {

    Task task;

    void setup() {
        task = new Task()

    }

    def "Run"() {
        given:


        when:
        def result = task.run(1, 3)

        then:
        result == 4
    }

    def "binaryGap"(){
        given:


        when:
        def result = task.solutionBinaryGap(1041)

        then:
        result == 5
    }
}
