package leetcode.struct;

public class RandomListNode {
	public int label;
	public RandomListNode next, random;

	public RandomListNode(int x) {
		this.label = x;
	}

	@Override
	public String toString() {
		RandomListNode l = this;
		String str = "";
		while (l != null && l.next != null && l.next.next != null) {
			str += l.label + "->";
			l = l.next;
		}
		if (l != null) {

			if (l.next != null) {
				str += l.label + "->";
				l = l.next;
			}
			str += l.label;
		}
		return str;
	}
}
