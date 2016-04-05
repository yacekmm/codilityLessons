package com.codility.challenge;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class DwarfsRafting {

    private static final int IMPOSSIBLE_RESULT = -1;
    private static final String POSITIONS_SEPARATOR = "\\s";
    private static final List<String> alphabet =
            Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                    "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

    public int solution(int N, String S, String T){

        String[] barrelsPositions = S.split(POSITIONS_SEPARATOR);
        String[] dwarfsPositions = T.split(POSITIONS_SEPARATOR);

        int freeSitsInLeftFront = getFreeSitsCount(1, N/2, 1, N/2, barrelsPositions, dwarfsPositions);
        int dwarfsCountInLeftFront = getDwarfsCount(1, N/2, 1, N/2, dwarfsPositions);

        return IMPOSSIBLE_RESULT;
    }

    public int getDwarfsCount(int rowStart, int rowEnd, int colStart, int colEnd, String[] dwarfsPositions) {
        int result = 0;

        for (String pos: dwarfsPositions) {
            if(pos.length() == 0){
                return result;
            }
            Point pointPos = getIntPosition(pos);   //TODO: optimize
            if(pointPos.getX() >= rowStart
                    && pointPos.getX() <= rowEnd
                    && pointPos.getY() >= colStart
                    && pointPos.getY() <= colEnd){
                result++;
            }
        }
        return result;
    }

    private int getFreeSitsCount(int rowStart, int rowEnd, int colStart, int colEnd, String[] barrelsPositions, String[] dwarfsPositions) {
        return 0;
    }

    public Point getIntPosition(String stringPosition){
        String row = stringPosition.substring(0, stringPosition.length() - 1);
        String col = stringPosition.substring(stringPosition.length() - 1, stringPosition.length());

        return new Point(Integer.parseInt(row), alphabet.indexOf(col) + 1);
    }
}
