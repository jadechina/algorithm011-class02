/**
 * 循环双端队列
 *
 * @author shentao
 * @version 1.0
 * @date 2020/6/28 11:17
 **/
public class MyCircularDeque {

    private int[] arr;
    private int   size;
    private int   front;
    private int   last;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        if (k < 0) {
            throw new IllegalArgumentException("Deque size is less than 0!");
        }
        this.arr = new int[k];
        this.size = 0;
        this.front = 0;
        this.last = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == arr.length) {
            return false;
        }
        if (front == 0) {
            front = arr.length - 1;
            arr[front] = value;
        } else {
            arr[--front] = value;
        }
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == arr.length) {
            return false;
        }
        arr[last] = value;
        last = last == arr.length - 1 ? 0 : last + 1;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        front = front == arr.length - 1 ? 0 : front + 1;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        last = last == 0 ? arr.length - 1 : last - 1;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return arr[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return arr[last == 0 ? arr.length - 1 : last - 1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == arr.length;
    }
}
