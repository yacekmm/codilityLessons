package com.codility.challenge.second

import spock.lang.Specification

import java.time.LocalDateTime

class Solution2Spec extends Specification {
    Solution2 solution

    void setup() {
        solution = new Solution2()
    }

    def "Solution for one city below 10 photos"() {
        expect:
        solution.solution(input) == output

        where:
        input                                        | output
        "a.png, Warsaw, 2016-02-13 13:33:50"         | "Warsaw1.png"

        "a.png, Warsaw, 2016-02-13 13:33:55\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50" | "Warsaw2.png\nWarsaw1.png"

        "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "a.png, Warsaw, 2015-02-13 13:33:50\n" +
                "a.png, Warsaw, 2014-02-13 13:33:50\n" +
                "a.png, Warsaw, 2013-02-13 13:33:50\n" +
                "a.png, Warsaw, 2012-02-13 13:33:50\n" +
                "a.png, Warsaw, 2011-02-13 13:33:50\n" +
                "a.png, Warsaw, 2010-02-13 13:33:50\n" +
                "a.png, Warsaw, 2009-02-13 13:33:50\n" +
                "a.png, Warsaw, 2008-02-13 13:33:50\n" +
                "a.png, Warsaw, 2007-02-13 13:33:50" | "Warsaw10.png\n" +
                "Warsaw09.png\n" +
                "Warsaw08.png\n" +
                "Warsaw07.png\n" +
                "Warsaw06.png\n" +
                "Warsaw05.png\n" +
                "Warsaw04.png\n" +
                "Warsaw03.png\n" +
                "Warsaw02.png\n" +
                "Warsaw01.png"

        "a.png, Radom, 2016-02-13 13:33:50\n" +
                "a.png, Warsaw, 2015-02-13 13:33:50\n" +
                "a.png, Radom, 2014-02-13 13:33:50\n" +
                "a.png, Warsaw, 2013-02-13 13:33:50\n" +
                "a.png, Krakow, 2012-02-13 13:33:50\n" +
                "a.jpg, Warsaw, 2011-02-13 13:33:50" |
                "Radom2.png\n" +
                "Warsaw3.png\n" +
                "Radom1.png\n" +
                "Warsaw2.png\n" +
                "Krakow1.png\n" +
                "Warsaw1.jpg"
    }

    def "parses date"() {
        expect:
        Solution2.Photo.parseDate(S) == result

        where:
        S                     | result
        "2013-09-05 14:18:15" | LocalDateTime.of(2013, 9, 5, 14, 18, 15)
    }

    def "parses photo"() {
        expect:
        Solution2.Photo.fromString(input) == result

        where:
        input                                | result
        "a.png, Warsaw, 2016-02-13 13:33:50" | new Solution2.Photo("png", "Warsaw", LocalDateTime.of(2016, 02, 13, 13, 33, 50), "a.png, Warsaw, 2016-02-13 13:33:50")
    }
}
