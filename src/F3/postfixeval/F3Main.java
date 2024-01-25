package F3.postfixeval;

import java.util.Scanner;

public class F3Main {
    public static void main(String[] args) {
        PostfixEvaluator evaluator= new PostfixEvaluator();

        String line;
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Enter a postfix expression to evaluate!");
            line = in.nextLine();
            if(!line.equals("")){
                try{
                    int result = evaluator.eval(line);
                    System.out.println(result);
                }catch (PostfixEvaluator.SyntaxErrorException ex){
                    System.out.println("Syntax error " + ex.getMessage());
                }
            }else{
                break;
            }
        }
    }
}
