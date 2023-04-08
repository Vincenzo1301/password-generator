package hm.edu.vauricch;

import hm.edu.vauricch.generator.PasswordGenerator;

public class Application {

    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new IllegalArgumentException("Invalid number of arguments. Usage: java PasswordGenerator <password_length> <allow_special_chars>");
            }

            int passwordLength = Integer.parseInt(args[0]);
            boolean allowSpecialChars = Boolean.parseBoolean(args[1]);

            if (passwordLength <= 0) {
                throw new IllegalArgumentException("Password length must be a positive integer");
            }

            System.out.println(new PasswordGenerator().generateSecureRandomPassword(passwordLength, allowSpecialChars));
        } catch (NumberFormatException e) {
            System.err.println("Invalid password length specified: " + args[0]);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}