package fotistsiou.java.chuck_norris_cipher_encoder.step_5;

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
}
