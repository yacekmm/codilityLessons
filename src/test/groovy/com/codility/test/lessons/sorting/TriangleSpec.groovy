package com.codility.test.lessons.sorting

import com.codility.lessons.sorting.Triangle
import spock.lang.Specification

class TriangleSpec extends Specification {
    def "Solution"() {
        expect:
        new Triangle().solution(A as int[]) == result

        where:
        result  | A
        1       | [1, 2, 2]
        0       | [-1, -2, -2]
        0       | [-1, -2, 2]
        0       | [-1, 2, -2]
        0       | [1, -2, -2]
        0       | [1, 2, -2]
        0       | [-1, 2, 2]
        0       | [20, 8, 10]
        1       | [5, 8, 10]
        1       | [10, 2, 5, 1, 8, 20]
        0       | [10, 50, 5, 1]
    }
}
