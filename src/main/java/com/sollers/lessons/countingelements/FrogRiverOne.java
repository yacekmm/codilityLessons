package com.sollers.lessons.countingelements;

/*

Find the earliest time when a frog can jump to the other side of a river.

A small frog wants to get to the other side of a river. The frog is currently located at position 0, and wants to get to position X. Leaves fall from a tree onto the surface of the river.

You are given a non-empty zero-indexed array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.

The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X. You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.

For example, you are given integer X = 5 and array A such that:
  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4

In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.

Write a function:

    class Solution { public int solution(int X, int[] A); }

that, given a non-empty zero-indexed array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.

If the frog is never able to jump to the other side of the river, the function should return −1.

For example, given X = 5 and array A such that:
  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4

the function should return 6, as explained above.

Assume that:

        N and X are integers within the range [1..100,000];
        each element of array A is an integer within the range [1..X].

Complexity:

        expected worst-case time complexity is O(N);
        expected worst-case space complexity is O(X), beyond input storage (not counting the storage required for input arguments).

Elements of input arrays can be modified.

 */
public class FrogRiverOne {

    public int solution(int X, int[] A) {

        Integer[] earliestTimesForPositions = new Integer[X];

        for (int time = 0; time < A.length; time++) {
            int position = A[time];
            if (position <= X) {
                Integer currentTime = earliestTimesForPositions[position - 1];
                if (currentTime == null || time < currentTime) {
                    earliestTimesForPositions[position - 1] = time;
                }
            }
        }

        for (int i = 0; i < earliestTimesForPositions.length; i++) {
            if (earliestTimesForPositions[i] == null && i < X) {
                return -1;
            }
        }

        return earliestTimesForPositions[X - 1];
    }
}
