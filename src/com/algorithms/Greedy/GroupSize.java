package Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GroupSize {
    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;

        System.out.println(GroupSizeFunc(hand, groupSize));
    }

    private static boolean GroupSizeFunc(int[] hand, int groupSize) {
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        for (int i = 0; i < hand.length; i++) {
            int curr = map.get(hand[i]);
            if (curr == 0) {
                continue;
            }

            for (int j = 0; j < groupSize; j++) {
               int next = hand[i] + j;

               if (map.getOrDefault(next, 0) == 0) {
                   return false;
               }

               map.put(next, map.get(next) - 1);
            }

        }


        return true;
    }
}
