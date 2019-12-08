package adventofcode.utility.intcode;

public class EqualsOperation extends CalculateOperation {
    private int jumpToAddress;

    @Override
    public Integer run(int[] program, int index, int input) {
        int[] parameters = getParameters(program, index);
        int addressToWrite = program[index + PARAMETER_COUNT + 1];
        program[addressToWrite] = (parameters[0] == parameters[1]) ? 1 : 0;
        return null;
    }

    @Override
    public int getNewInstructionPointer(int instructionPointer) {
        return instructionPointer + PARAMETER_COUNT + 2;
    }

    public EqualsOperation() {

    }
}
