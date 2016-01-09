package com.codility.test.lessons.stacksandqueues

import com.codility.lessons.stacksandqueues.StoneWall
import spock.lang.Specification

class StoneWallSpec extends Specification {
    def "test solution"() {
        expect:
        new StoneWall().solution(H as int[]) == res

        where:
        res | H
        1   | [2]
        2   | [2, 3]
        2   | [2, 3, 3]
        3   | [2, 3, 3, 4]
        2   | [2, 3, 3, 2]
        3   | [2, 4, 4, 3]
        3   | [2, 4, 4, 1]
        7   | [8, 8, 5, 7, 9, 8, 7, 4, 8]
    }

}
