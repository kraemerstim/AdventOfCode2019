package adventofcode.utility.intcode;

public class MultiplyOperation extends CalculateOperation {

    @Override
    public Integer run(int[] program, int index, int input) {
        int[] parameters = getParameters(program, index);
        program[program[index+PARAMETER_COUNT+1]] = parameters[0] * parameters[1];
        return null;
    }

    public MultiplyOperation() {
    }
}
