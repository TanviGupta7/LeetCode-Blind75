class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int windowSum = 0;

        // Step 1: calculate first window sum
        for(int i = 0; i < k; i++){
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        // Step 2: slide the window
        for(int i = k; i < nums.length; i++){
            
            windowSum += nums[i];      // add new element
            windowSum -= nums[i-k];    // remove left element
            
            maxSum = Math.max(maxSum, windowSum);
        }

        // Step 3: return average
        return (double) maxSum / k;
    }
}