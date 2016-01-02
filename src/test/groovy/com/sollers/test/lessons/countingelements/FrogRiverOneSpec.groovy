package com.sollers.test.lessons.countingelements

import com.sollers.lessons.countingelements.FrogRiverOne
import spock.lang.Specification

class FrogRiverOneSpec extends Specification {

    FrogRiverOne frog = new FrogRiverOne();

    def "Solution"() {
        expect:
        frog.solution(X, A as int[]) == result

        where:
        X   |   A                           |   result
        5   |   [1, 3, 1, 4, 2, 3, 5, 4]    |   6
        6   |   [1, 3, 1, 4, 6, 3, 5, 4]    |   -1
        1   |   [1]                         |   0
        2   |   [1, 1, 1, 1]                |   -1
//        1   |   [2, 1]                      |   0
    }
}
