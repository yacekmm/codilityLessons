package com.codility.challenge.second

import spock.lang.Specification

class SolutionSpec extends Specification {

    Solution solution

    void setup() {
        solution = new Solution()
    }

    def "Solution returns a result for left column"() {
        expect:
        solution.solution(N, S + " 1H + 2H 1E 2E") == result

        where:
        N | S       | result
        1 | ""      | 1
        1 | "1A"    | 0
        1 | "1B"    | 0
        1 | "1C"    | 0
        1 | "1A 1B" | 0
        1 | "1A 1C" | 0
        1 | "1B 1C" | 0
        1 | "2B 2C" | 1
        2 | "2B 2C" | 1
        2 | "1A"    | 1
    }

    def "Solution returns a result for RIGHT column"() {
        expect:
        solution.solution(N, S + " 1A + 2A 1E 2E") == result

        where:
        N | S       | result
        1 | ""      | 1
        1 | "1H"    | 0
        1 | "1J"    | 0
        1 | "1K"    | 0
        1 | "1H 1J" | 0
        1 | "1H 1K" | 0
        1 | "1J 1K" | 0
        1 | "2J 2K" | 1
        2 | "2J 2K" | 1
        2 | "1H"    | 1
    }


    def "Solution returns a result for MIDDLE column"() {
        expect:
        solution.solution(N, S + " 1A 2A 3A 1H 2H 3H") == result

        where:
        N | S       | result
        1 | ""      | 1
        1 | "1E"    | 0
        1 | "1F"    | 0
        1 | "1D"    | 1
        1 | "1G"    | 1
        1 | "1D 1E" | 0
        1 | "1D 1F" | 0
        1 | "1D 1G" | 0
        1 | "1E 1G" | 0
        1 | "1F 1G" | 0
        2 | "2D 1G" | 2
        3 | "2D 2G" | 2
        1 | "2D 1G" | 1
    }

    def "splits string to hashset"() {
        expect:
        solution.splitSeats(S) == result

        where:
        S       | result
//        ""      | new HashSet<String>()
        "1A"    | ["1A"] as HashSet
        "1A 2B" | ["1A", "2B"] as HashSet
        "1A 1A" | ["1A"] as HashSet
        "1a"    | ["1A"] as HashSet
    }
}
