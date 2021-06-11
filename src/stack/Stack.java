package stack;

/**
 * @Description Stack接口
 * @author coisini
 * @date Jun 11, 2021
 * @Version 1.0
 */
public interface Stack<T> {

    /**
     * 添加元素
     * @param t
     */
    void push (T t);

    /**
     * 元素出栈
     * @return
     */
    T pop();

    /**
     * 查看栈顶元素
     * @return
     */
    T peek();

    /**
     * 获取大小
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

}
