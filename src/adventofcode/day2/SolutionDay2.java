package adventofcode.day2;

import java.util.Arrays;
import java.util.List;

import static adventofcode.utility.AOCUtility.perfomIntcodeProgram;
import static adventofcode.utility.AOCUtility.readFile;

public class SolutionDay2 {
    public static void main(String[] args) {
        var fileName = "resources/day2.txt";
        String input = readFile(fileName).get(0);

        var inputValues = Arrays.asList(input.split(",")).stream().mapToInt(Integer::valueOf).toArray();
        var resultValues = perfomIntcodeProgram(inputValues, 12, 2, 0);
        System.out.println("Solution1 = " + resultValues[0]);

        boolean calculationFinished = false;
        int i, j = 0;
        for (i = 0; i < 200; i++) {
            for (j = 0; j <= i; j++) {
                resultValues = perfomIntcodeProgram(inputValues, i, j, 0);
                if (resultValues[0] == 19690720) {
                    calculationFinished = true;
                }
                if (calculationFinished) break;
            }
            if (calculationFinished) break;
        }

        System.out.println("Solution2 = " + (100*i + j) );

    }
}
