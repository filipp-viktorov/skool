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
    public void testHasGoodLength_True_WhenLengthIs12() {
        assertTrue(passwordVerifier.hasGoodLength(PASSWORD_WITHOUT_SPACES));
    }

    @Test
    public void testHasGoodLength_False_WhenLengthIsLessThan12() {
        assertFalse(passwordVerifier.hasGoodLength(PASSWORD_SHORT));
    }

    @Test
    public void testHasGoodLength_True_WhenLengthIsMoreThan12() {
        assertTrue(passwordVerifier.hasGoodLength(PASSWORD_LONG));
    }

    /**
     * Tests the `hasNoWhiteSpaces` method.
     */
    @Test
    public void testHasNoWhiteSpaces_True_WhenNoSpaces() {
        assertTrue(passwordVerifier.hasNoWhiteSpaces(PASSWORD_WITHOUT_SPACES));
    }

    @Test
    public void testHasNoWhiteSpaces_False_WhenHasSpaces() {
        assertFalse(passwordVerifier.hasNoWhiteSpaces(PASSWORD_WITH_SPACES));
    }

    /**
     * Tests the `hasNoRepetitions` method.
     */
    @Test
    public void testHasNoRepetitions_True_WhenNoRepeats() {
        assertTrue(passwordVerifier.hasNoRepetitions(PASSWORD_NO_REPETITION));
    }

    @Test
    public void testHasNoRepetitions_False_WhenHasRepeats() {
        assertFalse(passwordVerifier.hasNoRepetitions(PASSWORD_WITHOUT_SPACES));
    }

    /**
     * Tests the `hasNumbers` method.
     */
    @Test
    public void testHasNumbers_True_WhenHasNumbers() {
        assertTrue(passwordVerifier.hasNumbers(PASSWORD_WITHOUT_SPACES));
    }

    @Test
    public void testHasNumbers_False_WhenNoNumbers() {
        assertFalse(passwordVerifier.hasNumbers(PASSWORD_SHORT));
    }

    /**
     * Tests the `hasSpecialCharacter` method.
     */
    @Test
    public void testHasSpecialCharacter_True_WhenHasSpecialCharacters() {
        assertTrue(passwordVerifier.hasSpecialCharacter(PASSWORD_WITH_SPECIAL_CHAR));
    }

    @Test
    public void testHasSpecialCharacter_False_WhenNoSpecialCharacters() {
        assertFalse(passwordVerifier.hasSpecialCharacter(PASSWORD_WITHOUT_SPACES));
    }
}