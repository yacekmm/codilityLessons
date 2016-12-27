package com.codility.challenge.second

import spock.lang.Specification

class SolutionSpec extends Specification {

    def "Solution returns a result"() {
        expect:
        def solution = new Solution()
        solution.solution(1, input, "") == result

        where:
        input | result
        "ew"  | 2
    }
}
