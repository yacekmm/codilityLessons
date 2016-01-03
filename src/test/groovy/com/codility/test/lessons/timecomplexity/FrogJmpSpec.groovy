package com.codility.test.lessons.timecomplexity

import com.codility.lessons.timecomplexity.FrogJmp
import spock.lang.Specification

class FrogJmpSpec extends Specification {
    FrogJmp sut

    void setup() {
        sut = new FrogJmp()
    }

    def "Solution params"() {
        expect:
        sut.solution(X, Y, D) == result

        where:
        X   |   Y   |   D   |   result
        10  |   85  |   30  |   3
        10  |   10  |   30  |   0
        10  |   40  |   30  |   1
    }
}
