package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberCombination {
    static Map<Character, String> map;
    public static void main(String[] args) {
        String digits = "23";

        List<String> res = new ArrayList<>();

        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        solve("", 0, digits, digits.length(), res);
        res.forEach(r -> System.out.println(r));
    }

    private static void solve(String s, int i, String digits, int length, List<String> res) {
        if (s.length() == digits.length()) {
            res.add(s);
            return;
        }
        char ch = digits.charAt(i);
        String str = map.get(ch);

        for (int j = 0; j < str.length(); j++) {
            solve(s + str.charAt(j), i + 1, digits, length, res);
        }

    }
}
