import java.util.ArrayList;

public class CircleBuffer<T> {
    private ArrayList<T> data;
    private int head;
    private int capacity;

    public CircleBuffer(int capacity) {
        data = new ArrayList<>();
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return data.size() == 0;
    }

    public void push(T item) {
        if(isEmpty()) {
            data.add(item);
            head = 0;
        }
        else if(data.size() == capacity) {
            data.set(head, item);
            head = (head + 1) % capacity;
        }
        else {
            data.add(item);
        }
    }
}
