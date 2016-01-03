package com.codility.test.lessons.countingelements

import com.codility.lessons.countingelements.PermCheck
import spock.lang.Specification

class PermCheckSpec extends Specification {

    PermCheck sut = new PermCheck()

    def "Solution"() {
        expect:
        sut.solution(A as int[]) == result

        where:
        A                           |   result
        [4, 1, 3, 2]                |   1
        [4, 1, 3]                   |   0
        [4, 1, 3, 3]                |   0
        [1]                         |   1
        [4]                         |   0
        [1, 1, 2, 3]                |   0
        [3, 2, 3, 1]                |   0
    }
}
