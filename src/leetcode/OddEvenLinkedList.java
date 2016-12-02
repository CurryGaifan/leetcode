package leetcode;

import leetcode.struct.ListNode;

/**
 * Created by yanfeixiang on 2016/9/21.
 * <p/>
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * <p/>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p/>
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * <p/>
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;

        ListNode tmp = head;
        ListNode oddList = null;
        ListNode tmpOdd = null;
        ListNode tmpClone = tmp;
        while (tmp != null) {
            tmpClone = tmp;
            ListNode odd = tmp.next;
            if (odd == null)
                break;
            tmp.next = odd.next;
            tmp = tmp.next;
            odd.next = null;
            if (oddList == null) {
                oddList = odd;
                tmpOdd = odd;
            } else {
                tmpOdd.next = odd;
                tmpOdd = odd;
            }
//            System.out.println("head:" + head);
//            System.out.println("oddlist:" + oddList);
//            System.out.println(tmp.val);
//            System.out.println(tmpOdd.val);
        }
        tmpClone.next = oddList;
        return head;
    }

    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ln.add(2).add(3).add(4).add(5);
        System.out.println(new OddEvenLinkedList().oddEvenList(ln));

        System.out.println(new OddEvenLinkedList().oddEvenList(new ListNode(10)));

        ListNode ln1 = new ListNode(20);
        ln1.add(21);
        System.out.println(new OddEvenLinkedList().oddEvenList(ln1));
        System.out.println(new OddEvenLinkedList().oddEvenList(null));
    }
}
