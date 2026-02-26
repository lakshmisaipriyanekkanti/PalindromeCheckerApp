import java.util.*;

// 1. Define the Strategy Interface
interface PalindromeStrategy {
    boolean isValid(String input);
}

// 2. Concrete Strategy: Stack-Based
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isValid(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : clean.toCharArray()) stack.push(ch);
        for (char ch : clean.toCharArray()) {
            if (ch != stack.pop()) return false;
        }
        return true;
    }
}

// 3. Concrete Strategy: Deque-Based
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isValid(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : clean.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

// 4. Context Class
class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String input) {
        return strategy.isValid(input);
    }
}

// 5. Main Application
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.println("--- UC12: Strategy Pattern Palindrome App ---");
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        System.out.println("Choose Strategy: 1) Stack  2) Deque");
        int choice = scanner.nextInt();

        // Polymorphism in action: Injecting the strategy at runtime
        if (choice == 1) {
            context.setStrategy(new StackStrategy());
        } else {
            context.setStrategy(new DequeStrategy());
        }

        if (context.executeStrategy(text)) {
            System.out.println("Result: It is a palindrome!");
        } else {
            System.out.println("Result: Not a palindrome.");
        }
        scanner.close();
    }
}