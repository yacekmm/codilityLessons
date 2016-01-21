package com.codility.test.lessons.leaders

import com.codility.lessons.leaders.Dominator
import spock.lang.Specification

class DominatorSpec extends Specification {
    def "Solution"() {
        expect:
        new Dominator().solution(A as int[]) == result

        where:
        result  | A
        1       | [3, 3]
        2       | [3, 3, 3]
        2       | [3, 2, 3]
        2       | [2, 3, 3]
        0       | [3]
        -1       | []
        -1       | [3, 2]
        -1       | [3, 3, 2, 2]
        3       | [3, 3, 2, 3]
        7       | [3, 4, 3, 2, 3, -1, 3, 3]
    }
}
