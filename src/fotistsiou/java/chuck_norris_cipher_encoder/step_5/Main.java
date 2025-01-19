package fotistsiou.java.chuck_norris_cipher_encoder.step_5;

import java.util.Scanner;

/**
 * Cooler than Chuck Norris
 * ------------------------
 * Description
 * Let's finish our encryption-decryption software by adding a simple user interface. The program asks the user for the
 * desired option (encode/decode/exit), performs it, and all that in a loop until the user wants to finish.
 * ------------------------
 * Objectives
 * In this stage, your program should:
 *  1. Ask users what they want to do, encode a string, decode a string or quit the program with
 *     "Please input operation (encode/decode/exit):"
 *  2. If user inputs "encode" as the desired operation, the program should print Input string: to the output, read a line
 *     and output two lines — "Encoded string:" followed by the encoded string;
 *  3. If user inputs "decode" as the desired operation, the program should print Input encoded string: to the output,
 *     read a line and output two lines — "Decoded string:" followed by the actual decoded string;
 *  4. If user inputs "exit" as the desired operation, the program should say "Bye!" and finish its execution.
 * The program should be looped to terminate only if the user inputs exit as an operation. Otherwise, it should continue
 * asking users Please input operation (encode/decode/exit): after each iteration.
 * Also, let's prevent some incorrect input.
 *  1. If the user misspells the operation name, the program should print out "There is no '<input>' operation"
 *  2. If the user provided an incorrect encoded message as input to decode, the program should print out appropriate
 *  feedback containing "not valid" substring
 * List of not valid encoded messages:
 *  - The encoded message includes characters other than 0 or spaces;
 *  - The first block of each sequence is not 0 or 00;
 *  - The number of blocks is odd;
 *  - The length of the decoded binary string is not a multiple of 7.
 */

public class Main {
    public static void main(String[] args) {
        // Read input string
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Please input operation (encode/decode/exit):");
            String operation = scanner.nextLine();
            switch (operation) {
                case "encode":
                    System.out.println("Input string:");
                    String encode = scanner.nextLine();
                    Main.encodeChuckNorrisCipher(encode);

                    break;
                case "decode":
                    System.out.println("Input encoded string:");
                    String decode = scanner.nextLine();
                    boolean valid = Main.checkEncodedInput(decode);
                    if (valid) {
                        Main.decodeChuckNorrisCipher(decode);
                    } else {
                        System.out.println("Encoded string is not valid.");
                    }
                    break;
                case "exit":
                    System.out.println("Bye!");
                    exit = true;
                    break;
                default:
                    System.out.println("There is no '" + operation + "' operation");
            }
        }

        scanner.close();
    }

    public static void encodeChuckNorrisCipher(String input) {
        // Initialize result string
        StringBuilder result = new StringBuilder();

        // Convert input string to binary representation (7-bit ASCII)
        StringBuilder binaryString = new StringBuilder();
        for (char character : input.toCharArray()) {
            // Convert character to binary string
            String binaryStringCharacter = Integer.toBinaryString(character);
            // Convert binary string to 7-bit binary string
            binaryStringCharacter = String.format("%07d", Integer.parseInt(binaryStringCharacter));
            // Append 7-bit binary string to binary string
            binaryString.append(binaryStringCharacter);
        }

        // Process binary string to generate Chuck Norris Unary Code
        int i = 0;
        while (i < binaryString.length()) {
            // Get current bit from binary string
            char currentBit = binaryString.charAt(i);

            // Count consecutive bits
            int count = 0;
            while (i < binaryString.length() && binaryString.charAt(i) == currentBit) {
                count++;
                i++;
            }

            // Append block header: 0 for '1', 00 for '0'
            result.append(currentBit == '1' ? "0 " : "00 ");

            // Append number of zeros for the count
            result.append("0".repeat(count));

            // Add space between blocks if more characters remain
            if (i < binaryString.length()) {
                result.append(" ");
            }
        }

        // Output result
        System.out.println("Encoded string:");
        System.out.println(result);
    }

    public static void decodeChuckNorrisCipher(String input) {
        // Initialize StringBuilder for the binary result
        StringBuilder binaryResult = new StringBuilder();

        // Split the input into binary chunks
        String[] binaries = input.split(" ");

        // Process the input pairs
        for (int i = 0; i < binaries.length; i += 2) {
            String binaryBit = binaries[i].equals("0") ? "1" : "0"; // Toggle bit
            int repeatCount = binaries[i + 1].length();             // Count of repeats

            // Append toggled bit repeated 'repeatCount' times
            binaryResult.append(binaryBit.repeat(repeatCount));
        }

        // Split the binary result into 7-bit chunks
        // Regex: (?<=\\G.{7})
        // 1. (?<=...): A lookbehind assertion that ensures the split occurs after a match of the preceding pattern.
        // 2. \\G: Matches the end of the last match or the start of the string for the first match.
        // 3. .{7}: Matches exactly 7 characters.
        String[] characters = binaryResult.toString().split("(?<=\\G.{7})");

        // Convert each 7-bit chunk to a character and print it
        System.out.println("Decoded string:");
        for (String character : characters) {
            // Converting a binary string to a base-2 (decimal) number.
            int numChar = Integer.parseInt(character, 2);
            // Convert a base-2 (decimal) number to a character.
            System.out.print((char) numChar);
        }
        System.out.println();
    }

    public static boolean checkEncodedInput(String input) {
        // Check if the input includes characters other than 0 or spaces
        if (!input.matches("[0 ]+")) {
            return false;
        }

        String[] binaries = input.split(" ");

        // Check if the number of input blocks is odd
        if (binaries.length % 2 != 0) {
            return false;
        }

        int lengthOfDecodedBinaryString = 0;

        for (int i = 0; i < binaries.length; i += 2) {
            // Check if the first block in each pair is "0" or "00"
            if (!binaries[i].equals("0") && !binaries[i].equals("00")) {
                return false;
            }
            lengthOfDecodedBinaryString += binaries[i + 1].length();
        }

        // Check if the length of the decoded binary string is a multiple of 7.
        if (lengthOfDecodedBinaryString % 7 != 0) {
            return false;
        }

        return true;
    }
}
