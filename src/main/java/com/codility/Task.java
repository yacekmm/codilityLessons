package com.codility;

public class Task {
    public int run(int i, int j) {
        return i + j;
    }

    public int s1(int X, int Y, int[] A) {
        int N = A.length;
        int result = -1;
        int nX = 0;
        int nY = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == X)
                nX += 1;
            else if (A[i] == Y)
                nY += 1;
            if (nX == nY && nX != 0)
                result = i;
        }
        return result;
    }

    public int solution(int[][] A) {
        int result = 0;
        int maxResult = 0;
        int N = A.length;
        int M = A[0].length;
        int nIndex = 0;
        int mIndex = 0;

        int[][] arr = cloneArray(A);

        int nSumFirstCol = 0;
        for (int i = 0; i < N; i++) {
            nSumFirstCol += A[i][0];
            logIncrementation(i, 0, A, "External");
            A[i][0] = 0;

            for (int j = 0; j < M; j++) {
                result += nSumFirstCol;
                System.out.println("sum from first col: " + nSumFirstCol);
                if (j != 0) {
                    result += A[i][j];
                    logIncrementation(i, j, A, "Right");
                    A[i][j] = 0;
                }

                for (int k = i; k < N; k++) {
                    result += A[k][j];
                    logIncrementation(k, j, A, "Down");
                    A[k][j] = 0;

                    if(k == N-1) {
                        for (int l = j; l < M; l++) {
                            result += A[k][l];
                            logIncrementation(k, l, A, "Final Right");
                            A[k][l] = 0;
                        }
                        maxResult = Math.max(result, maxResult);
                        System.out.println("RESET with result: " + result + "\n");
                        result = 0;
                        A = cloneArray(arr);
                    }
                }
//                result += solution(buildArrayFromIndex(i, j, A));

            }
        }

        return maxResult;
    }

    private int[][] cloneArray(int[][] matrix){
        int [][] myInt = new int[matrix.length][];
        for(int i = 0; i < matrix.length; i++)
            myInt[i] = matrix[i].clone();

        return myInt;
    }

    private int[][] buildArrayFromIndex(int n, int m, int[][] a) {
        int[][] result = new int[a.length - n][a[0].length - m];

        int newI = 0;
        int newJ = 0;
        for (int i = n; i < a.length; i++) {

            for (int j = m; j < a[0].length; j++) {
                System.out.println("adding elt: " + i + "\t" +  j);
                result[newI][newJ] = a[i][j];
                newJ++;
            }
            newI++;
            newJ = 0;
        }
        System.out.println("input: " + a.length);
        System.out.println("result: " + result.length);
        System.out.println("n: " + n);
        System.out.println("m: " + m);
        return result;
    }

    private void logIncrementation(int i, int j, int[][] a, String tag) {
        System.out.println("adding\t " + i + "\t" + j + "\t[ " + a[i][j] + " ]\t" + tag);
    }

    public int solutionBinaryGap(int N){
        int maxResult = 0;
        int partialResult = 0;
        char ZERO = '0';
        String binaryString = Integer.toBinaryString(N);

        for (char c: binaryString.toCharArray()) {
            if(ZERO == c){
                partialResult ++;
            }else{
                maxResult = Math.max(partialResult, maxResult);
                partialResult = 0;
            }
        }

        return maxResult;
    }
}
