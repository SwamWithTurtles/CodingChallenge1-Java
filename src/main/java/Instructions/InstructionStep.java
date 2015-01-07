package Instructions;

import Support.InstructionChain;
import Support.ProcessDetails;

import java.util.List;

public interface InstructionStep {
    InstructionChain processChain(List<Instruction> instructions, ProcessDetails processDetails);
}
