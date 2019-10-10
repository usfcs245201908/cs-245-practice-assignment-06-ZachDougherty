/*
We use modulo in these operations to implement
a circular array structure. This allows us to
utilize otherwise inaccessible elements in the 
beginning of our array.
*/

public class ArrayQueue<T> implements Queue<T> {
    private T[] arr = (T[]) new Object[10];
    private int front = -1;
    private int back = -1;

    public T dequeue() throws Exception {
        if (empty()) {
            throw new Exception("ERROR: Queue is empty");
        }
        T item = arr[back];
        if (back == front) { // if we reach 'empty'
                             // position, then we 
                             // 'reset' the array
                             // back to its original
                             // front and back
                             // positions.
            back = -1;
            front = -1;
        } else {
            // using modulo allows us to have a 
            // circular structure where the 
            // back pointer is relative to 
            // the size of the array.
            back = (back + 1) % arr.length;  
        }
        return item;
    }

    public void enqueue(T item) {
        if (empty()) {
            front = 0;
            back = 0;
        } else if ((front + 1) % arr.length == back) {
            grow();
        } else {
            // similarly t dequeue, we use modulo
            // to create a circular structure,
            // saving space without having to
            // grow the array more often than
            // necessary.
            front = (front + 1) % arr.length;
        }
        arr[front] = item;
    }

    public boolean empty() {
        if (front == -1 && back == -1) {
            return true;
        }
        return false;
    }

    private void grow() {
        int cursor = back;
        T[] new_arr = (T[]) new Object[arr.length * 2];
        for (int i = back; i < arr.length; i++) {
            new_arr[cursor++] = arr[i];
        }
        for (int j = 0; j < (front + 1) % arr.length; j++) {
            new_arr[cursor++] = arr[j];
        }
        front = cursor; // change front to be the index of
                        // our last element added + 1
        arr = new_arr;
    }

    public String toString() {
        String a = "[ ";
        for (int i=0; i < arr.length; i++) {
            a += arr[i] + ", ";
        }
        a += " ]\t";
        return a;
    }

    // I used this helper method when debugging to view the
    // state of the new array I was creating in my
    // grow() function.

    // I used 'arrr' instead of 'arr' to avoid
    // accidentally using the array named 'arr'
    // which is data already associated with
    // the ArrayQueue class.
    
    private String toString(T[] arrr) {
        String a = "[ ";
        for (int i=0; i < arrr.length; i++) {
            a += arrr[i] + ", ";
        }
        a += " ]\t";
        return a;
    }

}
