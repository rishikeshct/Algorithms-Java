package stack;

import java.util.ArrayList;
import java.util.List;

public class Parentheses {

    public static void main(String[] args) {
        int n = 3;
        List<String> list = new ArrayList<>();
        PrintParentheses("", 0, 0, list, n);
        System.out.println(list);
    }

    private static void PrintParentheses(String s, int open, int close, List<String> list, int n) {

        if (s.length() == n * 2) {
            list.add(s);
            return;
        }

        if (open < n) {
            PrintParentheses(s + "(", open + 1, close, list, n);
        }
        if (close < open) {
            PrintParentheses(s + ")", open, close + 1, list, n);
        }
    }
}
