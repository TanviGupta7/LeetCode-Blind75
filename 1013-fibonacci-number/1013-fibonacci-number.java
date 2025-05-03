class Solution {
    public int fib(int n) {
        int a = 0, b = 1;

        if (n == 0) return a;
        if (n == 1) return b;

        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = a + b; // let b update its value first and then a gets updated
            a = temp;
        }
        return b;
    }
}
