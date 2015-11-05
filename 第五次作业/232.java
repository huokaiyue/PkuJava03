class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> stackA = new Stack<Integer>();
    Stack<Integer> stackB = new Stack<Integer>();
    
    
    public void push(int x) {
        stackA.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!stackB.isEmpty()) {
            stackB.pop();
        } else {
            while(!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
            stackB.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if(!stackB.isEmpty()) {
            return stackB.peek();
        } else {
            while(!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
            return stackB.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return (stackA.isEmpty() && stackB.isEmpty());
    }
}