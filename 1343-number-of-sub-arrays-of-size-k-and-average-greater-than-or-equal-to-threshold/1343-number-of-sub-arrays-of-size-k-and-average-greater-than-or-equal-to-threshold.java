class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int count = 0;
        
        int target = k * threshold;
        
        // Step 1: initial window
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        
        if (sum >= target) count++;
        
        // Step 2: sliding window
        for (int i = k; i < n; i++) {
            sum += arr[i];
            sum -= arr[i - k];
            
            if (sum >= target) count++;
        }
        
        return count;
    }
}