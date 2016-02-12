package com.codility.test.lessons.euclideanalgorithm

import com.codility.lessons.euclideanalgorithm.ChocolatesByNumbers
import spock.lang.Specification

class ChocolatesByNumbersSpec extends Specification {
    def "Solution"() {
        expect:
        new ChocolatesByNumbers().solution(N, M ) == res

        where:
        res         | N             | M
        1           | 1             | 1
        2           | 2             | 1
        3           | 3             | 1
        1           | 3             | 3
        3           | 3             | 2
        2           | 2             | 3
        1000000000  | 1000000000    | 1
        5           | 10            | 4
    }
}
