package leetcode.validparentheses;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(isValid(""));
        System.out.println(isValid("[}"));
        System.out.println(isValid("}("));
        System.out.println(isValid("[](){"));
        System.out.println(isValid("[]()}"));
        System.out.println(isValid("[](){}"));
        System.out.println(isValid("[(){}]"));
        System.out.println(isValid("[({})]"));
        System.out.println(isValid("(([]){})"));
        System.out.println(isValid("(({)}[])"));
    }

    public static boolean isValid(String s) {
        if (s == null
                || s.length() < 2
                || s.length() % 2 == 1
                || s.startsWith("}")
                || s.startsWith("]")
                || s.startsWith(")")) {
            return false;
        }
        ArrayList<Character> symbols = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                symbols.add(')');
            else if (s.charAt(i) == '{')
                symbols.add('}');
            else if (s.charAt(i) == '[')
                symbols.add(']');
            else if (symbols.get(symbols.size() - 1) == s.charAt(i)) {
                symbols.remove(symbols.size() - 1);
            } else {
                return false;
            }

        }

        return symbols.isEmpty();
    }

    // BEST SOLUTION
    public static boolean isValid3(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    //NOT WORKING FOR ALL CASES
    public static boolean isValid2(String s) {
        if (s == null
                || s.length() < 2
                || s.length() % 2 == 1) {
            return false;
        }

        int lengthBefore = s.length();

        while(lengthBefore != 0){
            if (s.charAt(0) == '('){
                if (s.charAt(1) == ')') {
                    s = s.substring(2);
                } else if (s.charAt(s.length()-1) == ')') {
                    s = s.substring(1, s.length()-1);
                }
            }

            if (lengthBefore == s.length() && s.charAt(0) == '['){
                if (s.charAt(1) == ']') {
                    s = s.substring(2);
                } else if (s.charAt(s.length()-1) == ']') {
                    s = s.substring(1, s.length()-1);
                }
            }

            if (lengthBefore == s.length() && s.charAt(0) == '{'){
                if (s.charAt(1) == '}') {
                    s = s.substring(2);
                } else if (s.charAt(s.length()-1) == '}') {
                    s = s.substring(1, s.length()-1);
                }
            }

            if (lengthBefore == s.length()){
                return false;
            } else {
                lengthBefore = s.length();
            }
        }

        return true;
    }



}
