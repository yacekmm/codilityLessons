package com.codility.challenge.first;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private static final int IMPOSSIBLE_RESULT = -1;
    private static final String POSITIONS_SEPARATOR = "\\s";
    private BoatSector leftFront, rightFront, leftBack, rightBack;

    public int solution(int N, String S, String T) {

        String[] barrelsPositions = S.split(POSITIONS_SEPARATOR);
        String[] dwarfsPositions = T.split(POSITIONS_SEPARATOR);
        int boatTotalSize = N * N;

        int firstHalfStart = 1;
        int firstHalfEnd = N / 2;
        int secondHalfStart = N / 2 + 1;
        int secondHalfEnd = N;

        leftFront = new BoatSector(firstHalfStart, firstHalfEnd, firstHalfStart, firstHalfEnd, dwarfsPositions, barrelsPositions, boatTotalSize / 4);
        rightFront = new BoatSector(firstHalfStart, firstHalfEnd, secondHalfStart, secondHalfEnd, dwarfsPositions, barrelsPositions, boatTotalSize / 4);
        leftBack = new BoatSector(secondHalfStart, secondHalfEnd, firstHalfStart, firstHalfEnd, dwarfsPositions, barrelsPositions, boatTotalSize / 4);
        rightBack = new BoatSector(secondHalfStart, secondHalfEnd, secondHalfStart, secondHalfEnd, dwarfsPositions, barrelsPositions, boatTotalSize / 4);

        boolean hasFreeSits = leftFront.hasFreeSits() || rightFront.hasFreeSits() || leftBack.hasFreeSits() || rightBack.hasFreeSits();
        boolean dwarfsAreBalanced = leftFront.dwarfsCount == rightFront.dwarfsCount &&
                leftFront.dwarfsCount == leftBack.dwarfsCount &&
                leftFront.dwarfsCount == rightBack.dwarfsCount;

//        boolean dwarfsAreBalanced = leftFront.dwarfsCount + leftBack.dwarfsCount == rightBack.dwarfsCount + rightFront.dwarfsCount &&
//                leftBack.dwarfsCount + rightBack.dwarfsCount == leftFront.dwarfsCount + rightFront.dwarfsCount;

        if (!hasFreeSits) {
            if (dwarfsAreBalanced) {
                return 0;
            } else {
                return IMPOSSIBLE_RESULT;
            }
        }

        int dwarfsAdded = 0;
        boolean running = true;
        while (running) {
            if (dwarfsAreBalanced) {
                if (addDwarf()) {
                    dwarfsAdded += 4;
                } else {
                    return dwarfsAdded;
                }
            } else {
                int balanceDwarfs = balanceDwarfs();
                if (balanceDwarfs > 0) {
                    dwarfsAdded += balanceDwarfs;
                    dwarfsAreBalanced = true;
                } else {
                    return IMPOSSIBLE_RESULT;
                }
            }

        }


        return -10;
    }

    private int balanceDwarfs() {
        int[] counterArray = {leftFront.dwarfsCount, rightFront.dwarfsCount, leftBack.dwarfsCount, rightBack.dwarfsCount};
        Arrays.sort(counterArray);
        int maxCount = counterArray[3];

        int lfAddded = leftFront.addDwarfsToBalance(maxCount);
        int rfAdded = rightFront.addDwarfsToBalance(maxCount);
        int lbAdded = leftBack.addDwarfsToBalance(maxCount);
        int rbAddded = rightBack.addDwarfsToBalance(maxCount);
        if (lfAddded >= 0 &&
                rfAdded >= 0 &&
                lbAdded >= 0 &&
                rbAddded >= 0) {
            return lfAddded + rfAdded + lbAdded + rbAddded;
        } else {
            return -1;
        }

    }

    private boolean addDwarf() {
        return leftFront.addDwarf() && rightFront.addDwarf() && leftBack.addDwarf() && rightBack.addDwarf();
    }

}

class BoatSector {
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

        for (String pos : dwarfsPositions) {
            if (pos.length() == 0) {
                return result;
            }
            Point pointPos = getIntPosition(pos);   //TODO: optimize
            if (pointPos.getX() >= rowStart
                    && pointPos.getX() <= rowEnd
                    && pointPos.getY() >= colStart
                    && pointPos.getY() <= colEnd) {
                result++;
            }
        }
        return result;
    }

    public Point getIntPosition(String stringPosition) {
        String row = stringPosition.substring(0, stringPosition.length() - 1);
        String col = stringPosition.substring(stringPosition.length() - 1, stringPosition.length());

        return new Point(Integer.parseInt(row), alphabet.indexOf(col) + 1);
    }

    public boolean hasFreeSits() {
        return freeSitsCount != 0;
    }

    public boolean addDwarf() {
        if (hasFreeSits()) {
            freeSitsCount--;
            return true;
        } else {
            return false;
        }

    }

    public int addDwarfsToBalance(int expectedCountToReach) {
        int dwarfsToAdd = expectedCountToReach - dwarfsCount;
        if (dwarfsToAdd > freeSitsCount) {
            return -1;
        } else {
            freeSitsCount -= dwarfsToAdd;
            return dwarfsToAdd;
        }
    }
}
