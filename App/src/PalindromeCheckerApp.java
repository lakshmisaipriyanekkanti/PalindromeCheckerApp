import java.util.Scanner;

/**
 * UC11: PalindromeService class encapsulates the validation logic.
 * This demonstrates Encapsulation and Separation of Concerns.
 */
class PalindromeService {

    /**
     * Public method to check if a string is a palindrome.
     * The internal implementation is hidden from the user (Abstraction).
     */
    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        // Internal Logic: Normalization
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Internal Logic: Two-Pointer Verification
        int left = 0;
        int right = clean.length() - 1;

        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instantiate the service object
        PalindromeService service = new PalindromeService();

        System.out.println("--- UC11: Object-Oriented Palindrome Checker ---");
        System.out.print("Enter text to validate: ");
        String userInput = scanner.nextLine();

        // Calling the encapsulated method
        boolean result = service.checkPalindrome(userInput);

        if (result) {
            System.out.println("Result: Success! \"" + userInput + "\" is a palindrome.");
        } else {
            System.out.println("Result: Failed. \"" + userInput + "\" is not a palindrome.");
        }

        scanner.close();
    }
}