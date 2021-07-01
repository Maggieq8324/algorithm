package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description LeetCode 225 用队列实现栈
 * 仅使用两个队列实现一个后入先出（LIFO）的栈，
 * 并支持普通队列的全部四种操作（push、top、pop 和 empty）
 * 实现 MyStack 类：
 *      void push(int x) 将元素 x 压入栈顶。
 *      int pop() 移除并返回栈顶元素。
 *      int top() 返回栈顶元素。
 *      boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * @author coisini
 * @date Jul 1, 2021
 * @Version 1.0
 */
public class MyStack {

    private Queue<Integer> q1;

    /**
     * 追踪记录栈顶元素
     */
    private Integer top;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        /* 创建另一个队列q2 */
        Queue<Integer> q2 = new LinkedList<>();

        /* 除了最后一个元素，将 q 中的所有元素放入 q2 */
        while (q1.size() > 1) {

            /**
             * 每从 q 中取出一个元素，都给 top 赋值
             * top 最后存储的就是 q 中除了队尾元素以外的最后一个元素
             * 即新的栈顶元素
             */
            top = q1.peek();
            q2.add(q1.remove());
        }

        /* q 中剩下的最后一个元素就是“栈顶”元素 */
        int res = q1.remove();

        /* 此时 q2 是整个数据结构存储的所有其他数据，赋值给 q */
        q1 = q2;

        /* 返回“栈顶元素” */
        return res;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }

}
