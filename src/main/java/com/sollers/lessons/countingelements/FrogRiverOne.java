package com.sollers.lessons.countingelements;

public class FrogRiverOne {

    public int solution(int X, int[] A){

        Integer[] positionsFilled = new Integer[X+1];

        for (int i = 0; i < A.length; i++) {
            Integer positionToFill = positionsFilled[A[i]];
            if((positionToFill == null || i < positionToFill) && A[i] <= X) {
                System.out.println("filling: positionsFilled[" + A[i] + "] = " + i);
                positionsFilled[A[i]] = i;
            }
        }

        for (int i = 1; i < positionsFilled.length; i++) {
            if(positionsFilled[i] == null && i < X){
                return -1;
            }
        }
        return positionsFilled[X];
    }
}
