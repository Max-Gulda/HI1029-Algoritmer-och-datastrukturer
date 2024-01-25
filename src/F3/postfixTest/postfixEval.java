package F3.postfixTest;

import java.util.Stack;

public class postfixEval {

    public static class SyntaxError extends RuntimeException {
        public SyntaxError(String msg){
            super(msg);
        }

        public SyntaxError(){
            this("");
        }
    }

    private static String OPERAND = "*/+-";
    private postfixEval(){

    }

    public static boolean parenthesesChecker(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isWhitespace(ch)) continue;
            switch (ch) {
                case '(', '{', '[' -> stack.push(ch);
                case ')' -> {
                    if (stack.pop() != '(') return false;
                }
                case '}' -> {
                    if (stack.pop() != '{') return false;
                }
                case ']' -> {
                    if (stack.pop() != '[') return false;
                }
            }

        }
        return stack.isEmpty();
    }

    public static int calcInfix(String s){
        return postfixCalc(infixToPostfix(s));
    }

    public static String infixToPostfix(String s) {
        if(!parenthesesChecker(s)) throw new SyntaxError("Parentheses not matching: " + s);
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String[] tokens = s.split(" +");

        for (String token : tokens) {
            char firstChar = token.charAt(0);
            if (Character.isDigit(firstChar)) {
                postfix.append(token).append(" ");
            } else if (isOperator(firstChar)) {
                while (!stack.isEmpty() && precedence(firstChar) <= precedence(stack.peek()) && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(firstChar);
            } else if (firstChar == '(') {
                stack.push(firstChar);
            } else if (firstChar == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Pop the '(' from the stack but don't add to postfix expression
                }
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }
        return postfix.toString().trim();
    }

    private static boolean isOperator(char c) {
        return OPERAND.indexOf(c) != -1;
    }

    private static int precedence(char op){
        switch (op) {
            case '+', '-' -> { return 1; }
            case '*', '/' -> { return 2; }
            default -> { return 0; }
        }
    }

    private static int precedence(String op){
        return precedence(op.charAt(0));
    }

    public static int postfixCalc(String s) throws SyntaxError{
        Stack<Integer> stack = new Stack<>();

        String [] token = s.split(" +");

        for(String exp: token){
            if (Character.isDigit(exp.charAt(0))) { // It's a digit
                stack.push(Integer.parseInt(exp));
            } else if (OPERAND.indexOf(exp.charAt(0)) != -1){ // It's a operand
                int right = stack.pop();
                int left = stack.pop();
                stack.push(calculate(exp.charAt(0), left, right));
            } else { // Error
                throw new SyntaxError("Unexpected character: " + exp);
            }
        }
        int result = stack.pop();
        if (!stack.isEmpty()) throw new SyntaxError("Error stack is not empty: " + stack);
        return result;
    }

    private static int calculate (char op, int left, int right){
        switch (op) {
            case '+' -> { return left + right; }
            case '-' -> { return left - right; }
            case '*' -> { return left * right; }
            case '/' -> { return left / right; }
            default -> { return 0; }
        }
    }
}
