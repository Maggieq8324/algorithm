package queue;

/**
 * @Description Queue接口
 * @author coisini
 * @date Jun 11, 2021
 * @Version 1.0
 */
public interface Queue<T> {

    /**
     * 添加元素
     * @param t
     */
    void enqueue(T t);

    /**
     * 元素出队
     * @return
     */
    T dequeue();

    /**
     * 获取队首元素
     * @return
     */
    T getFront();

    /**
     * 获取队列长度
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

}
