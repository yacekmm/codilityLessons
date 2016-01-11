package com.codility.test.lessons.stacksandqueues

import com.codility.lessons.stacksandqueues.Brackets
import spock.lang.Specification

class BracketsSpec extends Specification {
    def "test solution"() {
        expect:
        new Brackets().solution(S) == result

        where:
        result  | S
        1       | ""
        0       | null
        1       | "{}"
        1       | "{[()()]}{[()()]}"
        0       | "{{}"
        0       | "{}}"
        1       | "{[({[()()]})()]}"
        1       | "{[()()]}"
        0       | "([)()]"
    }
}
