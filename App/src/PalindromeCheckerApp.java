import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC7: Deque-Based Optimized Palindrome Checker ---");
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
     * UC7: Validates palindrome by comparing front and rear of a Deque.
     */
    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) return true;

        // ArrayDeque is generally faster than LinkedList for Deque operations
        Deque<Character> deque = new ArrayDeque<>();

        // Normalize for case-insensitivity and load the Deque
        String cleanedStr = str.toLowerCase();
        for (char ch : cleanedStr.toCharArray()) {
            deque.addLast(ch);
        }

        // Compare until there is 0 or 1 character left
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false; // Mismatch found
            }
        }

        return true;
    }
}