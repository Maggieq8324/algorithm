package leetCode;

/**
 * @Description LeetCode 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回新的头节点 。
 *      列表中的节点数目在范围 [0, 104] 内
 *      1 <= Node.val <= 50
 *      0 <= val <= 50
 *
 * @author coisini
 * @date Jul 11, 2021
 * @Version 1.0
 */
public class Solution2{

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 解题一 迭代方法删除链表中所有节点值等于特定值的节点
     * 用prev表示当前节点。如果prev的下一个节点不为空且下一个节点的节点值等于给定的val则删除
     * 如果prev的下一个节点的节点值不等于给定的val，则将prev移动到下一个节点即可
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while(prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }

    /**
     * 解题二 虚拟头结点迭代
     * 创建虚拟节点dummyHead，令dummyHead.next=head，
     * 初始化prev=dummyHead，然后遍历链表进行删除操作。
     * 最终返回dummyHead.next 即为删除操作后的头节点。
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while(prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    /**
     * 解题三 递归
     * head不为空时递归地进行删除操作，后判断head的节点值是否等于val并决定是否要删除head
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}


