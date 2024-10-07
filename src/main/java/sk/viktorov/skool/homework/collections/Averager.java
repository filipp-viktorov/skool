package sk.viktorov.skool.homework.collections;

import java.util.Scanner;

/**
 * The {@code Averager} class provides functionality to gather 3 numbers
 * from user input and calculate the average of those numbers.
 */
public class Averager {

    private static final int NUMBER_COUNT = 3;

    public double calculateAverage() {
        double[] numbers = getNumbersFromUser();
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / NUMBER_COUNT;
    }

    private double[] getNumbersFromUser() {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[NUMBER_COUNT];
        try {
            for (int i = 0; i < NUMBER_COUNT; i++) {
                while (true) {
                    System.out.print("Enter number " + (i + 1) + ": ");
                    if (scanner.hasNextDouble()) {
                        numbers[i] = scanner.nextDouble();
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.next();
                    }
                }
            }
        } finally {
            scanner.close();
        }
        return numbers;
    }
}
