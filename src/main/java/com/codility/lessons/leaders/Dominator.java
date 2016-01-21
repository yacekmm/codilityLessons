package com.codility.lessons.leaders;

import java.util.Stack;

public class Dominator {

    public int solution(int[] A) {

        int result = -1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            int item = A[i];
            if(stack.isEmpty()){
                stack.push(item);
            }else if( stack.peek() != item){
                stack.pop();
            }else{
                stack.push(item);
            }
        }

        if(stack.isEmpty()){
            return -1;
        }
        int candidate = stack.pop();
        int counter = 0;

        for (int i = 0; i < A.length; i++) {
            if(A[i] == candidate){
                counter++;
                result = i;
            }
        }

        if(counter > A.length / 2){
            return result;
        }else{
            return -1;
        }

    }

}
