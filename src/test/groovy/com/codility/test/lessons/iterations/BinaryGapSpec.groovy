package com.codility.test.lessons.iterations

import com.codility.lessons.iterations.BinaryGap
import spock.lang.Specification

class BinaryGapSpec extends Specification {
    def "does its job"() {
        expect:
        new BinaryGap().solution(N) == result

        where:
        N       | result
        0       | 0
        1       | 0
        123     | 1
        128     | 0
        127     | 0
        9       | 2
        529     | 4
        20      | 1
        15      | 0
        1041    | 5

    }
}
