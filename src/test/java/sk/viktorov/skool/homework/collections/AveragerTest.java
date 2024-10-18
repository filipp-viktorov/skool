package sk.viktorov.skool.homework.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

public class AveragerTest {
    private static final double[] VALID_INPUTS = {1.0, 2.0, 3.0};
    private static final double[] ZERO_INPUTS = {0.0, 0.0, 0.0};
    private static final double EXPECTED_AVERAGE_ZERO_INPUTS = 0.0;
    private static final double EXPECTED_AVERAGE_VALID_INPUTS = Arrays.stream(VALID_INPUTS).sum() / VALID_INPUTS.length;

    @Test
    public void should_ReturnCorrectAverage_When_InputsAreValid() {
        testCalculateAverage(VALID_INPUTS, EXPECTED_AVERAGE_VALID_INPUTS);
    }

    @Test
    public void should_ReturnZero_When_InputsAreZero() {
        testCalculateAverage(ZERO_INPUTS, EXPECTED_AVERAGE_ZERO_INPUTS);
    }

    private void testCalculateAverage(double[] inputs, double expected) {
        setSystemIn(inputs);
        Averager averager = new Averager();
        double actual = averager.calculateAverage();
        Assertions.assertEquals(expected, actual);
    }

    private void setSystemIn(double... inputs) {
        String data = String.join("\n", Arrays.stream(inputs).mapToObj(String::valueOf).toArray(String[]::new));
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }
}
