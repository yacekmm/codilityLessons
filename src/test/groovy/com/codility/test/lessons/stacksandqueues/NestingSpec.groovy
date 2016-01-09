package com.codility.test.lessons.stacksandqueues

import com.codility.lessons.stacksandqueues.Nesting
import spock.lang.Specification

class NestingSpec extends Specification {
    def "test solution"() {
        expect:
        new Nesting().solution(S) == res

        where:
        res | S
        1   | "(()(())())"
        0   | "())"
        0   | "(()"
        1   | "()()"
        1   | ""
    }
}
