package adventofcode.day1;

import java.util.List;

import static adventofcode.utility.AOCUtility.readFile;

public class SolutionDay1 {
    public static void main(String[] args){

        var fileName = "resources/day1.txt";
        List<String> input = readFile(fileName);
        var solution = input.stream().mapToInt(Integer::valueOf).map(SolutionDay1::calculateFuelRequirement).sum();
        System.out.println("Solution1 = " + solution);
        solution = input.stream().mapToInt(Integer::valueOf).map(SolutionDay1::convertForSolution2).sum();
        System.out.println("Solution2 = " + solution);

    }

    private static int calculateFuelRequirement(Integer i) {
        return (int) (i / 3.0) - 2;
    }

    private static int convertForSolution2(Integer i) {
        var result = calculateFuelRequirement(i);
        int additional_fuel = result;
        while ((additional_fuel = calculateFuelRequirement(additional_fuel)) > 0) {
            result += additional_fuel;
        }
        return result;
    }
}
