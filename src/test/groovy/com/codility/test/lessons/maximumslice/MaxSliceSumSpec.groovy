package com.codility.test.lessons.maximumslice

import com.codility.lessons.maximumslice.MaxSliceSum
import spock.lang.Specification

class MaxSliceSumSpec extends Specification {
    def "test solution"() {
        expect:
        new MaxSliceSum().solution(A as int[]) == res

        where:
        res | A
        0   | []
        3   | [3]
        1   | [-2, 1]
        1   | [1, -2]
        5   | [3, 2, -6, 4, 0]
    }
}
