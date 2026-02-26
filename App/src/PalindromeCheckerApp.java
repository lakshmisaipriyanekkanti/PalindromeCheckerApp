
/**
 * ============================================================
 * MAIN CLASS – UseCase2PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 2: Hardcoded Palindrome Validation
 *
 * Description:
 * This class demonstrates basic palindrome validation
 * using a hardcoded string value.
 *
 * At this stage, the application:
 * - Stores a predefined string
 * - Compares characters from both ends
 * - Determines whether the string is a palindrome
 * - Displays the result on the console
 *
 * @author Developer
 * @version 2.0
 */

        public class PalindromeCheckerApp {

            /**
             * Application entry point for UC2.
             * @param args Command-line arguments
             */
            public static void main(String[] args) {

// Hardcoded string
                String input = "madam";

                boolean isPalindrome = true;

// Loop only till half of the string length
                for (int i = 0; i < input.length() / 2; i++) {

                    if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                        isPalindrome = false;
                        break;
                    }
                }

// Print result
                if (isPalindrome) {
                    System.out.println(input + " is a Palindrome.");
                } else {
                    System.out.println(input + " is NOT a Palindrome.");
                }
            }
        }
