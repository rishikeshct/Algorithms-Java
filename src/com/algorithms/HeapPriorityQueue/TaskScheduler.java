package HeapPriorityQueue;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        String task = "AAAA";
        int k=1;

        System.out.println(TaskSchedulerFunc(task, k));
        System.out.println(leastInterval(task.toCharArray(), k));

    }

    private static int TaskSchedulerFunc(String task, int k) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < task.length();i++) {
            map.put(task.charAt(i), map.getOrDefault(task.charAt(i), 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.addAll(map.values());
        int ans = 0;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                    list.add(queue.poll());
            }

            for (int i : list) {
                if (--i > 0) {
                    queue.add(i);
                }
            }

            if (list.size() < k + 1 && !queue.isEmpty()) {
                ans += k + 1 - list.size();
            }

            ans += list.size();
        }

        return ans;
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(map.values());

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int cnt = pq.poll() - 1;

                if (cnt != 0) {
                    q.offer(new Pair(cnt, time + n));
                }
            }

            if (!q.isEmpty() && q.peek().getValue() == time) {
                pq.offer(q.poll().getKey());
            }
        }

        return time;
    }
}
