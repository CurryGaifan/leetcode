package leetcode;

import java.util.Stack;

/**
 * push to top, peek/pop from top, size, and is empty
 */
public class ImplementQueueusingStacks {
    Stack<Integer> pushStack = new Stack<Integer>();
    Stack<Integer> popStack = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        if (!popStack.isEmpty())
            transfer(popStack, pushStack);
        pushStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (!pushStack.isEmpty())
            transfer(pushStack, popStack);
        popStack.pop();
    }

    // Get the front element.
    public int peek() {
        if (!pushStack.isEmpty())
            transfer(pushStack, popStack);
        return popStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    private void transfer(Stack<Integer> stack1, Stack<Integer> stack2) {
        while (!stack1.empty())
            stack2.add(stack1.pop());
    }
}
