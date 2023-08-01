package TwoDp;

import java.util.HashMap;
import java.util.Map;

public class DistinctSubsequences {
    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";

        Map<String, Integer> map = new HashMap<>();
        System.out.println(DistinctSubsequencesFunc(s, t, 0, 0, map));

    }

    private static int DistinctSubsequencesFunc(String s, String t, int i, int j, Map<String, Integer> map) {

        if (j == t.length()) {
            return 1;
        }else if(j > t.length() || i >= s.length()){
            return 0;
        }

        String key = i + "_" + j;

        if(map.containsKey(key)) {
            return map.get(key);
        }
        int a = 0;
        int b = 0;
        if (s.charAt(i) == t.charAt(j)) {
            a += DistinctSubsequencesFunc(s, t, i + 1, j + 1, map);
            b += DistinctSubsequencesFunc(s, t, i + 1, j, map);
            map.put(key, a+b);
            return a+b;
        } else {
           return DistinctSubsequencesFunc(s, t, i + 1, j, map);
        }
    }
}
