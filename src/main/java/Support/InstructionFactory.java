package Support;

import Instructions.*;

import java.util.ArrayList;
import java.util.List;

public class InstructionFactory {

    public InstructionChain createInstructionChain(String keys) {
        List<Instruction> instructions = new ArrayList<Instruction>();
        for(Character key : keys.toCharArray()) {
            instructions.add(createInstructionForKey(key));
        }

        return new InstructionChain(instructions, ProcessDetails.DefaultDetails(), false);
    }

    private Instruction createInstructionForKey(Character key) {
        return Instruction.getInstructionForKey(Integer.parseInt(key.toString()));
    }

}
