package parkinglot.Utils;

public class Pair<T, U> {
    public final T key;
    public final U value;

    public Pair(T t, U u) {
        this.key = t;
        this.value = u;
    }
}