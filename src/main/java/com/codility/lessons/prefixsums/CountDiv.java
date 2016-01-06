package com.codility.lessons.prefixsums;

public class CountDiv {

    public int solution(int A, int B, int K) {

        int result;

        if( K >= A && K <= B ) {
            result = (K - A) / K;
            result += (B - K) / K;
            result += 1;
        } else {
            result = (B - A + 1) / K;
        }

        return result;
    }
}
