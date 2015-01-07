package Instructions;

import Support.InstructionChain;
import Support.ProcessDetails;

import java.util.ArrayList;
import java.util.List;

public class DecrementInstructionStep implements InstructionStep {
    @Override
    public InstructionChain processChain(List<Instruction> instructions, ProcessDetails processDetails) {
        return new InstructionChain(newInstructions(instructions, processDetails.previousPointer(instructions.size())), processDetails.incrementDetails(), false);
    }

    private List<Instruction> newInstructions(List<Instruction> instructions, int itemIndex) {
        List<Instruction> newInstructions = new ArrayList<Instruction>();
        for (int i = 0; i < instructions.size(); i++) {
            if(i == itemIndex) {
                newInstructions.add(instructions.get(i).decrement());
            } else {
                newInstructions.add(instructions.get(i));
            }
        }
        return newInstructions;
    }
}
