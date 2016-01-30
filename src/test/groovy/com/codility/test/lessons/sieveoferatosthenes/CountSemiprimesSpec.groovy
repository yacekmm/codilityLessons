package com.codility.test.lessons.sieveoferatosthenes

import com.codility.lessons.sieveoferatosthenes.CountSemiprimes
import spock.lang.Specification

class CountSemiprimesSpec extends Specification {
    def "test solution"() {

        expect:
        new CountSemiprimes().solution(N, P as int[], Q as int[]) == res

        where:
        N   | P             | Q             | res
        26  | [1, 4, 16]    | [26, 10, 20]  | [10, 4, 0]
    }
}
