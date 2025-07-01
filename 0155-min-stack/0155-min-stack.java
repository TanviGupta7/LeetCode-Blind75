import java.util.Stack;

class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }

    public void push(int val) {
        long x = val;
        if (st.isEmpty()) {
            min = x;
            st.push(x);
        } else {
            if (x >= min) {
                st.push(x);
            } else {
                st.push(2 * x - min);  // encode
                min = x;
            }
        }
    }

    public void pop() {
        if (st.isEmpty()) return;

        long top = st.pop();
        if (top < min) {
            min = 2 * min - top; // decode
        }

        if (st.isEmpty()) {
            min = Long.MAX_VALUE;
        }
    }

    public int top() {
        long top = st.peek();
        if (top >= min) {
            return (int) top;
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        if (st.isEmpty()) return -1;
        return (int) min;
    }
}
