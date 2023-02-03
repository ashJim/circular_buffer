package cb;
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

    public boolean atCapacity() {
        return data.size() == capacity;
    }
    
    public void push(T item) {
        if(isEmpty()) {
            data.add(item);
            head = 0;
        }
        else if(atCapacity()) {
            data.set(head, item);
            head = (head + 1) % capacity;
        }
        else {
            data.add(item);
        }
    }

    public T pop() {
        T item = data.get(head);
        data.set(head, null);
        return item;
    }

    public T peek() {
        return data.get(head);
    }

    public T get(int index) {
        return data.get((head + index) % capacity);
    }
}
