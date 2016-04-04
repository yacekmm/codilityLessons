package com.codility.lessons.array;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {

        int[] result = new int[A.length];

        for(int i=0; i < A.length; i++){
            int indexToOverwrite = (i + K) % A.length;
            result[indexToOverwrite] = A[i];
        }

        return result;
    }
}
