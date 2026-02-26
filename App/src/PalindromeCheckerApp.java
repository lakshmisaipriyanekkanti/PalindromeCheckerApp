import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC10: Case & Space Insensitive Palindrome ---");
        System.out.println("Supports phrases like: 'A man a plan a canal Panama'");
        System.out.print("Enter a string or phrase: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Result: Success! It is a palindrome.");
        } else {
            System.out.println("Result: Failed. It is NOT a palindrome.");
        }

        scanner.close();
    }

    /**
     * UC10: Preprocesses the string to ignore case and non-alphanumeric characters.
     */
    public static boolean isPalindrome(String str) {
        if (str == null) return false;

        // Step 1: Normalization using Regex
        // [^a-zA-Z0-9] means "anything that is NOT a letter or a number"
        // replaceAll replaces those matches with an empty string ""
        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Edge case: empty string after cleaning
        if (cleanedStr.isEmpty()) return true;

        // Step 2: Apply Two-Pointer logic for efficiency
        int left = 0;
        int right = cleanedStr.length() - 1;

        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}