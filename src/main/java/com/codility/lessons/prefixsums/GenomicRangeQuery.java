package com.codility.lessons.prefixsums;

public class GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];
        int[] sequence = buildIntSequence(S.toCharArray());

        for (int i = 0; i < P.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = P[i]; j <= Q[i]; j++) {
                min = Math.min(sequence[j], min);
                result[i] = min;
            }
        }

        return result;
    }

    private int[] buildIntSequence(char[] charArray) {
        int[] result = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == 'A'){
                result[i] = 1;
            }else if(charArray[i] == 'C'){
                result[i] = 2;
            } else if(charArray[i] == 'G'){
                result[i] = 3;
            } else if(charArray[i] == 'T'){
                result[i] = 4;
            }
        }

        return result;
    }
}
