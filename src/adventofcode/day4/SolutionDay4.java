package adventofcode.day4;

import java.util.Arrays;

public class SolutionDay4 {
    public static boolean checkNumber(int number, boolean enhancedDoubleCheck){
        var digets = Arrays.stream(String.valueOf(number).split("")).mapToInt(Integer::valueOf).toArray();
        boolean flawFound = false;
        boolean doubleFound = false;
        int doubleStartIndex = -1;
        for (int j = 0; j < digets.length-1; j++) {
            if (digets[j] > digets[j+1]) {
                flawFound = true;
            }
            if (digets[j] == digets[j+1]) {
                if (doubleStartIndex == -1) {
                    doubleStartIndex = j;
                    if (j == digets.length-2) {
                        doubleFound = true;
                    }
                }
                if (!enhancedDoubleCheck) {
                    doubleFound = true;
                }
            } else {
                if (doubleStartIndex >= 0 && doubleStartIndex == j-1) {
                    doubleFound = true;
                }
                doubleStartIndex = -1;
            }
            if (flawFound) {
                break;
            }
        }
        if (flawFound) {
            return false;
        }
        if (!doubleFound) {
            return false;
        }
        return true;
    }

    public static int getNumberOfPossibleCodes(int start, int end, boolean enhancedDoubleCheck) {

        int numbercounter = 0;

        for (int i = start; i <= end; i++) {
            if (checkNumber(i, enhancedDoubleCheck)) {
                numbercounter++;
            }
        }

        return numbercounter;
    }


    public static void main(String[] args) {
        int start = 146810;
        int end = 612564;


        System.out.println("Solution1 = " + getNumberOfPossibleCodes(start, end, false));
        System.out.println("Solution2 = " + getNumberOfPossibleCodes(start, end, true));
        //System.out.println("Solution2 = " + checkNumber(588899, true));
    }

}
