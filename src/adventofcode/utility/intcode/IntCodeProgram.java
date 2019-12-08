package adventofcode.utility.intcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntCodeProgram {

    private int[] program;
    private int noun;
    private int verb;
    private int input;
    Map<Integer, IOperation> operations = new HashMap<>();

    public IntCodeProgram(int[] program, int noun, int verb, int input) {
        this.program = program;
        this.noun = noun;
        this.verb = verb;
        this.input = input;
        initializeOperations();
    }

    private void initializeOperations() {
        operations.putIfAbsent(1, new AddOperation());
        operations.putIfAbsent(2, new MultiplyOperation());
        operations.putIfAbsent(3, new InputOperation());
        operations.putIfAbsent(4, new OutputOperation());
        operations.putIfAbsent(5, new JumpIfTrueOperation());
        operations.putIfAbsent(6, new JumpIfFalseOperation());
        operations.putIfAbsent(7, new LessThanOperation());
        operations.putIfAbsent(8, new EqualsOperation());
    }

    private int getOpCode(int index) {
        return program[index]%100;
    }

    public void run() {
        program[1] = noun;
        program[2] = verb;
        Integer output;
        for (int instructionPointer = 0; instructionPointer < program.length; ) {
            output = null;
            var opCode = getOpCode(instructionPointer);
            if (opCode == 99)
                break;
            IOperation operation = operations.get(opCode);
            if (operation == null)
            {
                System.out.println("Wrong opcode = " + opCode);
                break;
            }
            output = operation.run(program, instructionPointer, input);
            if (output != null) {
                System.out.println(output);
            }
            instructionPointer = operation.getNewInstructionPointer(instructionPointer);
        }
    }
}
