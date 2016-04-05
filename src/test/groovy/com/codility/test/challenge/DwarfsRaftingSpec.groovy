package com.codility.test.challenge

import com.codility.challenge.BoatSector
import com.codility.challenge.Solution
import spock.lang.Specification

import java.awt.*

class DwarfsRaftingSpec extends Specification {
    def "test solution"() {
        expect:
        new Solution().solution(N, S, T) == result

        where:
        result  | N     | S                     | T
        0       | 2     | "1A 1B 2A 2B"         | ""
        0       | 2     | ""                    | "1A 1B 2A 2B"
        -1      | 2     | "1A 1B 2A"            | "2B"
        4       | 2     | ""                    | ""
        6       | 4     | "1B 1C 4B 1D 2A"      | "3B 2D"
        2       | 2     | "2A"                  | ""
    }

    def "test getDwarfsCount"() {
        expect:
        new BoatSector().getItemsOnSeatsCount(rowStart, rowEnd, colStart, colEnd, dwarfsPos as String[]) == result

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
        new BoatSector().getIntPosition(stringPos) == result

        where:
        result          | stringPos
        new Point(1,1)  | "1A"
        new Point(1,2)  | "1B"
        new Point(2,2)  | "2B"
        new Point(22,2) | "22B"
        new Point(22,26)| "22Z"
    }
}
