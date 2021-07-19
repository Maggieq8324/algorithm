package leetCode;

/**
 * @Description LeetCode 622. 设计循环队列
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，
 * 我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * 你的实现应该支持如下操作：
 *      MyCircularQueue(k): 构造器，设置队列长度为 k 。
 *      Front: 从队首获取元素。如果队列为空，返回 -1 。
 *      Rear: 获取队尾元素。如果队列为空，返回 -1 。
 *      enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 *      deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 *      isEmpty(): 检查循环队列是否为空。
 *      isFull(): 检查循环队列是否已满。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-queue
 * @author coisini
 * @date Jul 19, 2021
 * @Version 1.0
 */
public class MyCircularQueue {

    /**
     * 链表节点
     */
    private class Node {
        public Integer val;
        public Node next;

        public Node(Integer val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(Integer val) {
            this(val, null);
        }
    }

    /**
     * 队首，队尾
     */
    private Node head, tail;
    /**
     * 长度
     */
    private int count;
    /**
     * 容量
     */
    private int capacity;

    /**
     * 初始化
     * @param k
     */
    public MyCircularQueue(int k) {
        this.capacity = k;
    }

    /**
     * 向循环队列插入一个元素。如果成功插入则返回真
     * @param value 插入元素
     * @return 成功插入返回真
     */
    public boolean enQueue(int value) {
        if (this.count == this.capacity) {
            return false;
        }

        Node newNode = new Node(value);

        if (this.count == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        this.count += 1;

        return true;
    }

    /**
     * 从循环队列中删除一个元素。如果成功删除则返回真
     * @return 成功删除返回真
     */
    public boolean deQueue() {
        if (this.count == 0) {
            return false;
        }

        this.head = this.head.next;
        this.count -= 1;
        return true;
    }

    /**
     * 从队首获取元素。如果队列为空，返回 -1
     * @return 队首元素值
     */
    public int Front() {
        if (this.count == 0) {
            return -1;
        } else {
            return this.head.val;
        }
    }

    /**
     * 获取队尾元素。如果队列为空，返回 -1
     * @return 队尾元素值
     */
    public int Rear() {
        if (this.count == 0) {
            return -1;
        } else {
            return this.tail.val;
        }

    }

    /**
     * 检查循环队列是否为空
     * @return 队列是否为空
     */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * 检查循环队列是否已满
     * @return 队列是否已满
     */
    public boolean isFull() {
        return this.count == this.capacity;
    }

}
