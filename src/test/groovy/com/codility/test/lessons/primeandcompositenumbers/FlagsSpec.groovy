package com.codility.test.lessons.primeandcompositenumbers

import com.codility.lessons.primeandcompositenumbers.Flags
import spock.lang.Specification

class FlagsSpec extends Specification {
    def "Solution"() {
        expect:
        new Flags().solution(A as int[]) == res

        where:
        res |   A
//        3   |   [1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2]
    }
}
