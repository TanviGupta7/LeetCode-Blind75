class Solution {
    static final int mod = 1_000_000_007;  // Define mod

    public int countGoodNumbers(long n) {
        long odd = n / 2;
        long even = n / 2 + n % 2;
        return (int) ((power(5, even) * power(4, odd)) % mod);    
    }

    public long power(long x, long y) { //return x^y
        if (y == 0) return 1;

        long ans = power(x, y / 2);
        ans=ans*ans; //ans= (x,y/2)*(x,y/2)
        ans = ans % mod;  //taking mod  at each step so as to keep a limit check
        if (y % 2 != 0) 
        ans = ans * x; //(x,7)=(x,3)*(x,3)
        ans=ans% mod;  
        return ans;
    }
}
