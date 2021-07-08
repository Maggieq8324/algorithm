package leetCode;

import java.util.Stack;

/**
 * @Description LeetCode 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *      push(x) —— 将元素 x 推入栈中。
 *      pop() —— 删除栈顶的元素。
 *      top() —— 获取栈顶元素。
 *      getMin() —— 检索栈中的最小元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * @author coisini
 * @date Jul 7, 2021
 * @Version 1.0
 */
public class MinStack {

    /**
     * 栈
     */
    private Stack<Integer> stack;

    /**
     * 辅助栈
     */
    private Stack<Integer> minStack;

    /**
     * 初始化
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * 将元素推入栈中
     * 每当push()新值进来时，
     * 如果小于等于 minStack，
     * 则一起push()到minStack，即更新了栈顶最小值
     * @param val
     */
    public void push(int val) {
        stack.add(val);

        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.add(val);
        }
    }

    /**
     * 删除栈顶的元素
     * 判断将pop()出去的元素值是否是minStack栈顶元素值（即最小值），
     * 如果是则将minStack栈顶元素一起pop()，
     * 这样可以保证minStack栈顶元素始终是stack中的最小值。
     */
    public void pop() {
        if (!stack.isEmpty()) {
            if (stack.pop().equals(minStack.peek())) {
                minStack.pop();
            }
        }
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    /**
     * 检索栈中的最小元素
     * 返回minStack栈顶
     * @return
     */
    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
