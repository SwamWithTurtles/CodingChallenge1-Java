package Instructions;

public enum Instruction {
    Terminate (0, new TerminatingInstructionStep()),
    Identity (1, new IdentityInstructionStep()),
    Increment (2, new IncrementInstructionStep()),
    Decrement (3, new DecrementInstructionStep()),
    Reverse (4, new ReversalInstructionStep());

    public final int key;
    public final InstructionStep instructionStep;

    private Instruction(int key, InstructionStep instructionStep) {
        this.key = key;
        this.instructionStep = instructionStep;
    }

    public static Instruction getInstructionForKey(int key) {
        for(Instruction instructions : Instruction.values()) {
            if(instructions.key == key) { return instructions; }
        }
        throw new IllegalArgumentException("Please enter only digits between 1 and 4");
    }

    public Instruction increment() {
        return getInstructionForKey(wrappedInstructionKey(key + 1));
    }

    public Instruction decrement() {
        return getInstructionForKey(wrappedInstructionKey(key - 1));
    }

    private int wrappedInstructionKey(int key) {
        return (key + Instruction.values().length) % Instruction.values().length;
    }

}
