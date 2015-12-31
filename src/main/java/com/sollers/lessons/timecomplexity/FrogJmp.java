package com.sollers.lessons.timecomplexity;

public class FrogJmp {

    public int solution(int X, int Y, int D){

        if ((Y - X) % D == 0){
            return (Y - X) / D;
        }else if(Y != X){
            return (Y - X) / D + 1;
        }

        return 0;
    }
}
