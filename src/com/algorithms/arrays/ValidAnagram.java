package arrays;

public class ValidAnagram {

    public static void main(String[] args) {

        String str = "anagram";
        String str2 = "nagaran";

        System.out.println(ValidAnagraCheck(str, str2));
    }

    private static boolean ValidAnagraCheck(String str, String str2) {

        if (str.length() != str2.length()) {
            return false;
        }

        int[] chars = new int[26];

        for (int i = 0; i < str.length(); i++) {
            chars[str.charAt(i) - 'a']++;
            chars[str2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (chars[i] > 0) {
                return false;
            }
        }

        return true;
    }
}
