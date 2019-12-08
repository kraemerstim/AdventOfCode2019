package adventofcode.utility.intcode;

public class JumpIfTrueOperation extends CalculateOperation {
    protected static final int PARAMETER_COUNT = 2;

    private int jumpToAddress;

    @Override
    public Integer run(int[] program, int index, int input) {
        int[] parameters = getParameters(program, index);
        jumpToAddress =  (parameters[0] == 0) ? index + PARAMETER_COUNT + 1 : parameters[1];
        return null;
    }

    @Override
    public int getNewInstructionPointer(int instructionPointer) {
        return jumpToAddress;
    }

    public JumpIfTrueOperation() {
        jumpToAddress = -1;
    }
}
