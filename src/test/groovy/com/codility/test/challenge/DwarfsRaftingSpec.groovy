package com.codility.test.challenge

import com.codility.challenge.DwarfsRafting
import spock.lang.Specification

import java.awt.*

class DwarfsRaftingSpec extends Specification {
    def "test solution"() {
        expect:
        new DwarfsRafting().solution(N, S, T) == result

        where:
        result  | N     | S     | T
        4       | 2     | ""    | ""
    }

    def "test getDwarfsCount"() {
        expect:
        new DwarfsRafting().getDwarfsCount(rowStart, rowEnd, colStart, colEnd, dwarfsPos) == result

        where:
        result  | rowStart  | rowEnd    | colStart  | colEnd    | dwarfsPos
        0       | 1         | 1         | 1         | 1         | ""
    }


    def "test getIntPosition"() {
        expect:
        new DwarfsRafting().getIntPosition(stringPos) == result

        where:
        result          | stringPos
        new Point(1,1)  | "1A"
        new Point(1,2)  | "1B"
        new Point(2,2)  | "2B"
        new Point(22,2) | "22B"
    }
}
