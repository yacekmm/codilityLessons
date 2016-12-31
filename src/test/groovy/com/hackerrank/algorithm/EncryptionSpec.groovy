package com.hackerrank.algorithm

import spock.lang.Specification

class EncryptionSpec extends Specification {
    def "Encrypt returns string"() {
        expect:
        Encryption.encrypt(input) == result

        where:
        input                                                    | result
        "haveaniceday"                                           | "hae and via ecy"
        "feedthedog"                                             | "fto ehg ee dd"
        "chillout"                                               | "clu hlt io"
        "ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots" | "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau"

    }
}
