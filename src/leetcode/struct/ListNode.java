package leetcode.struct;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode add(int x) {
        next = new ListNode(x);
        return next;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(val);
        ListNode cur = next;

        while (cur != null) {
            sb.append("->");
            sb.append(cur.val);
            cur = cur.next;
        }
        return sb.toString();

    }
}
