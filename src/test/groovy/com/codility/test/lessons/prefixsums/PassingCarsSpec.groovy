package com.codility.test.lessons.prefixsums

import com.codility.lessons.prefixsums.PassingCars
import spock.lang.Specification

class PassingCarsSpec extends Specification {

    PassingCars sut = new PassingCars()

    def "test it"(){
        expect:
        sut.solution(A as int[]) == result

        where:
        A               | result
        [1, 0]          | 0             //no pair
        [0, 1]          | 1             //one pair
        [1, 1]          | 0             //no pair
        []              | 0             //empty array
        [1]             | 0             //one item
        [0]             | 0
        [1, 1, 0]       | 0
        [1, 1, 0, 0]    | 0
        [0, 1, 0, 1, 1] | 5             //example
        [0, 1, 0, 1, 0] | 3             //0 in the end
        [0, 1, 0, 0, 0] | 1             //3x0 in the end
        [0, 1_000_000_000, 0, 1] | -1            //poor test knowing the implementation


    }
}
