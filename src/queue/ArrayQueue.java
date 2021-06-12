package queue;

import array.Array;

/**
 * @Description 数组队列
 * @author coisini
 * @date Jun 11, 2021
 * @Version 1.0
 */
public class ArrayQueue<T> implements Queue<T> {

    Array<T> data;

    /**
     * 构造方法
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        data = new Array<>(10);
    }

    /**
     * 构造方法
     */
    public ArrayQueue() {
        data = new Array<>();
    }

    /**
     * 添加元素
     * @param t
     */
    @Override
    public void enqueue(T t) {
        data.addLast(t);
    }

    /**
     * 元素出队
     * @return
     */
    @Override
    public T dequeue() {
        return data.removeFirst();
    }

    /**
     * 获取队首元素
     * @return
     */
    @Override
    public T getFront() {
        return data.getFirst();
    }

    /**
     * 获取队列长度
     * @return
     */
    @Override
    public int getSize() {
        return data.getSize();
    }

    /**
     * 是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * 获取队列容量
     * @return
     */
    public int getCapacity() {
        return data.getCapacity();
    }

    /**
     * 重写toString方法
     * @return
     */
    @Override
    public String toString() {
        StringBuilder resp = new StringBuilder();
        resp.append("Queue: front [");
        for (int i = 0; i < data.getSize(); i ++) {
            resp.append(data.get(i));

            if (i != data.getSize() - 1) {
                resp.append(",");
            }

        }

        resp.append("] tail");

        return resp.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
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
