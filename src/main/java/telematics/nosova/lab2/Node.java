package telematics.nosova.lab2;

public class Node<T> {
    private T data;
    private Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
    public T getData() {
        return data;
    }
    void setData(T data) {
        this.data = data;
    }
    void setNext(Node<T> next) {
        this.next = next;
    }
    Node<T> getNext() {
        return next;
    }
}
