package hm.edu.vauricch.generator;

import hm.edu.vauricch.generator.PasswordGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordGeneratorTest {

    @Test
    void testGenerateSecureRandomPassword() {
        final PasswordGenerator passwordGenerator = new PasswordGenerator();

        String password = passwordGenerator.generateSecureRandomPassword(10, true);

        assertNotNull(password);
        assertEquals(10, password.length());
        assertTrue(password.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+-=\\[\\]{};':\"\\\\|,.<>\\/?]).+$"));
    }

    @Test
    void testGenerateSecureRandomPasswordWithoutSpecialChars() {
        final PasswordGenerator passwordGenerator = new PasswordGenerator();

        final String password = passwordGenerator.generateSecureRandomPassword(8, false);

        assertNotNull(password);
        assertEquals(8, password.length());
        assertTrue(password.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).+$"));
    }

    @Test
    void testGenerateSecureRandomPasswordWithLengthLessThanRequired() {
        final PasswordGenerator passwordGenerator = new PasswordGenerator();

        assertThrows(IllegalArgumentException.class, () -> {
            passwordGenerator.generateSecureRandomPassword(2, true);
        });
    }
}
