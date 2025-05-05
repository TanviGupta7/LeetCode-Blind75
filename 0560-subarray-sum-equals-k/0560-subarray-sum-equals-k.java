class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0; // To store the cumulative sum of elements
        int count = 0;     // To count subarrays with sum equal to k

        // Map to store frequency of prefix sums
        Map<Integer, Integer> prefixMap = new HashMap<>();
        
        // Base case: there is one subarray (empty) with sum = 0
        prefixMap.put(0, 1);

        // Traverse through the array
        for (int num : nums) {
            prefixSum += num; // Add current number to running prefix sum

            // Check if there is a prefix sum that, when removed, gives the required sum k
            int remaining = prefixSum - k;

            // If such a prefix exists, add its frequency to the count
            count += prefixMap.getOrDefault(remaining, 0);

            // Update the frequency of the current prefix sum in the map
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }

        // Return the total count of valid subarrays
        return count;
    }
}
