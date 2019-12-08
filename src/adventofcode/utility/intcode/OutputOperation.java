package adventofcode.utility.intcode;

import java.util.ArrayList;
import java.util.List;

public class OutputOperation implements IOperation {

    private int getParameter(int[] program, int index) {
        int mode = (program[index] / 100) % 10;
        int parameter;
        switch (mode) {
            case 0:
                parameter = program[program[index + 1]];
                break;
            default:
                parameter = program[index + 1];
                break;
        }
        return parameter;
    }

    @Override
    public Integer run(int[] program, int index, int input) {
        return getParameter(program, index);
    }

    @Override
    public int getNewInstructionPointer(int instructionPointer) {
        return instructionPointer + 2;
    }
}
