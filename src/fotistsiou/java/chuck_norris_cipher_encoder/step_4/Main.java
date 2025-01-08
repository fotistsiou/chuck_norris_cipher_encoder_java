package fotistsiou.java.chuck_norris_cipher_encoder.step_4;

import java.util.Scanner;

/**
 * Try to understand it
 * --------------------
 * Description
 * In this stage, you will write a decoder for a cipher. You need to transform the encrypted message into its original format.
 * --------------------
 * Objectives
 * Your program receives a string of zeros and spaces and converts it to readable text. You must parse the string to the
 * blocks of zeroes and decode the message the same way as in previous stages but in reversed order.
 * For example, your program receives 0 0 00 0000 0 000 00 0000 0 00. You can split blocks of zeros and group those
 * blocks by two. Then you need to decode these blocks like in the previous stage:
 *  - 0 0 is 1
 *  - 00 0000 is 0000
 *  - 0 000 is 111
 *  - 00 0000 is 0000
 *  - 0 00 is 11
 * Concatenation of the lines above gives us 10000111000011.
 * After that, you need to split the result into blocks of seven symbols (binary form) and convert these blocks to
 * characters. In this case, splitting 10000111000011 by seven symbols gives us two characters — 1000011 1000011 ,
 * convert them into characters and the result will be CC (C is 1000011).
 * In this stage, your program should:
 *  1. Read a string from a console. The input contains a single line of spaces and 0 characters.
 *  2. Print The result: line, followed by a line with a decoded message.
 * The Integer.parseInt() method might be useful at this stage.
 */

public class Main {
    public static void main(String[] args) {
        // Read input string
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String input = scanner.nextLine();
        scanner.close();

        // Initialize StringBuilder for the binary result
        StringBuilder binaryResult = new StringBuilder();

        // Split the input into binary chunks
        String[] binaries = input.split(" ");

        // Process the input pairs
        for (int i = 0; i < binaries.length; i += 2) {
            String binaryBit = binaries[i].equals("0") ? "1" : "0"; // Toggle bit
            int repeatCount = binaries[i + 1].length(); // Count of repeats

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
        System.out.println("The result:");
        for (String character : characters) {
            // Converting a binary string to a base-2 (decimal) number.
            int numChar = Integer.parseInt(character, 2);
            // Convert a base-2 (decimal) number to a character.
            System.out.print((char) numChar);
        }
    }
}
