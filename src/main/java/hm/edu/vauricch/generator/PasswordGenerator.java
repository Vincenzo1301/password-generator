package hm.edu.vauricch.generator;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

public class PasswordGenerator {

    private Stream<Character> getRandomNumbers() {
        final Random random = new SecureRandom();
        final IntStream numbers = random.ints(12, 48, 58);
        return numbers.mapToObj(data -> (char) data);
    }

    private Stream<Character> getRandomAlphabets(int count, boolean upperCase) {
        final Random random = new SecureRandom();
        int start = upperCase ? 65 : 97;
        final IntStream alphabets = random.ints(count, start, start + 26);
        return alphabets.mapToObj(data -> (char) data);
    }

    private Stream<Character> getRandomSpecialChars() {
        final Random random = new SecureRandom();
        final IntStream specialChars = random.ints(12, 33, 45);
        return specialChars.mapToObj(data -> (char) data);
    }

    /**
     * Generates a secure random password with the specified length and inclusion of special characters.
     *
     * @param length The length of the password to generate.
     * @param specialCharsAllowed true if special characters should be included, false otherwise.
     * @return The generated secure random password
     * @throws IllegalArgumentException if the specified length is less than the required length.
     */
    public String generateSecureRandomPassword(int length, boolean specialCharsAllowed) {
        int numCount = 2;
        int alphaCount = 6;
        int specialCount = 0;

        if (specialCharsAllowed) {
            specialCount = 2;
        }

        int remainingCount = length - (numCount + alphaCount + specialCount);

        if (remainingCount < 0) {
            throw new IllegalArgumentException("Password length must be at least " + (numCount + alphaCount + specialCount));
        }

        final Stream<Character> pwdStream = concat(
                getRandomNumbers().limit(numCount),
                concat(getRandomSpecialChars().limit(specialCount),
                        concat(getRandomAlphabets(alphaCount, true), getRandomAlphabets(remainingCount, false))));

        final List<Character> charList = pwdStream.collect(Collectors.toList());

        Collections.shuffle(charList);

        return charList.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
