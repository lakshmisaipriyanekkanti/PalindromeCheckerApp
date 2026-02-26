import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Palindrome Checker (Character Array) ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }

    /**
     * UC4: Validates palindrome using a char array and two-pointer technique.
     */
    public static boolean isPalindrome(String str) {
        if (str == null) return false;

        // Convert string to char array for index-based access
        char[] charArray = str.toLowerCase().toCharArray();

        // Two-pointer initialization
        int start = 0;
        int end = charArray.length - 1;

        // Compare characters until pointers meet in the middle
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false; // Mismatch found
            }
            start++; // Move forward
            end--;   // Move backward
        }

        return true; // No mismatches found
    }
}