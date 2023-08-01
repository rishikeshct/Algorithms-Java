package Greedy;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "(*))*)";
        System.out.println(ValidParenthesisFunc(s));
    }

    private static boolean ValidParenthesisFunc(String s) {

        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open.push(i);
            } else if (s.charAt(i) == '*') {
                star.push(i);
            } else if (s.charAt(i) == ')') {
                if (!open.isEmpty()) {
                    open.pop();
                } else {
                    if (!star.isEmpty() && star.peek() < i) {
                        star.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

           while (!open.isEmpty() && !star.isEmpty()) {
               if (star.peek() > open.peek()) {
                   open.pop();
               }
               star.pop();
           }

           if (open.isEmpty()) {
               return true;
           } else {
               return false;
           }
    }
}
