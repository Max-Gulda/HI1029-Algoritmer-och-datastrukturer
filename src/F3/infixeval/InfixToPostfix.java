package F3.infixeval;
import java.util.Stack;

public class InfixToPostfix {

    // Function to return precedence of operators
    private static int prec(char c) {
        return switch (c) {
            case '/', '*' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }
    public static int infixCalculator (String s){
        return postFixCalculator(infixToPostfix(s));
    }
    // The main function to convert infix expression to postfix expression
    public static String infixToPostfix(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isWhitespace(c)) {
                continue; // Ignore spaces
            }

            // If the scanned character is an operand, add it to the output string.
            if (Character.isDigit(c)) {
                result.append(c);
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    result.append(s.charAt(++i));
                }
                result.append(' ');
            }
            // If the scanned character is an ‘(‘, push it to the stack.
            else if (c == '(') {
                stack.push(c);
            }
            // If the scanned character is an ‘)’, pop and add to the output string from the stack
            // until an ‘(‘ is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression"; // Unbalanced parentheses
                } else {
                    stack.pop();
                }
            }
            // If an operator is scanned
            else {
                while (!stack.isEmpty() && prec(c) <= prec(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all the remaining elements from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression"; // Unbalanced parentheses
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static int postFixCalculator(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isWhitespace(c)) {
                continue;
            }

            if (Character.isDigit(c)) {
                int number = 0;
                while (Character.isDigit(c)) {
                    number = number * 10 + (c - '0');
                    i++;
                    if (i < postfix.length()) {
                        c = postfix.charAt(i);
                    } else {
                        break;
                    }
                }
                stack.push(number);
                i--; // adjust for the loop increment
            } else {
                int rightOperand = stack.pop();
                int leftOperand = stack.pop();
                switch (c) {
                    case '+' -> stack.push(leftOperand + rightOperand);
                    case '-' -> stack.push(leftOperand - rightOperand);
                    case '/' -> stack.push(leftOperand / rightOperand);
                    case '*' -> stack.push(leftOperand * rightOperand);
                    default -> throw new IllegalArgumentException("Invalid character encountered: " + c);
                }
            }
        }
        return stack.pop();
    }
}
