package com.codility.test.lessons.sorting

import com.codility.lessons.sorting.MaxProductOfThree
import spock.lang.Specification

class MaxProductOfThreeSpec extends Specification {

    def "Solution"() {
        expect:
        new MaxProductOfThree().solution(A as int[]) == result

        where:
        result  | A
        60      | [-3, 1, 2, -2, 5, 6]
        125     | [-5, 5, -5, 4]
    }
}
