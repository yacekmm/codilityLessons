package com.sollers.test.lessons.timecomplexity

import com.sollers.lessons.timecomplexity.TapeEquilibrium
import spock.lang.Specification

class TapeEquilibriumSpec extends Specification {

    TapeEquilibrium tapeEq

    void setup() {
        tapeEq = new TapeEquilibrium();
    }

    def "tapeEq"(){
        given:


        when:
        def result = tapeEq.solution([3, 1, 2, 4, 3] as int[])

        then:
        result == 1
    }

    def "tapeEq two element"(){
        given:


        when:
        def result = tapeEq.solution([1, 1] as int[])

        then:
        result == 0
    }
}
