import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {
    private T[] arr = (T[]) new Object[10];
    private int head = -1;

    public void push(T item) {
        if (head == arr.length - 1) {
            grow();
        }
        arr[++head] = item;
    }

    public T pop() throws Exception {
        if (empty()) {
            throw new Exception();
        }
        return arr[head--];
    }

    public T peek() throws Exception {
        if (empty()) {
            throw new Exception();
        }
        return arr[head];
    }

    public boolean empty() {
        if (head == -1)
            return true;
        return false;
    }

    private void grow() {
        // copies current array into a new array of
        // twice the original size.
        T[] new_arr = Arrays.copyOf(arr, arr.length * 2);
        arr = new_arr;
    }
}

