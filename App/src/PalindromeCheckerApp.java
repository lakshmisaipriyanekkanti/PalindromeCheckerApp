import java.util.Scanner;

// Custom Node class for Singly Linked List
class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC8: Linked List Based Palindrome Checker ---");
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
     * UC8: Validates palindrome using a Singly Linked List.
     */
    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) return true;

        // Step 1: Convert String to Singly Linked List
        String cleanedStr = str.toLowerCase();
        Node head = new Node(cleanedStr.charAt(0));
        Node current = head;
        for (int i = 1; i < cleanedStr.length(); i++) {
            current.next = new Node(cleanedStr.charAt(i));
            current = current.next;
        }

        // Step 2: Find the middle using Fast and Slow pointers
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse the second half of the list
        Node secondHalfHead = reverseList(slow);
        Node firstHalfHead = head;

        // Step 4: Compare the two halves
        Node tempSecond = secondHalfHead;
        while (tempSecond != null) {
            if (firstHalfHead.data != tempSecond.data) {
                return false;
            }
            firstHalfHead = firstHalfHead.next;
            tempSecond = tempSecond.next;
        }

        return true;
    }

    /**
     * Helper method to reverse a Linked List in-place.
     */
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}