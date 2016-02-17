package com.codility.lessons.fibonaccinumbers;

public class FibFrog {

    public int solution(int[] A){
        int result = 0;
        int distanceToPrevious = 0;
        int currentPosition = -1;

        if(A.length == 0){
            return -1;
        }

        for (int i = 0; i < A.length; i++) {
            distanceToPrevious++;
            if(A[i] == 1){
                if(isFibonacci(distanceToPrevious)){
                    currentPosition = i;
                    distanceToPrevious = 0;
                    result++;
                }else{
                    continue;
                }
            }
        }

        return result;
    }

    public boolean isFibonacci(long number) {
        int n = 0;
        while(true){
            long fibonacci = countFibonacci(n);
            if(number == fibonacci){
                return true;
            }else if(fibonacci > number){
                return false;
            }
            n++;
        }
    }

    public long countFibonacci(int n){
        double a, b, c;

        a = Math.pow( (1.0 + Math.sqrt(5d)) / 2d, n);
        b = Math.pow( (1.0 - Math.sqrt(5d)) / 2d, n);

        return Math.round((a - b) / Math.sqrt(5d));
    }
}

//0 1 1 2 3 5 8 13 21 34