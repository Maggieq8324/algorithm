package linkedList;

/**
 * @Description 链表
 * @author coisini
 * @date Jul 7, 2021
 * @Version 1.0
 */
public class LinkedList<T> {
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
     * 虚拟头结点
     */
    private Node dummyHead;

    /**
     * 链表大小
     */
    private int size;

    public LinkedList(){
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index(0-based)位置添加元素
     */
    public void add(int index, T t) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(t, prev.next);
        size ++;
    }

    /**
     * 在链表头添加新的元素
     * @param t
     */
    public void addFirst(T t) {
        // Node node = new Node(t);
        // node.next = head;
        // head = node;

        add(0, t);
    }

    /**
     * 在链表末尾添加元素
     * @param t
     */
    public void addLast(T t) {
        add(size, t);
    }

    /**
     * 获取链表的第index(0-based)个位置的元素
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.t;
    }

    /**
     * 获取链表的第一个元素
     * @return
     */
    public T getFirst() {
        return get(0);
     }

    /**
     * 获取链表的最后一个元素
     * @return
     */
    public T getLast() {
        return get(size - 1);
     }

    /**
     * 修改链表中的第index(0-based)个位置的元素为t
     * @param index
     * @param t
     */
     public void set(int index, T t) {
       if (index < 0 || index >= size) {
           throw new IllegalArgumentException("Get failed. Illegal index.");
       }

       Node cur = dummyHead.next;
         for (int i = 0; i < index; i++) {
             cur = cur.next;
         }

         cur.t = t;
     }

    /**
     * 查找链表中是否有元素
     * @param t
     * @return
     */
     public boolean contains(T t) {
         Node cur = dummyHead.next;
         while (cur != null) {
             if (cur.t.equals(t)) {
                 return true;
             }
             cur = cur.next;
         }

         return false;
     }

    /**
     * 删除链表中的第index(0-based)个位置的元素
     * @param index
     * @return t
     */
     public T remove(int index) {
         if (index < 0 || index >= size) {
             throw new IllegalArgumentException("Get failed. Illegal index.");
         }

         Node prev = dummyHead;
         for (int i = 0; i < index; i++) {
             prev = prev.next;
         }

         Node retNode = prev.next;
         prev.next = retNode.next;
         retNode.next = null;
         size --;

         return retNode.t;
     }

    /**
     * 删除链表首元素
     * @return
     */
     public T removeFirst() {
         return remove(0);
     }

    /**
     * 删除链表末尾元素
     * @return
     */
    public T removeLast() {
         return remove(size - 1);
     }

     @Override
     public String toString() {
         StringBuilder res = new StringBuilder();

         Node cur = dummyHead.next;
         while(cur != null) {
             res.append(cur + "->");
             cur = cur.next;
         }

         res.append("NULL");

         return res.toString();
     }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }

}
