package HeapPriorityQueue;

public class Pair<T, T1> {

    T key;

    T1 value;

    public Pair(T key, T1 value) {
        this.key = key;
        this.value = value;
    }

    public T1 getValue() {
        return this.value;
    }

    public T getKey() {
        return this.key;
    }
}
