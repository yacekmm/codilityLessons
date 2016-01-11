package com.codility.test.lessons.sorting

import com.codility.lessons.sorting.NumberOfDiscIntersections
import spock.lang.Specification

class NumberOfDiscIntersectionsSpec extends Specification {
    def "test solution"() {
        expect:
        new NumberOfDiscIntersections().solution(A as int[]) == result

        where:
        result  | A
        1       | [1, 0]
        11      | [1, 5, 2, 1, 4, 0]
    }
}
