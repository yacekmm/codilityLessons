package com.codility.challenge;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class DwarfsRafting {

    private static final int IMPOSSIBLE_RESULT = -1;
    private static final String POSITIONS_SEPARATOR = "\\s";

    public int solution(int N, String S, String T){

        String[] barrelsPositions = S.split(POSITIONS_SEPARATOR);
        String[] dwarfsPositions = T.split(POSITIONS_SEPARATOR);
        int boatTotalSize = N * N;

        int firstHalfStart = 1;
        int firstHalfEnd = N / 2;
        int secondHalfStart = N / 2 + 1;
        int secondHalfEnd = N;

        BoatSector leftFront = new BoatSector(firstHalfStart, firstHalfEnd, firstHalfStart, firstHalfEnd, dwarfsPositions, barrelsPositions, boatTotalSize / 4);
        BoatSector rightFront = new BoatSector(firstHalfStart, firstHalfEnd, secondHalfStart, secondHalfEnd, dwarfsPositions, barrelsPositions, boatTotalSize / 4);
        BoatSector leftBack = new BoatSector(secondHalfStart, secondHalfEnd, firstHalfStart, firstHalfEnd, dwarfsPositions, barrelsPositions, boatTotalSize / 4);
        BoatSector rightBack = new BoatSector(secondHalfStart, secondHalfEnd, secondHalfStart, secondHalfEnd, dwarfsPositions, barrelsPositions, boatTotalSize / 4);

        return IMPOSSIBLE_RESULT;
    }

}

class BoatSector{
    private static final List<String> alphabet =
            Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                    "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

    public int dwarfsCount;
    public int barrelsCount;
    public int freeSitsCount;
    private int rowSectorStart;
    private int rowSectorEnd;
    private int colSectorStart;
    private int colSectorEnd;
    private String[] dwarfsPositions;
    private String[] barrelsPositions;
    private int sectorSize;

    public BoatSector() {
    }

    public BoatSector(int rowSectorStart, int rowSectorEnd, int colSectorStart, int colSectorEnd, String[] dwarfsPositions, String[] barrelsPositions, int sectorSize) {
        this.rowSectorStart = rowSectorStart;
        this.rowSectorEnd = rowSectorEnd;
        this.colSectorStart = colSectorStart;
        this.colSectorEnd = colSectorEnd;
        this.dwarfsPositions = dwarfsPositions;
        this.barrelsPositions = barrelsPositions;
        this.sectorSize = sectorSize;

        dwarfsCount = getItemsOnSeatsCount(rowSectorStart, rowSectorEnd, colSectorStart, colSectorEnd, dwarfsPositions);
        barrelsCount = getItemsOnSeatsCount(rowSectorStart, rowSectorEnd, colSectorStart, colSectorEnd, barrelsPositions);
        freeSitsCount = sectorSize - dwarfsCount - barrelsCount;
    }

    public int getItemsOnSeatsCount(int rowStart, int rowEnd, int colStart, int colEnd, String[] dwarfsPositions) {
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

    public Point getIntPosition(String stringPosition){
        String row = stringPosition.substring(0, stringPosition.length() - 1);
        String col = stringPosition.substring(stringPosition.length() - 1, stringPosition.length());

        return new Point(Integer.parseInt(row), alphabet.indexOf(col) + 1);
    }
}
