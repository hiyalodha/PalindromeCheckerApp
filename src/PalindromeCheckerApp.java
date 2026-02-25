
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
{

    public static void main(String[] args) {
        // UC1 – Application Entry & Welcome Message
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully.");
        System.out.println("----------------------------------------------");

        // UC2 – Hardcoded Palindrome Check
        String hardcodedWord = "radar";
        System.out.println("UC2 - Hardcoded Word : " + hardcodedWord);
        displayResult(isPalindrome(hardcodedWord));

        // UC3: User input palindrome check
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nUC3 - Enter a string for manual check: ");
        String userInput = scanner.nextLine();
        displayResult(isPalindrome(userInput));

        // UC4 – Character Array Based Palindrome Check
        String uc4Word = "level";
        System.out.println("\nUC4 - Character Array Check for: " + uc4Word);
        displayResult(isPalindromeCharArray(uc4Word));

        // UC5 – Stack-Based Palindrome Checker
        String uc5Word = "civic";
        System.out.println("\nUC5 - Stack-Based Check for: " + uc5Word);
        displayResult(isPalindromeStack(uc5Word));

        // UC6 – Queue + Stack Based Palindrome Check
        String uc6Word = "deed";
        System.out.println("\nUC6 - Queue + Stack Check for: " + uc6Word);
        displayResult(isPalindromeQueueStack(uc6Word));

        // UC7 – Deque-Based Optimized Palindrome Checker
        String uc7Word = "kayak";
        System.out.println("\nUC7 - Deque-Based Check for: " + uc7Word);
        displayResult(isPalindromeDeque(uc7Word));

        System.out.println("\n----------------------------------------------");
        System.out.println("All Use Cases Executed Successfully.");
        scanner.close();
    }

    // Helper method to print results consistently
    private static void displayResult(boolean result) {
        if (result) {
            System.out.println("Result : It is a Palindrome");
        } else {
            System.out.println("Result : It is not a Palindrome");
        }
    }

    /**
     * UC2/UC3: Basic Two-Pointer logic
     */
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    /**
     * UC4: Using char array
     */
    public static boolean isPalindromeCharArray(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    /**
     * UC5: Using a Stack (LIFO)
     */
    public static boolean isPalindromeStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) stack.push(c);
        for (char c : str.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    /**
     * UC6: Using Queue (FIFO) and Stack (LIFO) together
     */
    public static boolean isPalindromeQueueStack(String str) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }
        while (!queue.isEmpty()) {
            if (queue.poll() != stack.pop()) return false;
        }
        return true;
    }

    /**
     * UC7: Using Deque (Double-Ended Queue)
     */
    public static boolean isPalindromeDeque(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : str.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}