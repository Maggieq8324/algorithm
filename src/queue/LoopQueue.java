package queue;

/**
 * @Description 循环队列
 * @author coisini
 * @date Jun 12, 2021
 * @Version 1.0
 */
public class LoopQueue<T> implements Queue<T> {

    /**
     * 数组
     */
    private T[] data;

    /**
     * 元素起始与结束位置
     */
    private int front, tail;

    /**
     * 大小
     */
    private int size;

    /**
     * 构造函数
     * @param capacity
     */
    public LoopQueue(int capacity) {
        data = (T[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 无参构造函数
     */
    public LoopQueue() {
        this(10);
    }

    /**
     * 获取容量
     * @return
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 获取大小
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 添加元素
     * @param t
     */
    @Override
    public void enqueue(T t) {
        if ((tail + 1) % data.length == front) {
            // 数组扩容
            resize(2 * getCapacity());
        }

        data[tail] = t;
        tail = (tail + 1) % data.length;
        size ++;
    }

    /**
     * 数组增减容
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity + 1];

        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 元素出队
     * @return
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty dequeue.");
        }

        T res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;

        // 数组减容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return res;
    }

    /**
     * 获取队首元素
     * @return
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is Empty.");
        }
        return data[front];
    }

    /**
     * 重写toString方法
     * @return
     */
    @Override
    public String toString() {
        StringBuilder resp = new StringBuilder();
        resp.append(String.format("Queue: size = %d, capacity = %d, front [", size, getCapacity()));
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            resp.append(data[i]);

            if ((i + 1) % data.length != tail) {
                resp.append(",");
            }

        }

        resp.append("] tail");

        return resp.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> arrayQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);

            if (i % 3 == 2) {
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }
    }

}
