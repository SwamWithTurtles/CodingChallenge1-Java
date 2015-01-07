package Support;

/**
 * Created by DAS on 31/12/2014.
 */
public class ProcessDetails {

    private final int currentProcessPointer;
    private final int previousProcessPointer;
    private final int processIncrement;

    public final int numberOfIterations;

    public ProcessDetails(int currentProcessPointer, int previousProcessPointer, int processIncrement, int numberOfIterations) {
        this.currentProcessPointer = currentProcessPointer;
        this.previousProcessPointer = previousProcessPointer;
        this.processIncrement = processIncrement;
        this.numberOfIterations = numberOfIterations;
    }

    public static ProcessDetails DefaultDetails() {
        return new ProcessDetails(0, 0, 1, 0);
    }

    public ProcessDetails incrementDetails() {
        return new ProcessDetails(currentProcessPointer + processIncrement, currentProcessPointer, processIncrement, numberOfIterations + 1);
    }

    public int currentPointer(int size) {
        return wrappedPointerPosition(currentProcessPointer, size);
    }

    public int previousPointer(int size) {
        return wrappedPointerPosition(previousProcessPointer, size);
    }

    public ProcessDetails reverseDirection() {
        return new ProcessDetails(currentProcessPointer, previousProcessPointer, - processIncrement, numberOfIterations);
    }

    private int wrappedPointerPosition(int position, int size) {
        return (position + size) % size;
    }
}
