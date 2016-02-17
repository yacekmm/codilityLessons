package com.codility.test.lessons.fibonaccinumbers

import com.codility.lessons.fibonaccinumbers.FibFrog
import spock.lang.Specification

class FibFrogSpec extends Specification {
    def "Solution"() {
        expect:
        new FibFrog().solution(A as int[]) == res

        where:
        res |   A
        -1  |   []
        1   |   [1]
//        -1  |   [0]
        3   |   [0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0]
    }

    def "test Fibonacci"(){
        expect:
        new FibFrog().countFibonacci(n) == res

        where:
        n   | res
        0   | 0
        1   | 1
        2   | 1
        3   | 2
        4   | 3
        5   | 5
        6   | 8
        7   | 13
    }

    def "is Fibonacci"(){
        expect:
        new FibFrog().isFibonacci(n) == res

        where:
        res    | n
        true   | 0
        true   | 1
        true   | 1
        true   | 2
        true   | 3
        true   | 5
        true   | 8
        true   | 13
        false  | 4
        false  | 6
        false  | 7
        false  | 9
        false  | 10
        false  | 11
        false  | 12
        false  | 14
    }


}
