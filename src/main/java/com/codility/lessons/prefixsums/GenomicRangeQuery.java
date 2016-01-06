package com.codility.lessons.prefixsums;

public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            String subsequence = S.substring(P[i], Q[i]+1);
            if(subsequence.contains("A")){
                result[i] = 1;
            }else if (subsequence.contains("C")){
                result[i] = 2;
            }else if (subsequence.contains("G")){
                result[i] = 3;
            }else if (subsequence.contains("T")){
                result[i] = 4;
            }
        }

        return result;
    }
}
