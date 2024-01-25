package F3.postfixeval;
import java.util.Stack;
import java.util.EmptyStackException;

public class PostfixEvaluator {

    public static class SyntaxErrorException extends Exception{
        SyntaxErrorException(String msg){
            super(msg);
        }
    }

    private static final String OPERATORS = "+-*/";
    private static Stack<Integer> operandStack;

    private static boolean isOperator(char ch){
        return OPERATORS.indexOf(ch) != -1;
    }

    private static int evalOp(char op){
        int right = operandStack.pop();
        int left = operandStack.pop();
        return switch (op) {
            case '+' -> left + right;
            case '-' -> left - right;
            case '*' -> left * right;
            case '/' -> left / right;
            default -> 0;
        };
    }

    public static int eval(String expression) throws SyntaxErrorException{
        operandStack = new Stack<>();
        String [] tokens = expression.split(" +");
        try{
            for (String nextToken: tokens){
                if(Character.isDigit(nextToken.charAt(0))){
                    operandStack.push(Integer.parseInt(nextToken));
                }else if (isOperator(nextToken.charAt(0))){
                    operandStack.push(evalOp(nextToken.charAt(0)));
                }else{
                    throw new SyntaxErrorException("Invalid character encountered");
                }
            }
        }catch (EmptyStackException e){
           throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
        int result = operandStack.pop();
        if(!operandStack.isEmpty()) throw new SyntaxErrorException("Invalid character encountered");
        return result;
    }
}
