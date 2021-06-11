package stack;

import array.Array;

/**
 * @Description 栈
 * @author coisini
 * @date Jun 11, 2021
 * @Version 1.0
 */
public class ArrayStack<T> implements Stack<T> {

    Array<T> data;

    public ArrayStack (int capacity) {
        data = new Array<>(capacity);
    }

    public ArrayStack () {
        data = new Array<>();
    }

    /**
     * 获取容量
     * @return
     */
    public int getCapacity () {
        return data.getCapacity();
    }

    /**
     * 添加元素
     * @param t
     */
    @Override
    public void push(T t) {
        data.addLast(t);
    }

    /**
     * 元素出栈
     * @return
     */
    @Override
    public T pop() {
        return data.removeLast();
    }

    /**
     * 获取栈顶元素
     * @return
     */
    @Override
    public T peek() {
        return data.getLast();
    }

    /**
     * 获取大小
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
        return data.isEmpty();
    }

    /**
     * 重写toString方法
     * @return
     */
    @Override
    public String toString () {
        StringBuilder resp = new StringBuilder();
        resp.append("Stack: [");
        for (int i = 0; i < data.getSize(); i ++) {
            resp.append(data.get(i));

            if (i != data.getSize() - 1) {
                resp.append(",");
            }

        }

        resp.append("] top");

        return resp.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }

        arrayStack.pop();
        System.out.println(arrayStack);
    }

}
