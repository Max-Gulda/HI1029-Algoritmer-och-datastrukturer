package F4.pp7;

import java.util.Stack;

public class pp7 {
    private static class SyntaxError extends RuntimeException {
        public SyntaxError(String msg){
            super(msg);
        }
        public SyntaxError(){
            super("");
        }
    }

    private pp7(){

    }

    private static boolean parenthesesChecker(String s){
        Stack<Character> parentheses = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if("([{".indexOf(ch) != -1){
                parentheses.push(ch);
            } else if (")]}".indexOf(ch) != -1){
                char openingParentheses = parentheses.pop();
                if("([{".indexOf(openingParentheses) == -1) return false;
                if (ch == ')' && openingParentheses != '(') return false;
                if (ch == '}' && openingParentheses != '{') return false;
                if (ch == ']' && openingParentheses != '[') return false;
            }
        }
        return parentheses.isEmpty();
    }

    public static int infixCalc(String s) throws SyntaxError{
        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();
        if(!parenthesesChecker(s)) throw new SyntaxError("Parentheses does not match up");

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ' ') continue;

            if(Character.isDigit(ch)){

                StringBuilder number = new StringBuilder();
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    number.append(s.charAt(i++));
                }
                operands.push(Integer.parseInt(number.toString()));
                i--;

            } else if(isOperand(ch)){
                while(!operators.isEmpty() && precedence(ch) <= precedence(operators.peek())){
                    int right = operands.pop();
                    int left = operands.pop();
                    operands.push(calculate(operators.pop(),right,left));
                }
                operators.push(ch);
            } else if(ch == '('){
                operators.push(ch);
            } else if(ch == ')'){
                while(operators.peek() != '(' && !operators.isEmpty()){
                    int right = operands.pop();
                    int left = operands.pop();
                    operands.push(calculate(operators.pop(), right, left));
                }
                operators.pop(); // pop '(' off the stack
            }
        }

        while(!operands.isEmpty() && !operators.isEmpty()){
            char op = operators.pop();
            int right = operands.pop();
            int left = operands.pop();
            operands.push(calculate(op,right,left));
        }

        int result = operands.pop();
        if (operands.isEmpty() && operators.isEmpty()){
            return result;
        } else {
            throw new SyntaxError();
        }

    }

    private static boolean isOperand(Character c){
        return "*-/+".indexOf(c) != -1;
    }

    private static int precedence(Character ch){
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };
    }

    private static int calculate(Character operand, int right, int left){
        return switch (operand) {
            case '+' -> left + right;
            case '-' -> left - right;
            case '/' -> left / right;
            case '*' -> left * right;
            default -> 0;
        };
    }


}
