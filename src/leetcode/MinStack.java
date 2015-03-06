package leetcode;

public class MinStack {
	int[] stack = new int[1000];
	int[] heap = new int[1000];
	int factor = 100;
	int length = 0;

	private void suitHeap(int index) {
		int x = heap[index];
		while (index > 0 && x < heap[(index - 1) / 2]) {
			// System.out.println("suitHeap " + index);
			heap[index] = heap[(index - 1) / 2];
			index = (index - 1) / 2;
		}
		heap[index] = x;
	}

	private void rise(int index, int x) {
		int last = heap[index];
		int tmp = 0;
		while (index > 0 && x != heap[(index - 1) / 2]) {
			tmp = heap[(index - 1) / 2];
			heap[(index - 1) / 2] = last;
			last = tmp;
			index = (index - 1) / 2;
		}
		heap[(index - 1) / 2] = last;
	}

	public void push(int x) {
		if (length == stack.length) {
			int[] n_stack = new int[length + factor];
			System.arraycopy(stack, 0, n_stack, 0, length);
			stack = n_stack;

			n_stack = new int[length + factor];
			System.arraycopy(heap, 0, n_stack, 0, length);
			heap = n_stack;
		}
		stack[length] = x;
		heap[length] = x;
		suitHeap(length);
		length++;

	}

	public void pop() {
		if (length == 0)
			return;
		int x = stack[length - 1];
		length--;
		rise(length, x);
	}

	public int top() {
		return length > 0 ? stack[length - 1] : 0;
	}

	public int getMin() {
		return length > 0 ? heap[0] : 0;

	}

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(3);
		System.out.println(stack.top() + " " + stack.getMin());
		stack.push(2);
		System.out.println(stack.top() + " " + stack.getMin());
		stack.push(1);
		System.out.println(stack.top() + " " + stack.getMin());
		stack.push(3);
		System.out.println(stack.top() + " " + stack.getMin());
		stack.pop();
		System.out.println(stack.top() + " " + stack.getMin());
		stack.pop();
		System.out.println(stack.top() + " " + stack.getMin());
		stack.pop();
		System.out.println(stack.top() + " " + stack.getMin());
		stack.pop();
		System.out.println(stack.top() + " " + stack.getMin());
	}
}
