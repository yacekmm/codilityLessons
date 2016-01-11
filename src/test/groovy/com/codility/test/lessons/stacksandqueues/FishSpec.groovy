package com.codility.test.lessons.stacksandqueues

import com.codility.lessons.stacksandqueues.Fish
import spock.lang.Specification

class FishSpec extends Specification {
    def "test solution"() {
        expect:
        new Fish().solution(A as int[], B as int[]) == res

        where:
        res | A                 | B
        1   | [2, 1]            | [1, 0]
        1   | [2, 1, 3]         | [1, 0, 0]
        2   | [2, 1, 3]         | [0, 1, 0]
        3   | [2, 1, 3]         | [0, 0, 1]
        2   | [2, 6, 3, 4, 5]   | [0, 1, 1, 1, 0]
        1   | [2]               | [0]
        1   | [2]               | [1]
        0   | []                | []
        2   | [4, 3, 2, 1, 5]   | [0, 1, 0, 0, 0]
    }
}
