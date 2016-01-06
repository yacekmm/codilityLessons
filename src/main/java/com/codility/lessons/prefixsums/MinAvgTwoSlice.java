package com.codility.lessons.prefixsums;

public class MinAvgTwoSlice {

    public int solution(int[] A) {

        int result = -1;
        Float[] minAvgs = new Float[A.length];

        for (int i = 1; i < A.length; i++) {
            A[i] += A[i-1];
        }

        for (int p = 0; p < A.length; p++) {
            for (int q = p + 1; q < A.length; q++) {
                int sum = calculateSum(A, p , q);
                float avg = (float)sum / (float)(q + 1 - p);
                minAvgs[p] = minAvgs[p] == null ? avg : Math.min(avg, minAvgs[p]);
            }
        }

        float minAvg = Float.MAX_VALUE;

        for (int i = 0; i < minAvgs.length-1; i++) {
            if(minAvg > minAvgs[i]){
                minAvg = minAvgs[i];
                result = i;
            }
        }
        return result;
    }

    private int calculateSum(int[] a, int p, int q) {
        if(p == 0){
            return a[q];
        }else{
            return a[q] - a[p-1];
        }
    }
}
