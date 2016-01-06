package com.codility.test.lessons.prefixsums

import com.codility.lessons.prefixsums.GenomicRangeQuery
import spock.lang.Specification

class GenomicRangeQuerySpec extends Specification {
    private GenomicRangeQuery sut

    def "Solution"() {
        given:
        sut = new GenomicRangeQuery()

        expect:
        sut.solution(S, P as int[], Q as int[]) == result

        where:
        S           | P         | Q         | result
        "A"         | [0]       | [0]       | [1]
        "C"         | [0]       | [0]       | [2]
        "G"         | [0]       | [0]       | [3]
        "T"         | [0]       | [0]       | [4]
        "AA"        | [0]       | [0]       | [1]
        "AA"        | [0, 1]    | [0, 1]    | [1, 1]
        "AT"        | [0, 1]    | [0, 1]    | [1, 4]
        "AT"        | [0, 0]    | [0, 1]    | [1, 1]
        "CAGCCTA"   | [2, 5, 0] | [4, 5, 6] | [2, 4, 1]
    }
}
