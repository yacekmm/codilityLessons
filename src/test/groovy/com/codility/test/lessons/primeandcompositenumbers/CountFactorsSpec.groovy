package com.codility.test.lessons.primeandcompositenumbers

import com.codility.lessons.primeandcompositenumbers.CountFactors
import spock.lang.Specification

class CountFactorsSpec extends Specification {
    def "Solution"() {

        expect:
        new CountFactors().solution(N) == res

        where:
        N   |   res
        1   |   1
        2   |   2
        3   |   2
        4   |   3
        5   |   2
        24  |   8
    }
}
