package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String str = "aabb";
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), str, 0);
        result.forEach(res -> System.out.println(res));
    }

    private static void backtrack(List<List<String>> result, List<String> tempList, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                tempList.add(s.substring(start, i + 1));
                backtrack(result, tempList, s, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
