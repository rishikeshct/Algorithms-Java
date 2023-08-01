package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";

        System.out.println(PartitionLabelsFunc(s));
    }

    private static List<Integer> PartitionLabelsFunc(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int end = 0;
        int start = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (end < map.get(s.charAt(i))) {
                end = map.get(s.charAt(i));
            }
            if (end == i) {
                list.add(end - start + 1);
                start = end + 1;
            }
        }

        return list;
    }
}
