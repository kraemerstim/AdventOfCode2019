package adventofcode.utility.intcode;

import java.util.ArrayList;
import java.util.List;

abstract class CalculateOperation implements IOperation {
    protected static final int PARAMETER_COUNT = 2;

    int[] getParameters(int[] program, int index) {
        int mode = program[index]/100;
        List<Integer> modes = new ArrayList<>();
        int[] parameters = new int[PARAMETER_COUNT];
        for (int i = 0; i < PARAMETER_COUNT; i++) {
            modes.add(mode%10);
            mode /= 10;
        }
        for (int i = 0; i < modes.size(); i++) {
            switch (modes.get(i)) {
                case 0:
                    parameters[i] = program[program[index + i + 1]];
                    break;
                case 1:
                    parameters[i] = program[index + i + 1];
                    break;
            }
        }
        return parameters;
    }

    @Override
    public int getNewInstructionPointer(int instructionPointer) {
        return instructionPointer + PARAMETER_COUNT + 2;
    }
}
