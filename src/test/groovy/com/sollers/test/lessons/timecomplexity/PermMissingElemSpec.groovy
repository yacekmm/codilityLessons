package com.sollers.test.lessons.timecomplexity

import com.sollers.lessons.timecomplexity.PermMissingElem
import spock.lang.Specification

class PermMissingElemSpec extends Specification {

    PermMissingElem elem

    void setup() {
        elem = new PermMissingElem()
    }

    def "Solution params"() {
        expect:
        elem.solution(input as int[]) == result

        where:
        input           |   result
        [2, 3, 1, 5]    |   4
        []              |   1
        [1]             |   2
        [2]             |   1
        [1, 2, 3]       |   4
        [2, 3, 4]       |   1
        [1, 2]          |   3
    }
}
