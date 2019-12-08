package adventofcode.utility.intcode;

public class InputOperation implements IOperation {

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
        program[program[index+1]] = input;
        return null;
    }

    @Override
    public int getNewInstructionPointer(int instructionPointer) {
        return instructionPointer + 2;
    }
}
