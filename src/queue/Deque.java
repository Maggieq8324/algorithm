package queue;

/**
 * @Description 双端队列
 * @author coisini
 * @date Jun 21, 2021
 * @Version 1.0
 */
public class Deque<T> {

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
     * 构造方法
     * @param capaCity
     */
    public Deque(int capaCity) {
        data = (T[]) new Object[capaCity];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 无参构造方法
     */
    public Deque() {
        this(10);
    }

    /**
     * 获取容量
     * @return
     */
    public int getCapaCity () {
        return data.length;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty () {
        return size == 0;
    }

    /**
     * 获取大小
     * @return
     */
    public int getSize () {
        return size;
    }

    /**
     * 末端添加元素
     */
    public void addLast (T t) {
        if (size == getCapaCity()) {
            resize(getCapaCity() * 2);
        }

        data[tail] = t;
        tail = (tail + 1) % data.length;
        size++;

    }

    /**
     * 首端添加元素
     * @param t
     */
    public void addFront (T t) {
        if (size == getCapaCity()) {
            resize(getCapaCity() * 2);
        }

        // 计算新的 front 位置
        front = front == 0 ? data.length - 1 : front - 1;
        data[front] = t;
        size++;
    }

    /**
     * 首端移除元素
     * @return
     */
    public T removeFront () {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        T re = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapaCity() / 4 && getCapaCity() / 2 != 0) {
            resize(getCapaCity() / 2);
        }

        return re;
    }

    /**
     * 末端移除元素
     * @return
     */
    public T removeLast () {

        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        // 计算新的 tail 位置
        tail = tail == 0 ? data.length - 1 : tail - 1;
        T re = data[tail];
        data[tail] = null;
        size--;

        if (size == getCapaCity() / 4 && getCapaCity() / 2 != 0) {
            resize(getCapaCity() / 2);
        }

        return re;
    }

    /**
     * 获取队首元素
     * @return
     */
    public T getFront () {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }

        return data[front];
    }

    /**
     * 获取队尾元素
     * @return
     */
    public T getLast () {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }

        return data[tail == 0 ? data.length - 1 : tail - 1];
    }

    /**
     * 数组增减容
     * @param newCapacity
     */
    public void resize (int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 重新toString方法
     * @return
     */
    @Override
    public String toString () {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d, [", getSize(), getCapaCity()));
        for (int i = 0; i < size; i++) {
            res.append(data[(i + front) % data.length]);

            if (i != size - 1) {
                res.append(",");
            }
        }

        res.append("] tail");
        return res.toString();
    }

    public static void main (String[] args) {
        // 在下面的双端队列的测试中，偶数从队尾加入；奇数从队首加入
        Deque<Integer> dq = new Deque<>();
        for(int i = 0 ; i < 16 ; i++){
            if (i % 2 == 0) {
                dq.addLast(i);
            } else {
                dq.addFront(i);
            }
            System.out.println(dq);
        }

        // 之后，我们依次从队首和队尾轮流删除元素
        System.out.println();
        for(int i = 0; !dq.isEmpty(); i++){
            if (i % 2 == 0) {
                dq.removeFront();
            } else {
                dq.removeLast();
            }
            System.out.println(dq);
        }
    }

}
