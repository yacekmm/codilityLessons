package com.codility.test.lessons.maximumslice

import com.codility.lessons.maximumslice.MaxDoubleSliceSum
import spock.lang.Specification

class MaxDoubleSliceSumSpec extends Specification {
    def "test solution"() {
        expect:
        new MaxDoubleSliceSum().solution(A as int[]) == res

        where:
        res | A
        0   | []

        17  | [3, 2, 6, -1, 4, 5, -1, 2]
    }
}
