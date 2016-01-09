package com.codility.lessons.stacksandqueues;

import java.util.Stack;

public class StoneWall {

    public int solution(int[] H){

        Stack<Integer> stack = new Stack<>();
        int recentHeight = -1;
        int result = 0;

        for (int i = 0; i < H.length; i++) {
            int currentHeight = H[i];

            if(recentHeight < 0){
                stack.push(currentHeight);
                recentHeight = currentHeight;
                result++;
            }else if(recentHeight == currentHeight){
                //do nothing
            }else if(currentHeight > recentHeight){
                int blockToPush = currentHeight - recentHeight;
                stack.push(blockToPush);
                recentHeight = currentHeight;
                result++;
            }else if(currentHeight < recentHeight){
                Integer popped = stack.pop();
                if(recentHeight - currentHeight == popped){
                    // ???
                }else if( recentHeight - currentHeight < popped){
//                    stack.push(popped);
//                    stack.push(recentHeight - currentHeight);
                    stack.push(currentHeight);
                    result++;
                }else if(recentHeight - currentHeight > popped){
                    stack.push(currentHeight);
                    result++;
                }
                recentHeight = currentHeight;
            }
            System.out.println("Stack size: " + stack.size());
            System.out.println("result: " + result);
        }
        System.out.println("------\n");
        return result;
    }
}
