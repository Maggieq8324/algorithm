package queue;

/**
 * @Description 使用链表实现队列
 * @author coisini
 * @date Jul 10, 2021
 * @Version 1.0
 */
public class LinkedListQueue<T> implements Queue<T> {

    /**
     * 链表节点
     */
    private class Node {
        public T t;
        public Node next;

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }

        public Node(T t) {
            this(t, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return t.toString();
        }
    }

    /**
     * 队首、队尾
     */
    private Node head, tail;

    /**
     * 大小
     */
    private int size;

    /**
     * 构造方法
     */
    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 入队操作
     * @param t
     */
    @Override
    public void enqueue(T t) {
        if (tail == null) {
            tail = new Node(t);
            head = tail;
        } else {
            tail.next = new Node(t);
            tail = tail.next;
        }

        size ++;
    }

    /**
     * 出队操作
     * @return
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        Node retNode = head;
        head = head.next;
        retNode.next = null;

        if (head == null) {
            tail = null;
        }

        size --;

        return retNode.t;
    }

    /**
     * 获取队首元素
     * @return
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }

        return head.t;
    }

    /**
     * 队列大小
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 重写toString方法
     * @return
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: from ");

        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }

        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }

        queue.dequeue();
        System.out.println(queue);
    }

}
