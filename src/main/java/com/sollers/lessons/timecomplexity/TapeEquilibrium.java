package com.sollers.lessons.timecomplexity;

public class TapeEquilibrium {

    public int solution(int[] A) {
        int minResult = Integer.MAX_VALUE;

        int[] reverseSum = new int[A.length];
        int[] straightSum = new int[A.length];

        for (int i = A.length -1; i >= 0 ; i--) {
            int followingValue = i==A.length-1 ? 0 : reverseSum[i+1];
            reverseSum[i] = A[i] + followingValue;
        }

        System.out.println("rev: " + reverseSum);

        for (int i = 0; i < A.length; i++) {
            int prevValue = i==0 ? 0 : straightSum[i-1];
            straightSum[i] = A[i] + prevValue;

            if(i != 0 && i != A.length - 1) {
                minResult = Math.min(minResult, countDifference(straightSum, reverseSum, i));
            }
        }
        System.out.println("straight: " + straightSum);

        return minResult;
    }

    private int countDifference(int[] straightSum, int[] reverseSum, int i) {
        return Math.abs(straightSum[i-1] - reverseSum[i]);
    }
}
