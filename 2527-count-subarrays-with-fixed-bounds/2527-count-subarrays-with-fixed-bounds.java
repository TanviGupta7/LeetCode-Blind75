class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int minPosition = -1, maxPosition = -1, badPosition = -1;
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            if (num < minK || num > maxK) {
                badPosition = i;
            }
            if (num == minK) {
                minPosition = i;
            }
            if (num == maxK) {
                maxPosition = i;
            }
            
            count += Math.max(0, Math.min(minPosition, maxPosition) - badPosition);
        }
        
        return count;
    }
}
