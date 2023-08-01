package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DailyTempOrNextGreater {
    public static void main(String[] args) {
        int[] temps = {30,40,50,60};

        System.out.println(Arrays.toString(DailyTempOrNextGreaterFunc(temps)));
    }

    private static int[] DailyTempOrNextGreaterFunc(int[] temps) {
        int[] ans = new int[temps.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temps.length; i++) {

            while (!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }

            stack.push(i);
        }

        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                ans[stack.peek()] = 0;
                stack.pop();
            }
        }

        return ans;
    }
}
