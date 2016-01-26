package com.codility.test.lessons.primeandcompositenumbers

import com.codility.lessons.primeandcompositenumbers.MinPerimeterRectangle
import spock.lang.Specification

class MinPerimeterRectangleSpec extends Specification {

    def "Solution"() {
        expect:
        new MinPerimeterRectangle().solution(N) == res

        where:
        N   |   res
        30  |   22

    }
}
