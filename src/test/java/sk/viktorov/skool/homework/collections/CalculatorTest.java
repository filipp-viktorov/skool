package sk.viktorov.skool.homework.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    private void assertAddition(double a, double b, double expected) {
        double result = calculator.add(a, b);
        assertEquals(expected, result);
    }

    private void assertSubtraction(double a, double b, double expected) {
        double result = calculator.subtract(a, b);
        assertEquals(expected, result);
    }

    private void assertMultiplication(double a, double b, double expected) {
        double result = calculator.multiply(a, b);
        assertEquals(expected, result);
    }

    private void assertDivision(double a, double b, double expected, boolean isFinite) {
        double result = calculator.divide(a, b);
        if (isFinite) {
            assertEquals(expected, result);
        } else {
            assertTrue(Double.isNaN(result) || Double.isFinite(result));
        }
    }

    /**
     * Tests the addition functionality of the Calculator class.
     */
    @Test
    public void add_whenCalled_addValuesCorrectly() {
        assertAddition(3.0, 2.0, 5.0);
    }

    @Test
    public void add_negativeValues_addValuesCorrectly() {
        assertAddition(-3.0, -2.0, -5.0);
    }

    @Test
    public void add_mixedPositiveAndNegativeValues_addValuesCorrectly() {
        assertAddition(5.0, -3.0, 2.0);
    }

    @Test
    public void add_largeNumbers_addValuesCorrectly() {
        double result = calculator.add(Double.MAX_VALUE, Double.MAX_VALUE);
        assertTrue(Double.isInfinite(result));
    }

    /**
     * Tests the subtraction functionality of the Calculator class.
     */
    @Test
    public void subtract_whenCalled_subtractValuesCorrectly() {
        assertSubtraction(5.0, 3.0, 2.0);
    }

    @Test
    public void subtract_negativeValues_subtractValuesCorrectly() {
        assertSubtraction(-3.0, -2.0, -1.0);
    }

    @Test
    public void subtract_mixedPositiveAndNegativeValues_subtractValuesCorrectly() {
        assertSubtraction(5.0, -3.0, 8.0);
    }

    @Test
    public void subtract_zeroAsSecondArgument_subtractValuesCorrectly() {
        assertSubtraction(5.0, 0, 5.0);
    }

    @Test
    public void subtract_largeNumbers_subtractValuesCorrectly() {
        assertSubtraction(Double.MAX_VALUE, Double.MAX_VALUE, 0.0);
    }

    /**
     * Tests the multiplication functionality of the Calculator class.
     */
    @Test
    public void multiply_whenCalled_multiplyValuesCorrectly() {
        assertMultiplication(5.0, 3.0, 15.0);
    }

    @Test
    public void multiply_negativeValues_multiplyValuesCorrectly() {
        assertMultiplication(-3.0, -2.0, 6.0);
    }

    @Test
    public void multiply_mixedPositiveAndNegativeValues_multiplyValuesCorrectly() {
        assertMultiplication(5.0, -3.0, -15.0);
    }

    @Test
    public void multiply_largeNumbers_multiplyValuesCorrectly() {
        double result = calculator.multiply(Double.MAX_VALUE, Double.MAX_VALUE);
        assertTrue(Double.isInfinite(result));
    }

    @Test
    public void multiply_zeroAsSecondArgument_multiplyValuesCorrectly() {
        assertMultiplication(5.0, 0, 0.0);
    }

    /**
     * Tests the division functionality of the Calculator class.
     */
    @Test
    public void divide_whenCalled_divideValuesCorrectly() {
        assertDivision(10.0, 2.0, 5.0, true);
    }

    @Test
    public void divide_negativeValues_divideValuesCorrectly() {
        assertDivision(-10.0, -2.0, 5.0, true);
    }

    @Test
    public void divide_mixedPositiveAndNegativeValues_divideValuesCorrectly() {
        assertDivision(-10.0, 2.0, -5.0, true);
    }

    @Test
    public void divide_largeNumbers_divisionIsFinite() {
        assertDivision(Double.MAX_VALUE, Double.MAX_VALUE, 1.0, true);
    }

    @Test
    public void divide_zeroAsSecondArgument_returnsNaN() {
        assertDivision(5.0, 0.0, Double.NaN, false);
    }
}
