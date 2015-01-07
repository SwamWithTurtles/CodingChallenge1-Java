package Support;

import Instructions.Instruction;
import Instructions.InstructionStep;

import java.util.List;

public class InstructionChain {

    private final List<Instruction> instructions;
    private final ProcessDetails processDetails;

    public final boolean shouldTerminate;

    public InstructionChain(List<Instruction> instructions, ProcessDetails processDetails, boolean shouldTerminate) {
        this.instructions = instructions;
        this.processDetails = processDetails;
        this.shouldTerminate = shouldTerminate;
    }

    public InstructionChain nextIteration() {
        InstructionStep instructionStep = instructions.get(processDetails.currentPointer(instructions.size())).instructionStep;

        return instructionStep.processChain(instructions, processDetails);
    }

    @Override
    public String toString() {
        String currentChainValue = "";
        for(Instruction instruction : instructions) {
            currentChainValue = currentChainValue + instruction.key;
        }
        return currentChainValue;
    }

    public int numberOfIterations() {
        return processDetails.numberOfIterations;
    }
}
