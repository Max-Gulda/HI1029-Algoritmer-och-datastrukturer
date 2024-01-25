package F3.balancedparentheses;

import F3.linkedliststack.LinkedListStack;

public class ParenChecker {
    private static final String OPENGEXPR = "([{";
    private static final String CLOSEEXPR = ")}]";

    private ParenChecker(){}

    public static boolean isBalanced(String str){
        if (str == null) throw new NullPointerException();
        LinkedListStack<Character> stack = new LinkedListStack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (OPENGEXPR.indexOf(ch) != -1){
                stack.push(ch);
            } else if (CLOSEEXPR.indexOf(ch) != -1){
                if (!stack.isEmpty()) {
                    switch (ch) {
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
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
