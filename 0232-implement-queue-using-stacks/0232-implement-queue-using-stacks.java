import java.util.Stack;

class MyQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public MyQueue() {
        // No need for front and rear
    }

    public void push(int x) {
        // Move all elements to output
        while (!input.isEmpty()) {
            output.push(input.pop());
        }

        // Push the new element
        System.out.println("The element pushed is " + x);
        input.push(x);

        // Move everything back
        while (!output.isEmpty()) {
            input.push(output.pop());
        }
    }

    public int pop() {
        if (input.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return input.pop();
    }

    public int peek() {
        if (input.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return input.peek();
    }

    public boolean empty() {
        return input.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */