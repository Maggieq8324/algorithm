package stack;

/**
 * @Description leetCode 20 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * @author coisini
 * @date Jun 11, 2021
 * @Version 1.0
 */
public class Solution {

    /**
     * 有效的括号 - 自定义栈
     * @param s
     * @return
     */
    public static boolean isValidCustom(String s) {
        ArrayStack<Character> arrayStack = new ArrayStack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                arrayStack.push(c);
            } else {
                if (arrayStack.isEmpty()) {
                    return false;
                }

                char d = arrayStack.pop();
                if (c == ')' && d != '(') {
                    return false;
                } else if (c == ']' && d != '[') {
                    return false;
                } else if (c == '}' && d != '{') {
                    return false;
                }
            }
        }

        return arrayStack.isEmpty();

    }

    /**
     * 有效的括号 - java Stack
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        java.util.Stack<Character> characters = new java.util.Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                characters.push(c);
            } else {
                if (characters.isEmpty()) {
                    return false;
                }

                char d = characters.pop();
                if (c == ')' && d != '(') {
                    return false;
                } else if (c == ']' && d != '[') {
                    return false;
                } else if (c == '}' && d != '{') {
                    return false;
                }
            }

        }

        return characters.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidCustom("()"));
        System.out.println(isValid("("));
    }
}
