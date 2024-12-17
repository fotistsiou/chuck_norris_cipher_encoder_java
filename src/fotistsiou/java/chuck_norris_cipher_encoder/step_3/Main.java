package fotistsiou.java.chuck_norris_cipher_encoder.step_3;

import java.util.Scanner;

/**
 * Chuck Norris encrypts only with zeros
 * -------------------------------------
 * Description
 * Binary with 0 and 1 is good, but binary with only 0 is even better! This encoding has a name — the Chuck Norris Unary Code.
 * Let's convert our text into a sequence of zeros and spaces!
 * -------------------------------------
 * Objectives
 * The encoding principle is simple. The input message consists of ASCII characters (7-bit). You need to transform the
 * text into the sequence of 0 and 1 and use the Chuck Norris technique. The encoded output message consists of blocks
 * of 0. A block is separated from another block by a space.
 * Two consecutive blocks are used to produce a series of the same value bits (only 1 or0 values):
 *  - First block: it is always 0 or 00. If it is 0, then the series contains 1, if not, it contains 0
 *  - Second block: the number of 0 in this block is the number of bits in the series
 * Let's take a simple example with a message which consists of only one character C. The C symbol in binary is represented
 * as 1000011, so with Chuck Norris technique this gives:
 *  - 0 0 (the first series consists of only a single 1);
 *  - 00 0000 (the second series consists of four 0);
 *  - 0 00 (the third consists of two 1)
 *  - So C is coded as: 0 0 00 0000 0 00
 * Make sure, that an encoding of a single character sequence is not separated. For example, 000 should be encoded as
 * 00 000 and not as 00 0 00 0 00 0 or 00 0 00 00 or 00 00 00 0
 * In this stage, your program should:
 *  1. Read a string from a console. The input contains a single line.
 *  2. Print The result: line, followed by a line with an encoded message.
 */

public class Main {
    public static void main(String[] args) {
        // Read input string
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String input = scanner.nextLine();
        scanner.close();

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
        System.out.println("The result:");
        System.out.println(result);
    }
}
