package com.sollers;

public class Task {
    public int run(int i, int j) {
        return i+j;
    }

    public int solution(int X, int Y, int[] A) {
        int N = A.length;
        int result = -1;
        int nX = 0;
        int nY = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == X)
                nX += 1;
            else if (A[i] == Y)
                nY += 1;
            if (nX == nY && nX!=0)
                result = i;
        }
        return result;
    }

    public int s2(int[][] A) {
        int result = 0;



        return result;
    }
}
