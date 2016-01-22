package com.codility.lessons.leaders;

import java.util.Stack;

/*

 */

public class EquiLeader {

    public int solution(int[] A) {

        Integer leader;
        int counter = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            int item = A[i];
            if (stack.isEmpty()) {
                stack.push(item);
            } else if (stack.peek() != item) {
                stack.pop();
            } else {
                stack.push(item);
            }
        }

        if (stack.isEmpty()) {
            leader = null;
        } else {
            int candidate = stack.pop();

            for (int i = 0; i < A.length; i++) {
                if (A[i] == candidate) {
                    counter++;
                }
            }

            if (counter > A.length / 2) {
                leader = candidate;
            } else {
                leader = null;
            }
        }

        int result = 0;

        if (leader != null) {
            int leftLeadersCount = 0;
            for (int i = 0; i < A.length; i++) {
                int item = A[i];
                if (item == leader) {
                    leftLeadersCount++;
                }

                int rightLeaderCount = counter - leftLeadersCount;

                boolean isLeaderOnLeftSide = leftLeadersCount > (i + 1) / 2;
                boolean isLeaderOnRightSide = rightLeaderCount > (A.length - i - 1) / 2;
                if (isLeaderOnLeftSide && isLeaderOnRightSide) {
                    result++;
                }
            }
        }
        return result;
    }
}
