import java.util.Stack;

class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while(s1.size()!=0){
            s2.push(s1.peek());
            s1.pop();
        }
        s1.push(x);
        while(s2.size()!=0){
            s1.push(s2.peek());
            s2.pop();
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       return s1.pop();
    }

    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty(); 
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