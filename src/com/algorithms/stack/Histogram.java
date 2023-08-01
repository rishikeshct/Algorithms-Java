package stack;

import java.util.Stack;

public class Histogram {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};

        System.out.println(HistogramRectangle(heights));
    }

    private static int HistogramRectangle(int[] heights) {

        if (heights.length == 1) return heights[0];
        int area = 0;
        Stack<int[]> st = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            int[] curr = new int[]{i, heights[i]};

            while (!st.isEmpty() && st.peek()[1] > curr[1]) {
                int[] popped = st.pop();

                area = Math.max((i - popped[0]) * popped[1], area);
                curr[0] = popped[0];
            }

            st.push(curr);
        }
        int length = heights.length;
        while (!st.isEmpty()) {
            int[] popped = st.pop();
            area = Math.max((length - popped[0]) * popped[1], area);
        }
        return area;
    }
}
