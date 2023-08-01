package arrays;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {

        String str = "rishikesh";
        char[] ca = new char[26];
        for (char c : str.toCharArray()) ca[c - 'a']++;

        System.out.println(String.valueOf(ca));

        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(GroupAnagramFunc(strings));
    }

    private static List<List<String>> GroupAnagramFunc(String[] strings) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            char[] charArray = strings[i].toCharArray();
            Arrays.sort(charArray);
            String sortedStr = String.valueOf(charArray);
            if (!anagrams.containsKey(sortedStr)) {
                anagrams.put(sortedStr, new ArrayList<>());
            }

            anagrams.get(sortedStr).add(strings[i]);
        }

        return new ArrayList<>(anagrams.values());
    }

}
