package sk.viktorov.skool.homework.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordVerifierTest {
    private PasswordVerifier passwordVerifier;

    private static final String PASSWORD_WITHOUT_SPACES = "password1234";
    private static final String PASSWORD_WITH_SPACES = "password 1234";
    private static final String PASSWORD_SHORT = "password";
    private static final String PASSWORD_LONG = "password1234567";
    private static final String PASSWORD_NO_REPETITION = "paswrd1234";
    private static final String PASSWORD_WITH_SPECIAL_CHAR = "password1234!";

    @BeforeEach
    public void setUp() {
        passwordVerifier = new PasswordVerifier();
    }

    /**
     * Tests the `hasGoodLength` method.
     */
    @Test
    public void should_ReturnTrue_When_LengthIs12() {
        assertTrue(passwordVerifier.hasGoodLength(PASSWORD_WITHOUT_SPACES));
    }

    @Test
    public void should_ReturnFalse_When_LengthIsLessThan12() {
        assertFalse(passwordVerifier.hasGoodLength(PASSWORD_SHORT));
    }

    @Test
    public void should_ReturnTrue_When_LengthIsMoreThan12() {
        assertTrue(passwordVerifier.hasGoodLength(PASSWORD_LONG));
    }

    /**
     * Tests the `hasNoWhiteSpaces` method.
     */
    @Test
    public void should_ReturnTrue_When_NoSpaces() {
        assertTrue(passwordVerifier.hasNoWhiteSpaces(PASSWORD_WITHOUT_SPACES));
    }

    @Test
    public void should_ReturnFalse_When_HasSpaces() {
        assertFalse(passwordVerifier.hasNoWhiteSpaces(PASSWORD_WITH_SPACES));
    }

    /**
     * Tests the `hasNoRepetitions` method.
     */
    @Test
    public void should_ReturnTrue_When_NoRepeats() {
        assertTrue(passwordVerifier.hasNoRepetitions(PASSWORD_NO_REPETITION));
    }

    @Test
    public void should_ReturnFalse_When_HasRepeats() {
        assertFalse(passwordVerifier.hasNoRepetitions(PASSWORD_WITHOUT_SPACES));
    }

    /**
     * Tests the `hasNumbers` method.
     */
    @Test
    public void should_ReturnTrue_When_HasNumbers() {
        assertTrue(passwordVerifier.hasNumbers(PASSWORD_WITHOUT_SPACES));
    }

    @Test
    public void should_ReturnFalse_When_NoNumbers() {
        assertFalse(passwordVerifier.hasNumbers(PASSWORD_SHORT));
    }

    /**
     * Tests the `hasSpecialCharacter` method.
     */
    @Test
    public void should_ReturnTrue_When_HasSpecialCharacters() {
        assertTrue(passwordVerifier.hasSpecialCharacter(PASSWORD_WITH_SPECIAL_CHAR));
    }

    @Test
    public void should_ReturnFalse_When_NoSpecialCharacters() {
        assertFalse(passwordVerifier.hasSpecialCharacter(PASSWORD_WITHOUT_SPACES));
    }
}
