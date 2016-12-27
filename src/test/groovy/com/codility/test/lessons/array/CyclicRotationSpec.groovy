package com.codility.test.lessons.array

import com.codility.lessons.array.CyclicRotation
import spock.lang.Specification

class CyclicRotationSpec extends Specification {
    def "test solution"() {
        expect:
        new CyclicRotation().solution(A as int[], K) == result

        where:
        A           | K     | result
        [1,2,3]     | 0     | [1,2,3]
        [1,2,3]     | 1     | [3,1,2]
        [1,2,3]     | 2     | [2,3,1]
        [1,2,3]     | 3     | [1,2,3]
        [1,2,3]     | 4     | [3,1,2]
        [1]         | 0     | [1]
        [1]         | 1     | [1]
        [1]         | 2     | [1]
        [3,8,9,7,6] | 3     | [9,7,6,3,8]
    }
}
