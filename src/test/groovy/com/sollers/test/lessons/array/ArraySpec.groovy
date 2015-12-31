package com.sollers.test.lessons.array

import com.sollers.lessons.array.Array
import spock.lang.Specification

class ArraySpec extends Specification {

    Array array;

    void setup(){
        array = new Array();
    }

    def "Solution"() {
        given:

        when:
        def result = array.solution([9, 3, 9, 3, 9, 7, 9] as int[])

        then:
        result == 7
    }
}
