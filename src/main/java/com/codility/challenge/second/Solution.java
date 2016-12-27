package com.codility.challenge.second;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Solution {

    public int solution(int N, String S) {
        HashSet<String> seatsSet = splitSeats(S);
        int result = 0;

        for (int i = 1; i <= N; i++) {
            result += familiesForLeftColumn(i, seatsSet);
            result += familiesForRightColumn(i, seatsSet);
            result += familiesForMiddleColumn(i, seatsSet);
        }

        return result;
    }

    private int familiesForMiddleColumn(int row, HashSet<String> seatsSet) {
        if(seatsSet.contains(row + "E") || seatsSet.contains(row + "F") || (seatsSet.contains(row + "D") && seatsSet.contains(row + "G"))){
            return 0;
        }else {
            return 1;
        }
    }

    private int familiesForLeftColumn(int row, HashSet<String> seatsSet) {
        return familiesIn3SeatsColumn(row, seatsSet, "A", "B", "C");
    }


    private int familiesForRightColumn(int row, HashSet<String> seatsSet) {
        return familiesIn3SeatsColumn(row, seatsSet, "H", "J", "K");
    }

    private int familiesIn3SeatsColumn(int row, HashSet<String> seatsSet, String col1, String col2, String col3) {
        if(seatsSet.contains(row + col1)
                || seatsSet.contains(row + col2)
                || seatsSet.contains(row + col3)){
            return 0;
        }else {
            return 1;
        }
    }

    public HashSet<String> splitSeats(String S){
        return Arrays.stream(S.split(" "))
                .map(s -> s.toUpperCase())
                .collect(Collectors.toCollection(HashSet::new));
    }
}
