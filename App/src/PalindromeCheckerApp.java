import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC5: Stack-Based Palindrome Checker ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Result: \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }

    /**
     * UC5: Validates palindrome using the LIFO property of a Stack.
     */
    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) return true;

        // Use a stack to store characters
        Stack<Character> stack = new Stack<>();

        // Normalize the string (case-insensitive)
        String cleanedStr = str.toLowerCase();

        // Step 1: Push all characters onto the stack
        for (int i = 0; i < cleanedStr.length(); i++) {
            stack.push(cleanedStr.charAt(i));
        }

        // Step 2: Pop characters and compare with original string
        // Since Stack is LIFO, popping gives the string in reverse order
        for (int i = 0; i < cleanedStr.length(); i++) {
            char originalChar = cleanedStr.charAt(i);
            char reversedChar = stack.pop();

            if (originalChar != reversedChar) {
                return false; // Mismatch found
            }
        }

        return true; // All characters matched
    }
}