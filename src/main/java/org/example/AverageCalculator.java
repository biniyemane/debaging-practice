package org.example;

public class AverageCalculator {

    public static double calculateAverage(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.length;
    }

    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4, 5};
        double average = calculateAverage(testArray);
        System.out.println("Average: " + average); // Should print: Average: 3.0
        double averageError = calculateAverageError(testArray);
        System.out.println("Average: " + averageError);
        double averageLogicError = calculateAverageLogicError(testArray);
        System.out.println("Average: " + averageLogicError);
    }

    /**
     * Modify the loop in calculateAverage to access an invalid index:
     * breaking point at line 36 and step over to get the error
     * sum = 15, i=5, numbers[i] = java.lang.IndexOutOfBoundException: Invalid array: 5 to 5
     * to fix this I have to change the loop to i < numbers.length.
     */
    public static double calculateAverageError(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) { // This will throw ArrayIndexOutOfBoundsException
            sum += numbers[i];
        }
        return (double) sum / numbers.length;
    }

    /**
     * Introducing a Logic Error
     * introduce a logic error by modifying the loop so it incorrectly calculates the sum:
     *Set a breakpoint at the start of the loop.
     * Step through each iteration to observe the values of sum and numbers[i].
     * Notice that each numbers[i] is being multiplied by 2.
     * Fix the logic error by removing the multiplication:
     */
    public static double calculateAverageLogicError(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i] * 2; //this will incorrectly calculate the sum
            System.out.println("Sum after adding " + numbers[i] + ": " + sum);//debuging using println
        }
        return (double) sum / numbers.length;
    }

}

