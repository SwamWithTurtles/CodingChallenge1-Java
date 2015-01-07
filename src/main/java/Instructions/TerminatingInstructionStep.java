package Instructions;

import Support.InstructionChain;
import Support.ProcessDetails;

import java.util.List;

public class TerminatingInstructionStep implements InstructionStep {
    @Override
    public InstructionChain processChain(List<Instruction> instructions, ProcessDetails processDetails) {
        return new InstructionChain(instructions, processDetails, true);
    }
}
