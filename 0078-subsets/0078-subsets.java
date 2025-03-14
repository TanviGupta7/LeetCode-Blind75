

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();  // Stores all subsets
        int n = nums.length;

        // Loop through all possible subsets (from 0 to 2^n - 1)
        for (int num = 0; num < (1 << n); num++) {
            List<Integer> subset = new ArrayList<>();  // New list for each subset

            // Check each bit in num to decide which elements to include
            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0) {  // If bit at position i is set
                    subset.add(nums[i]);  // Add nums[i] to subset
                }
            }

            result.add(subset);  // Add subset to final list
        }

        return result;
    }
}
