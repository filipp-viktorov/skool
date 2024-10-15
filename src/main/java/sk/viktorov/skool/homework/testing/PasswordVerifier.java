package sk.viktorov.skool.homework.testing;

public class PasswordVerifier {
    private static final String SPECIAL_CHARACTERS = "!@.-;\"(){}[]?";

    public boolean hasGoodLength(String password) {
        return password.length() >= 12;
    }

    public boolean hasNoWhiteSpaces(String password) {
        return !password.contains(" ");
    }

    public boolean hasNoRepetitions(String password) {
        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasNumbers(String password) {
        return password.chars().anyMatch(Character::isDigit);
    }

    public boolean hasSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARACTERS.indexOf(c) >= 0) {
                return true;
            }
        }
        return false;
    }
}
