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

    /**
     * Tests the addition functionality of the Calculator class.
     */
    @Test
    public void should_AddValuesCorrectly_When_Called() {
        assertAddition(3.0, 2.0, 5.0);
    }

    @Test
    public void should_AddValuesCorrectly_When_NegativeValuesProvided() {
        assertAddition(-3.0, -2.0, -5.0);
    }

    @Test
    public void should_AddValuesCorrectly_When_MixedPositiveAndNegativeValuesProvided() {
        assertAddition(5.0, -3.0, 2.0);
    }

    @Test
    public void should_ReturnInfinity_When_AddingLargeNumbers() {
        double result = calculator.add(Double.MAX_VALUE, Double.MAX_VALUE);
        assertTrue(Double.isInfinite(result));
    }

    private void assertAddition(double a, double b, double expected) {
        double result = calculator.add(a, b);
        assertEquals(expected, result);
    }

    /**
     * Tests the subtraction functionality of the Calculator class.
     */
    @Test
    public void should_SubtractValuesCorrectly_When_Called() {
        assertSubtraction(5.0, 3.0, 2.0);
    }

    @Test
    public void should_SubtractValuesCorrectly_When_NegativeValuesProvided() {
        assertSubtraction(-3.0, -2.0, -1.0);
    }

    @Test
    public void should_SubtractValuesCorrectly_When_MixedPositiveAndNegativeValuesProvided() {
        assertSubtraction(5.0, -3.0, 8.0);
    }

    @Test
    public void should_SubtractValuesCorrectly_When_SecondArgumentIsZero() {
        assertSubtraction(5.0, 0, 5.0);
    }

    @Test
    public void should_SubtractValuesCorrectly_When_LargeNumbersProvided() {
        assertSubtraction(Double.MAX_VALUE, Double.MAX_VALUE, 0.0);
    }

    private void assertSubtraction(double a, double b, double expected) {
        double result = calculator.subtract(a, b);
        assertEquals(expected, result);
    }

    /**
     * Tests the multiplication functionality of the Calculator class.
     */
    @Test
    public void should_MultiplyValuesCorrectly_When_Called() {
        assertMultiplication(5.0, 3.0, 15.0);
    }

    @Test
    public void should_MultiplyValuesCorrectly_When_NegativeValuesProvided() {
        assertMultiplication(-3.0, -2.0, 6.0);
    }

    @Test
    public void should_MultiplyValuesCorrectly_When_MixedPositiveAndNegativeValuesProvided() {
        assertMultiplication(5.0, -3.0, -15.0);
    }

    @Test
    public void should_ReturnInfinity_When_MultiplyingLargeNumbers() {
        double result = calculator.multiply(Double.MAX_VALUE, Double.MAX_VALUE);
        assertTrue(Double.isInfinite(result));
    }

    @Test
    public void should_ReturnZero_When_SecondArgumentIsZero() {
        assertMultiplication(5.0, 0, 0.0);
    }

    private void assertMultiplication(double a, double b, double expected) {
        double result = calculator.multiply(a, b);
        assertEquals(expected, result);
    }

    /**
     * Tests the division functionality of the Calculator class.
     */
    @Test
    public void should_DivideValuesCorrectly_When_Called() {
        assertDivision(10.0, 2.0, 5.0, true);
    }

    @Test
    public void should_DivideValuesCorrectly_When_NegativeValuesProvided() {
        assertDivision(-10.0, -2.0, 5.0, true);
    }

    @Test
    public void should_DivideValuesCorrectly_When_MixedPositiveAndNegativeValuesProvided() {
        assertDivision(-10.0, 2.0, -5.0, true);
    }

    @Test
    public void should_ReturnOne_When_DividingLargeNumbers() {
        assertDivision(Double.MAX_VALUE, Double.MAX_VALUE, 1.0, true);
    }

    @Test
    public void should_ReturnNaN_When_SecondArgumentIsZero() {
        assertDivision(5.0, 0.0, Double.NaN, false);
    }

    private void assertDivision(double a, double b, double expected, boolean isFinite) {
        double result = calculator.divide(a, b);
        if (isFinite) {
            assertEquals(expected, result);
        } else {
            assertTrue(Double.isNaN(result) || Double.isFinite(result));
        }
    }
}
