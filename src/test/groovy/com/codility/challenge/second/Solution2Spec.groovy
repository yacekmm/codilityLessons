package com.codility.challenge.second

import spock.lang.Specification

import java.time.LocalDateTime

class Solution2Spec extends Specification {
    Solution2 solution

    void setup() {
        solution = new Solution2()
    }

    def "Solution for one city below 10 photos"() {
        expect:
        solution.solution(input) == output

        where:
        input | output
        ""    | ""
    }

    def "parses date"() {
        expect:
        solution.parseDate(S) == result

        where:
        S                     | result
        "2013-09-05 14:18:15" | LocalDateTime.of(2013, 9, 5, 14, 18, 15)
    }
}
