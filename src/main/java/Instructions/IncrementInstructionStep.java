package Instructions;

import Support.InstructionChain;
import Support.ProcessDetails;

import java.util.ArrayList;
import java.util.List;

public class IncrementInstructionStep implements InstructionStep {
    @Override
    public InstructionChain processChain(List<Instruction> instructions, ProcessDetails processDetails) {
        return new InstructionChain(newInstructions(instructions, processDetails.previousPointer(instructions.size())), processDetails.incrementDetails(), false);
    }

    private List<Instruction> newInstructions(List<Instruction> itemToIncrement, int itemIndex) {
        List<Instruction> newInstructions = new ArrayList<Instruction>();
        for (int i = 0; i < itemToIncrement.size(); i++) {
            if(i == itemIndex) {
                newInstructions.add(itemToIncrement.get(i).increment());
            } else {
                newInstructions.add(itemToIncrement.get(i));
            }
        }
        return newInstructions;
    }
}
