package TwoDp;

import java.util.HashMap;
import java.util.Map;

public class InterLeavingString {
    public static void main(String[] args) {
        String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
        String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
        String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";

        Map<String, Boolean> map = new HashMap<>();
        System.out.println(InterLeavingStringFunc(s1,s2,s3,0,0,0, map));
    }

    private static boolean InterLeavingStringFunc(String s1, String s2, String s3, int i, int j, int k, Map<String, Boolean> map) {
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        } else if (k > s3.length()) {
            return false;
        }
        String key = i + "_" + j + "_";
        if (map.containsKey(key)) {
            return map.get(key);
        }

        boolean flag = false;
        if (i < s1.length() && j < s2.length() && k < s3.length() && (s1.charAt(i) == s2.charAt(j)) && (s1.charAt(i) == s3.charAt(k))) {
           flag =  InterLeavingStringFunc(s1, s2, s3, i + 1, j, k+1, map) ||
            InterLeavingStringFunc(s1, s2, s3, i, j+1, k+1, map);
        } else if ((i < s1.length() && k < s3.length()) && s1.charAt(i) == s3.charAt(k)) {
            flag = InterLeavingStringFunc(s1,s2,s3, i+1, j, k+1, map);
        } else if ((j < s2.length() && k < s3.length()) && s2.charAt(j) == s3.charAt(k)) {
            flag = InterLeavingStringFunc(s1,s2,s3, i, j+1, k+1, map);
        } 

        map.put(key, flag);

        return flag;
    }
}
