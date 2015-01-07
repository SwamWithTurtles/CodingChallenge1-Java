package Support;

public class Processor {

    private static InstructionFactory instructionFactory = new InstructionFactory();

    public Results runInstructions(String instructionString) {
        InstructionChain instructions = instructionFactory.createInstructionChain(instructionString);

        while(!instructions.shouldTerminate) {
            instructions = instructions.nextIteration();
        }

        return new Results(instructions.toString(), instructions.numberOfIterations());
    }

}
