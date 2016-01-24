package com.codility.test.lessons.maximumslice

import com.codility.lessons.maximumslice.MaxProfit
import spock.lang.Specification

class MaxProfitSpec extends Specification {
    def "test solution"() {
        expect:
        new MaxProfit().solution(A as int[]) == res

        where:
        res | A
        356 | [23171, 21123, 21011, 21366, 21013, 21367]
    }
}
