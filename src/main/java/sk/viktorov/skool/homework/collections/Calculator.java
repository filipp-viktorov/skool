package sk.viktorov.skool.homework.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Calculator} class provides basic arithmetic operations as addition,
 * subtraction, multiplication, and division. It also records a history of all operations performed.
 */
public class Calculator {
    private List<String> operations;

    public Calculator() {
        this.operations = new ArrayList<>();
    }

    public double add(double a, double b) {
        return calculate(a, b, a + b, "+");
    }

    public double subtract(double a, double b) {
        return calculate(a, b, a - b, "-");
    }

    public double multiply(double a, double b) {
        return calculate(a, b, a * b, "*");
    }

    public double divide(double a, double b) {
        if (b == 0) {
            String operation = a + " / " + b + " = Division by zero error";
            operations.add(operation);
            return Double.NaN;
        }
        return calculate(a, b, a / b, "/");
    }

    private double calculate(double a, double b, double result, String operator) {
        String operation = a + " " + operator + " " + b + " = " + result;
        operations.add(operation);
        return result;
    }

    public void displayOperations() {
        for (String operation : operations) {
            System.out.println(operation);
        }
    }
}
