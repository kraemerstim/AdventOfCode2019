package adventofcode.utility;

import adventofcode.utility.intcode.IntCodeProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class AOCUtility {

    public static ArrayList<String> readFile(String fileName) {
        var lines = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(
                new FileReader(fileName, StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static int[] perfomIntcodeProgram(int[] programInput, int noun, int verb, int input) {
        int[] cloneValues = programInput.clone();
        IntCodeProgram program = new IntCodeProgram(cloneValues, noun, verb, input);
        program.run();
        return cloneValues;
    }
}
