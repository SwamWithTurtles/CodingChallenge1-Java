import Support.Processor;
import Support.Results;

public class CodingChallengeOne {

    private static Processor instructionProcessor = new Processor();

    public static void main(String[] args) {
        if(args.length != 1) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }

        Results algorithmResult = instructionProcessor.runInstructions(args[0]);

        System.out.println(String.format("Output: %s (%d iterations)", algorithmResult.terminatingString, algorithmResult.numberOfIterations));
    }

}
