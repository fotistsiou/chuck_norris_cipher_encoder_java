package fotistsiou.java.chuck_norris_cipher_encoder.step_1;

import java.util.Scanner;

/**
 * Analyze the words
 * -----------------
 * Description
 * In this task, you will practice parsing an encrypted message by dividing it into individual characters. This skill
 * will be essential for future stages where you will be tasked with decrypting messages.
 * -----------------
 * Objectives
 * Your program should perform the following steps:
 * 1. Read Input:
 *    - Prompt the user with the message: Input string:
 *    - Read a single line of text from the console.
 *    - Assume that the input string will contain alphabetic characters, space characters, and punctuation marks.
 *    - There is no limit on the length of the input string.
 * 2. Process and Output Characters:
 *    - Output all characters in the string, each separated by a single space.
 *    - This includes space characters, which should be represented as they are, without removal or substitution.
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String input = scanner.nextLine();
        System.out.println(String.join(" ", input.split("")));
    }
}
