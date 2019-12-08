package adventofcode.utility.intcode;

import java.util.ArrayList;
import java.util.List;

public interface IOperation {
    Integer run(int[] program, int index, int input);

    int getNewInstructionPointer(int instructionPointer);
}

