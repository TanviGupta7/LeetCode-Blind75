 //Optimal using DP
class Solution {
    public int climbStairs(int n) {
        
        if(n==1){
            return 1;
        }
        int one = 1;
        int two = 2;
        
        for (int i=3; i<=n; i++){
            int steps = one + two;
            one = two;
            two = steps;
        }
        
        return two;
    }
}
/*
//Naive- using recursion
public class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
*/
