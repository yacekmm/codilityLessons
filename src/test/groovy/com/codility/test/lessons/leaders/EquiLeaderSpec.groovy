package com.codility.test.lessons.leaders

import com.codility.lessons.leaders.EquiLeader
import spock.lang.Specification

class EquiLeaderSpec extends Specification {
    def "Solution"() {
        expect:
        new EquiLeader().solution(A as int[]) == res

        where:
        res | A
        0   | []
        0   | [1, 2]
        0   | [1, 2, 3]
        1   | [1, 1]
        0   | [1, 1, 2]
        2   | [1, 1, 2, 1]
        2   | [4, 3, 4, 4, 4, 2]
    }
}
