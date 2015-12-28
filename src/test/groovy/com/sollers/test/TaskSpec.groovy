package com.sollers.test

import com.sollers.Task
import spock.lang.Specification

class TaskSpec extends Specification {
    void setup() {

    }

    def "Run"() {
        given:
        Task task = new Task()


        when:
        def result = task.run(1, 3)

        then:
        result == 4
    }
}
