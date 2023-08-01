package arrays;

import java.util.*;

public class Frequency implements Comparable<Frequency>{

    int val;

    int freq;

    public Frequency(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }

    public static void main(String[] args) {

        int[] array = {1,1,1,2,2,3, 4, 4,4 ,4};
        int k = 2;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }

        PriorityQueue<Frequency> queue = new PriorityQueue<>();
        Set<Integer> keys = map.keySet();

        for (int i : keys) {
            queue.add(new Frequency(i, map.get(i)));
        }

        int[] ans = new int[k];

        for (int i = 0 ; i < k;i ++) {
            ans[i] = queue.poll().val;
        }


        System.out.println(Arrays.toString(ans));
    }

    @Override
    public int compareTo(Frequency o) {
        return o.freq - this.freq;
    }
}
