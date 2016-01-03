package com.codility.test.lessons.countingelements

import com.codility.lessons.countingelements.MissingInteger
import spock.lang.Specification

class MissingIntegerSpec extends Specification {

    MissingInteger sut = new MissingInteger()

    def "Solution"() {
        expect:
        sut.solution(A as int[]) == result

        where:
        A                           |   result
        [1, 3, 6, 4, 1, 2]          |   5
        [1, 3, 5, 4, 1, 2]          |   6
        [6, 3, 5, 4, 6, 2]          |   1
        [6, 3, 5, 4, 1, -2]         |   2
        [-2]                        |   1
        [2]                         |   1
        [222]                       |   1
        [1, 222]                    |   2
        [0, 1]                      |   2
        [1, 2]                      |   3
    }
}
