package F3.balancedparentheses;

public class ParenCheckerMain {
    public static void main(String[] args) {
        String[] testStrings = {
                "()",
                ")",
                null,
                "([])",
                "aaaa{a[a(a)a]a}a",
                "{[()]",
                "({[)]}",
                "abcd",
                "([{}])",
                "({d[dsaa]})",
                "){",
                "(()",
                "{([]{test!!}())}",
                "hejtest"
        };

        for (String str : testStrings) {
            try{
                boolean isBalanced = ParenChecker.isBalanced(str);
                System.out.println("String \"" + str + "\" is " + (isBalanced ? "balanced" : "not balanced"));
            }catch (NullPointerException ne){
                System.out.println("Cannot test " + ne.getMessage());
            }

        }
    }
}
