package fotistsiou.java.chuck_norris_cipher_encoder.step_2;

import java.util.Scanner;

/**
 * The binary world
 * ----------------
 * Description
 * In this stage, you'll learn how to convert each character of a string into a binary form. Any ASCII character has a
 * size of 7 bits; in binary, the form is 0 and 1. For example, the character A has a decimal value of 65. The binary
 * representation is 1000001. b is 98 in decimal or 1100010 in binary. The space character is 32 in decimal value or
 * 0100000 in binary.
 * In this stage, you will learn to represent characters in binary form.
 * ----------------
 * Objectives
 * In this stage, your program should:
 *  1. Read a string from a console. The input contains a single line.
 *  2. Print The result: line, followed by each character of input on a separate line, formatted as <char> = <binary value>.
 * Note that the binary representation must be 7-bit, even if the first digits are zeros. The Integer.toBinaryString()
 * and String.format() methods can help you with that.
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        char[] characters = scanner.nextLine().toCharArray();
        scanner.close();

        System.out.println("The result:");
        for (char character : characters) {
            String binaryChar = Integer.toBinaryString(character);
            System.out.printf(
                "%c = %07d%n",
                character,
                Integer.parseInt(binaryChar)
            );
        }
    }
}
