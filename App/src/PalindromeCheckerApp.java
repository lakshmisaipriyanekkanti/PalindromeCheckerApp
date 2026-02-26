import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC13: Performance Comparison ---");
        System.out.print("Enter a long string to test performance: ");
        String input = scanner.nextLine();

        // Clean the input once to ensure fair comparison
        String testStr = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        System.out.println("\nBenchmarking Results (in Nanoseconds):");
        System.out.println("---------------------------------------");

        // 1. Benchmark Two-Pointer (UC4 Logic)
        long start = System.nanoTime();
        checkTwoPointer(testStr);
        long end = System.nanoTime();
        System.out.printf("Two-Pointer Approach: %d ns\n", (end - start));

        // 2. Benchmark Stack-Based (UC5 Logic)
        start = System.nanoTime();
        checkStack(testStr);
        end = System.nanoTime();
        System.out.printf("Stack-Based Approach: %d ns\n", (end - start));

        // 3. Benchmark Recursive (UC9 Logic)
        start = System.nanoTime();
        checkRecursive(testStr, 0, testStr.length() - 1);
        end = System.nanoTime();
        System.out.printf("Recursive Approach:   %d ns\n", (end - start));

        scanner.close();
    }

    // UC4 Logic: O(1) extra space
    public static boolean checkTwoPointer(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    // UC5 Logic: O(n) extra space
    public static boolean checkStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) stack.push(c);
        for (char c : s.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    // UC9 Logic: O(n) stack depth
    public static boolean checkRecursive(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return checkRecursive(s, start + 1, end - 1);
    }
}