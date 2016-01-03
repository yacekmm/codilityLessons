package com.codility.test.lessons.countingelements

import com.codility.lessons.countingelements.MaxCounters
import spock.lang.Specification

class MaxCounterSpec extends Specification {

    MaxCounters sut = new MaxCounters()

    def "Solution"() {
        expect:
        sut.solution(N, A as int[]) == result as int[]

        where:
        N   | A                           |   result
        1   | []                          |   [0]
        0   | []                          |   []
        0   | [1, 2]                      |   []
        1   | [1]                         |   [1]
        1   | [1, 1]                      |   [2]
        1   | [1, 1, 1]                   |   [3]
        2   | [1, 1, 1]                   |   [3, 0]
        2   | [1, 1, 2]                   |   [2, 1]
        1   | [2]                         |   [0]
        1   | [1, 2]                      |   [1]
        2   | [1, 3]                      |   [1, 1]            //maxCounter
        5   | [3, 4, 4, 6, 1, 4, 4]       |   [3, 2, 2, 4, 2]   //from task
        5   | [1, 1, 1, 1, 1, 1, 1]       |   [7, 0, 0, 0, 0]
    }
}
