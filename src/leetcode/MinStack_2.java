package leetcode;


public class MinStack_2 {
	Node[] heap = new Node[1000];
	int factor = 100;
	int length = 0;
	Node top;

	class Node {
		public int val;
		public Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	private void suitHeap(int index) {
		Node n = heap[index];
		int x = heap[index].val;
		while (index > 0 && x < heap[(index - 1) / 2].val) {
			// System.out.println("suitHeap " + index);
			heap[index] = heap[(index - 1) / 2];
			index = (index - 1) / 2;
		}
		heap[index] = n;
	}

	private void rise(int index, int x) {
		Node last = heap[index];
		Node tmp;
		while (x != last.val) {
			tmp = heap[(index - 1) / 2];
			heap[(index - 1) / 2] = last;
			last = tmp;
			if (index == 0)
				break;
			index = (index - 1) / 2;
		}
		// heap[(index - 1) / 2] = last;
	}

	public void push(int x) {
		if (length == heap.length) {
			Node[] n_stack = new Node[length + factor];
			System.arraycopy(heap, 0, n_stack, 0, length);
			heap = n_stack;
		}
		Node n = new Node(x);
		heap[length] = n;
		n.next = top;
		top = n;
		suitHeap(length);
		length++;
		// print();
	}

	public void pop() {
		if (length == 0)
			return;
		int x = top.val;
		top = top.next;
		length--;
		rise(length, x);
		// print();
	}

	public int top() {
		return length > 0 ? top.val : 0;
	}

	public int getMin() {
		return length > 0 ? heap[0].val : 0;

	}

	private void print() {
		for (int i = 0; i < length; i++) {
			System.out.print(heap[i].val + " ");
		}
		System.out.println();
		Node _top = top;
		while (_top != null) {
			System.out.print(_top.val + "->");
			_top = _top.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MinStack_2 stack = new MinStack_2();
		stack.push(395);
		stack.getMin();
		stack.top();
		stack.getMin();
		stack.push(276);
		stack.push(29);
		stack.getMin();
		stack.push(-482);
		stack.getMin();
		stack.pop();
		stack.push(-108);
		stack.push(-251);
		stack.getMin();
		stack.push(-439);
		stack.top();
		stack.push(370);
		stack.pop();
		stack.pop();
		System.out.println(stack.getMin());

	}
}
