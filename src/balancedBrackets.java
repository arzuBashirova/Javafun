import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class balancedBrackets {

    public static void main(String[] args) {

        // TESTS
        System.out.println(isBalanced("()")); // - true
        System.out.println(isBalanced("((()))")); // - true
        System.out.println(isBalanced("([[{{}}]])")); // - true
        System.out.println(isBalanced("()(){}{{}}[][[]]")); // - true
        System.out.println(isBalanced("[{()}]")); // - true
        System.out.println(isBalanced("({}{}([{}]))"));// - true
        System.out.println(isBalanced("[({(})]")); // false
        System.out.println(isBalanced("{[}"));// - false
        System.out.println(isBalanced("({")); // - false

    }

    public static boolean isBalanced(String str) {

//            List<Character> list= new ArrayList<>();
//
//            for (int i=0; i<str.length(); i++) {
//
//                list.add(str.charAt(i));
//
//            }
        Stack stack = new Stack();

        char[] charArray = str.toCharArray();

        // iterate charArray
        for (int i = 0; i < charArray.length; i++) {

            // get char
            char current = charArray[i];

            //check whether current is '(', '[' or '{'
            if (current == '{' || current == '[' || current == '(') {
                // push current to stack
                stack.push(current);
                continue;
            }
            // if stack is empty, return false
            if (stack.isEmpty()) {
                return false;
            }

            // use switch statement to pop element from stack and if it is '(', '[' or '{', return false
            char popChar;
            switch (current) {
                case ')':
                    popChar = (char) stack.pop();
                    if (popChar == '{' || popChar == '[')
                        return false;
                    break;
                case '}':
                    popChar = (char) stack.pop();
                    if (popChar == '(' || popChar == '[')
                        return false;
                    break;
                case ']':
                    popChar = (char) stack.pop();
                    if (popChar == '(' || popChar == '{')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }
}
