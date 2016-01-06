package com.codility.test.lessons.prefixsums

import com.codility.lessons.prefixsums.CountDiv
import spock.lang.Specification

class CountDivSpec extends Specification {

    CountDiv sut = new CountDiv();

    def "Solution"() {
        expect:
        sut.solution(A, B, K) == result

        where:
        A   | B     | K | result
        6   | 11    | 2 | 3
        7   | 11    | 2 | 2
        7   | 7     | 2 | 0
        6   | 11    | 3 | 2
        6   | 11    | 11| 1
        6   | 11    | 9 | 1
        6   | 21    | 7 | 3
        6   | 20    | 7 | 2
        6   | 20    | 6 | 3
        6   | 10    | 1 | 5
        6   | 10    | 21| 0
        0   | 10    | 2 | 6
        0   | 10    | 22| 0

    }
}
