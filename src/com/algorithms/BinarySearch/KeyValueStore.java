package BinarySearch;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyValueStore {

    Map<String, List<TimeValue>> map;

    public KeyValueStore() {
        this.map = new HashMap<>();
    }



    public static void main(String[] args) {

        KeyValueStore store = new KeyValueStore();
        store.Set("foo", "bar", 1);
        store.Set("foo", "bar2", 4);

        System.out.println(store.Get("foo", 5));
    }

    private void Set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new TimeValue(timestamp, value));
    }

    private String Get(String key, int time) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<TimeValue> values = map.get(key);

        int start = 0;
        int end = values.size() - 1;
        String ans = "";
        while (start <= end) {
            int mid = (start + end) / 2;

            if (values.get(mid).time <= time) {
                ans = values.get(mid).value;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    class TimeValue {

        Integer time;
        String value;

        public TimeValue(Integer time, String value) {
            this.time = time;
            this.value = value;
        }
    }
}
