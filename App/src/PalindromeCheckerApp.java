import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC9: Recursive Palindrome Checker ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize string: Remove non-alphanumeric and convert to lowercase
        String cleanedStr = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (isPalindrome(cleanedStr, 0, cleanedStr.length() - 1)) {
            System.out.println("Result: \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }

    /**
     * UC9: Validates palindrome using recursion.
     * @param str The string to check.
     * @param start The current left index.
     * @param end The current right index.
     * @return true if the substring is a palindrome.
     */
    public static boolean isPalindrome(String str, int start, int end) {
        // Base Case 1: If there is 0 or 1 character left, it's a palindrome
        if (start >= end) {
            return true;
        }

        // Base Case 2: If characters at start and end don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive Step: Check the inner substring (shrink the window)
        return isPalindrome(str, start + 1, end - 1);
    }
}