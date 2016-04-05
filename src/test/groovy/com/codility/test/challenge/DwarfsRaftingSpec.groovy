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
        new DwarfsRafting().getItemsOnSeatsCount(rowStart, rowEnd, colStart, colEnd, dwarfsPos as String[]) == result

        where:
        result  | rowStart  | rowEnd    | colStart  | colEnd    | dwarfsPos
        //1 x 1 boat
        0       | 1         | 1         | 1         | 1         | [""]
        1       | 1         | 1         | 1         | 1         | ["1A"]
        0       | 1         | 1         | 1         | 1         | ["1B"]
        0       | 1         | 1         | 1         | 1         | ["2A"]
        0       | 1         | 1         | 1         | 1         | ["2B"]
        // 2 x 2 boat
        1       | 1         | 2         | 1         | 2         | ["2B"]
        // multiple dwarfs
        2       | 1         | 2         | 1         | 2         | ["1A", "2B"]
        3       | 1         | 2         | 1         | 2         | ["1A", "1B", "2B"]
        4       | 1         | 2         | 1         | 2         | ["1A", "1B", "2A", "2B"]
        4       | 1         | 2         | 1         | 2         | ["1A", "1B", "2A", "2B", "2C"]
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
