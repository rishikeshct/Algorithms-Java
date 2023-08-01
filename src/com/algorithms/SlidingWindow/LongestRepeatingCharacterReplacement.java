package SlidingWindow;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String str = "AABCAABB";
        int k = 2;

        System.out.println(LongestRepeatingCharacterReplacementFunc(str, k));
    }

    private static int LongestRepeatingCharacterReplacementFunc(String str, int k) {

        int start = 0;

        int maxCount = 0;
        int maxLength = 0;

        int[] array = new int[26];
        for  (int end = 0; end < str.length(); end++) {
            char currentChar = str.charAt(end);
            array[currentChar - 'A']++;

            maxCount = Math.max(maxCount, array[currentChar - 'A']);

            int repeat = (end - start + 1) - maxCount;

            if (repeat > k) {
                array[str.charAt(start) - 'A']--;
                start++;
            }

            maxLength = Math.max(maxLength, end-start+1);
        }

        return maxLength;
    }
}
