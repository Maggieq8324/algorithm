package leetCode;

import java.util.Stack;

/**
 * @Description LeetCode 232. 用栈实现队列
 * 使用两个栈实现先入先出队列。
 * 队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 *      void push(int x) 将元素 x 推到队列的末尾
 *      int pop() 从队列的开头移除并返回元素
 *      int peek() 返回队列开头的元素
 *      boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * @author coisini
 * @date Jul 1, 2021
 * @Version 1.0
 */
public class MyQueue {

    /**
     * 栈顶为队尾，栈底为队首
     */
    private Stack<Integer> stack1;

    /**
     * 暂存除了最后一个元素以外的所有元素
     */
    private Stack<Integer> stack2;

    /**
     * 追踪存储队首元素
     */
    int front;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack1.isEmpty()) {
            front = x;
        }

        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // 如果 stack2 不为空，直接返回 stack2 的栈首元素
        if (!stack2.empty()) {
            return stack2.pop();
        }

        while (stack1.size() > 1) {
            front = stack1.peek();
            stack2.push(stack1.pop());
        }

        return stack1.pop();
    }

    /** Get the front element. */
    public int peek() {
        // 如果 stack2 不为空，直接返回 stack2 的栈首元素
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }

        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }

}
