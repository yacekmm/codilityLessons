package com.codility.test.lessons.prefixsums

import com.codility.lessons.prefixsums.MinAvgTwoSlice
import spock.lang.Specification

class MinAvgTwoSliceSpec extends Specification {

    MinAvgTwoSlice sut = new MinAvgTwoSlice()

    def "Solution"() {
        expect:
        sut.solution(A as int[]) == result

        where:
        result  | A
        1       | [4, 2, 1]                 //(1,2)
        0       | [4, 2]
        1       | [4, 2, 2, 5, 1, 5, 8]

    }
}
