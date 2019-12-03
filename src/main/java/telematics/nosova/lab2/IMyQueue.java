package telematics.nosova.lab2;

public interface IMyQueue<T> {

    int size();
    boolean contains(T obj);
    void add(T obj);
    T remove();
    T get(int index);
}