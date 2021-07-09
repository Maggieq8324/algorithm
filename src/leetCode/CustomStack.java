package leetCode;

/**
 * @Description LeetCode 1381. 设计一个支持增量操作的栈
 * 实现自定义栈类 CustomStack ：
 *      CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量，栈在增长到 maxSize 之后则不支持 push 操作。
 *      void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
 *      int pop()：弹出栈顶元素，并返回栈顶的值，或栈为空时返回 -1 。
 *      void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-a-stack-with-increment-operation
 * @author coisini
 * @date Jul 7, 2021
 * @Version 1.0
 */
public class CustomStack {

    /**
     * 栈
     */
    private Integer[] stack;

    /**
     * 栈顶位置
     */
    int top;

    /**
     * 构造方法
     * @param maxSize
     */
    public CustomStack(int maxSize) {
        stack = new Integer[maxSize];
        top = -1;
    }

    /**
     * 添加元素
     * 判断当前元素的个数是否达到上限，如果没有达到，
     * 就把 top 后移一个位置并添加一个元素。
     * @param x
     */
    public void push(int x) {
        if (top != stack.length - 1) {
            top ++;
            stack[top] = x;
        }
    }

    /**
     * 元素出栈
     * 判断当前栈是否为空，非空返回栈顶元素并将 top 前移一位，否则返回 -1
     * @return
     */
    public int pop() {
        if (top == -1) {
            return -1;
        }

        -- top;
        return stack[top + 1];
    }

    /**
     * 栈底的 k 个元素的值都增加 val。如果栈中元素总数小于 k，则栈中的所有元素都增加 val
     * 直接对栈底的最多 k 个元素加上 val
     * @param k
     * @param val
     */
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, top + 1); i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
