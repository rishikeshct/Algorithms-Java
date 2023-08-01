package TwoDp;

public class RegularExpressionMatching {

    public static void main(String[] args) {
        String s = "aab", p = "c*a*b";

        System.out.println(RegularExpressionMatchingFunc(s, p, 0, 0));
    }

    private static boolean RegularExpressionMatchingFunc(String s, String p, int i, int j) {

        if (i >= s.length() && j >= p.length()) {
            return true;
        } else if (j >= p.length() || i >= s.length()) {
            return false;
        }

        boolean a = false;
        boolean b = false;
        if (s.charAt(i) == p.charAt(j)) {
            a = RegularExpressionMatchingFunc(s, p, i+1, j+1);
        } else if (s.charAt(i) == '*' || p.charAt(j) == '*') {
            if (s.charAt(i) == '*') {
                if (s.charAt(i-1) == '.') {
                    j = p.length();
                    b = RegularExpressionMatchingFunc(s, p, i+1, j);
                } else {
                    int k =0;
                    while (j < p.length() && (p.charAt(j) == s.charAt(i-1))) {
                        j++;
                        k++;
                    }
                    if (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i-1)) {
                        char c = s.charAt(i-1);
                        i++;
                        while (i < s.length() && k > 0 && s.charAt(i) == c) {
                            i++;
                            k--;
                        }
                        b = RegularExpressionMatchingFunc(s, p, i, j);
                    } else {
                        b = RegularExpressionMatchingFunc(s, p, i+1, j);
                    }
                }
            } else if (p.charAt(j) == '*') {
                if (p.charAt(j - 1) == '.') {
                    i = s.length();
                    b = RegularExpressionMatchingFunc(s, p, i, j + 1);
                } else {
                    int k = 0;
                    while (i < s.length() && (s.charAt(i) == p.charAt(j-1))) {
                        i++;
                        k++;
                    }

                    if (j + 1 < p.length() && p.charAt(j + 1) == p.charAt(j-1)) {
                        char c = p.charAt(j-1);
                        j++;
                        while (j < p.length() && k > 0 && p.charAt(j) == c) {
                            j++;
                            k--;
                        }
                        b = RegularExpressionMatchingFunc(s, p, i, j);
                    } else {
                        b = RegularExpressionMatchingFunc(s, p, i, j + 1);
                    }
                }
            }
        } else if (s.charAt(i) == '.' || p.charAt(j) == '.') {
            b = RegularExpressionMatchingFunc(s, p, i+1, j + 1);
        } else if ((i + 1 < s.length() && s.charAt(i+1) == '*') || (j + 1 < p.length() && p.charAt(j+1) == '*')) {
            if (i + 1 < s.length() && s.charAt(i+1) == '*') {
                b = RegularExpressionMatchingFunc(s, p, i + 2, j);
            } else if (j + 1 < p.length() && p.charAt(j+1) == '*') {
                b = RegularExpressionMatchingFunc(s, p, i, j + 2);
            }
        }


        return a || b;
    }
}
