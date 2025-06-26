import java.util.Stack;

class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Constructor
    public MyQueue() {
    }

    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue and returns that element.
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    // Get the front element.
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    // Returns whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/*import java.util.Stack;

class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    /** Initialize your data structure here. 
    public MyQueue() {
    }

    /** Push element x to the back of queue. 
    public void push(int x) { //O(2N)--> Expensive when there are many push operations.
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

    /** Removes the element from in front of queue and returns that element. 
    public int pop() {
       return s1.pop();
    }

    /** Get the front element. 
    public int peek() {
        return s1.peek();
    }

    /** Returns whether the queue is empty. 
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty(); 
    }
}
*/