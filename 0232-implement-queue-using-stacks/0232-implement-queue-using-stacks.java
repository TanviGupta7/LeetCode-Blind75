import java.util.Stack;

class MyQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        System.out.println("The element pushed is " + x);
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }

        if (!output.empty()) {
            return output.pop();
        } else {
            System.out.println("Queue is empty");
            return -1;
        }
    }

    /** Get the front element. */
    public int peek() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }

        if (!output.empty()) {
            return output.peek();
        } else {
            System.out.println("Queue is empty");
            return -1;
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty(); // ✅ fixed
    }
}



/*class MyQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public MyQueue() {
        // No need for front and rear
    }

    public void push(int x) { //O(N)
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