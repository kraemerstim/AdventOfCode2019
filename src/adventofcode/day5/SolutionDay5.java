package adventofcode.day5;

import java.util.Arrays;

import static adventofcode.utility.AOCUtility.perfomIntcodeProgram;
import static adventofcode.utility.AOCUtility.readFile;

public class SolutionDay5 {
    public static void main(String[] args) {
        var fileName = "resources/day5.txt";
        String input = readFile(fileName).get(0);

        var inputValues = Arrays.asList(input.split(",")).stream().mapToInt(Integer::valueOf).toArray();
        System.out.println("Solution 1:");
        //perfomIntcodeProgram(inputValues, inputValues[1], inputValues[2], 1);

        System.out.println("Solution 2:");
        perfomIntcodeProgram(inputValues, inputValues[1], inputValues[2], 5);
    }

}
