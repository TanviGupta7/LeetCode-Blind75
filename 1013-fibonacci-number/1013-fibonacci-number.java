class Solution { // tail recursion beats 100%
    public int fib(int n) {
        return fibhelper(n, 0, 1); // Start the recursion with F(0) = 0 and F(1) = 1
    }
    
    public static int fibhelper(int n, int a, int b) {
        if (n == 0) {
            return a;  // Base case: return the value of 'a' (F(0) or the nth Fibonacci)
        }
        if (n == 1) {
            return b;  // Base case: return the value of 'b' (F(1) or the nth Fibonacci)
        }
        // Recursive call: move to the next Fibonacci number
        return fibhelper(n - 1, b, a + b); // a becomes b, and b becomes a + b (F(n) = F(n-1) + F(n-2))
    }
}


/* iteration beats 100%
class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        int a = 0, b = 1, c = 0;
        for(int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}

3- recursion beats 23%
class Solution {
    public int fib(int n) {
        return series(n);
    }

    public int series(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return series(n - 1) + series(n - 2);
    }
}

4- //tail iteration -beats 100%
int a = 0, b = 1; 

        if (n == 0) return a;
        if (n == 1) return b;

        for (int i = 2; i <= n; i++) {
            int temp = b; 
            b = a + b; // let b update its value first and then a gets updated
            a = temp;
        }
    
        return b;
        */


