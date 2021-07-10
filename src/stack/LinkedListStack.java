package stack;

import linkedList.LinkedList;

/**
 * @Description 使用链表实现栈
 * @author coisini
 * @date Jul 10, 2021
 * @Version 1.0
 */
public class LinkedListStack<T> implements Stack<T> {

    /**
     * 链表
     */
    private LinkedList<T> list;

    /**
     * 构造方法
     */
    public LinkedListStack() {
        list = new LinkedList<>();
    }

    /**
     * 添加元素
     * @param t
     */
    @Override
    public void push(T t) {
        list.addFirst(t);
    }

    /**
     * 元素出栈
     * @return
     */
    @Override
    public T pop() {
        return list.removeFirst();
    }

    /**
     * 获取栈顶元素
     * @return
     */
    @Override
    public T peek() {
        return list.getFirst();
    }

    /**
     * 获取大小
     * @return
     */
    @Override
    public int getSize() {
        return list.getSize();
    }

    /**
     * 是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 重写toString方法
     * @return
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }

}
