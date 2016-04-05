package com.codility.test.challenge

import com.codility.challenge.DwarfsRafting
import spock.lang.Specification

class DwarfsRaftingSpec extends Specification {
    def "test solution"() {
        expect:
        new DwarfsRafting().solution() == result

        where:
        result  |

    }
}
