package algorithms.empirical.analysis;

public class ExecutionResult {
    private final int sizeOfArray;
    private final long executionTime1;
    private final long executionTime2;
    private final long executionTime3;
    private final long executionTime4;
    private final long executionTime5;

    private ExecutionResult(int sizeOfArray, long executionTime1, long executionTime2, long executionTime3,
            long executionTime4, long executionTime5) {
        this.sizeOfArray = sizeOfArray;
        this.executionTime1 = executionTime1;
        this.executionTime2 = executionTime2;
        this.executionTime3 = executionTime3;
        this.executionTime4 = executionTime4;
        this.executionTime5 = executionTime5;
    }

    public int getSizeOfArray() {
        return sizeOfArray;
    }

    public long getExecutionTime1() {
        return executionTime1;
    }

    public long getExecutionTime2() {
        return executionTime2;
    }

    public long getExecutionTime3() {
        return executionTime3;
    }

    public long getExecutionTime4() {
        return executionTime4;
    }

    public long getExecutionTime5() {
        return executionTime5;
    }

    public long getAvgExecutionTime() {
        return (executionTime1 + executionTime2 + executionTime3 + executionTime4 + executionTime5) / 5;
    }

    public static ExecutionResult of(int sizeOfArray, long executionTime1, long executionTime2, long executionTime3,
            long executionTime4, long executionTime5) {
        return new ExecutionResult(sizeOfArray, executionTime1, executionTime2, executionTime3, executionTime4, executionTime5);
    }
}
