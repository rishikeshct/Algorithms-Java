package SlidingWindow;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "eidbaooo";
        System.out.println(PermutationInStringFunc(s1, s2));
    }

    private static boolean PermutationInStringFunc(String s1, String s2) {

        int[] array1 = new int[26];
        int[] array2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            array1[s1.charAt(i) - 'a']++;
            array2[s2.charAt(i) - 'a']++;
        }

        for (int  i =0; i < s2.length() - s1.length(); i++) {
            if (equalString(array2, array1)) {
                return true;
            } else {
                array2[s2.charAt(i) - 'a']--;
                array2[s2.charAt(i + s1.length()) - 'a']++;
            }
        }

        return false;
    }

    private static boolean equalString(int[] array2, int[] array1) {
        for (int i = 0; i < 26; i++) {
            if (array2[i] != array1[i]) {
                return false;
            }
        }
        return true;
    }
}
