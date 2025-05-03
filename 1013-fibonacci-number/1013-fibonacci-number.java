class Solution { //tail recursion
    public int fib(int n) {
        return fibhelper(n, 0, 1); // Start with F(0)=0, F(1)=1
    }

    public static int fibhelper(int n, int a, int b) {
        if(n == 0) return a;
        if(n == 1) return b;
        return fibhelper(n - 1, b, a + b);
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


