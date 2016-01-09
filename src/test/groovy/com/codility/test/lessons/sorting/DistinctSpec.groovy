package com.codility.test.lessons.sorting

import com.codility.lessons.sorting.Distinct
import spock.lang.Specification

class DistinctSpec extends Specification {

    def "Solution"() {
        expect:
        new Distinct().solution(A as int[]) == result

        where:
        result  | A
        3       | [2, 1, 1, 2, 3, 1]
        3       | [2, 1, 3]
        1       | [1]
        0       | []
        1       | [2, 2, 2, 2, 2, 2]
        2       | [2, 2, 2, 2, 2, 3]
    }
}
