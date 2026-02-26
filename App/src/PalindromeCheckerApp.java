import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC6: Queue + Stack Palindrome Checker ---");
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
     * UC6: Validates palindrome by comparing FIFO (Queue) vs LIFO (Stack).
     */
    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) return true;

        // Initialize Data Structures
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Normalize for case-insensitivity
        String cleanedStr = str.toLowerCase();

        // Step 1: Populate both structures
        for (int i = 0; i < cleanedStr.length(); i++) {
            char ch = cleanedStr.charAt(i);
            queue.add(ch);   // Enqueue (FIFO)
            stack.push(ch);  // Push (LIFO)
        }

        // Step 2: Compare Dequeue vs Pop
        // Queue.poll() retrieves the first character entered
        // Stack.pop() retrieves the last character entered
        while (!queue.isEmpty()) {
            if (!queue.poll().equals(stack.pop())) {
                return false; // Mismatch between original order and reverse order
            }
        }

        return true;
    }
}