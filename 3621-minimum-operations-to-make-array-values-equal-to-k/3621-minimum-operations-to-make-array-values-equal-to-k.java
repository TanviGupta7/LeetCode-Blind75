import java.util.*;

class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) return -1; // Impossible to reach k
            if (nums[i] > k) set.add(nums[i]);
        }

        return set.size(); // Each unique > k requires one operation
    }
}
