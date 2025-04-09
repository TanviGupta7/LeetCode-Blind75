import java.util.*;

class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num < k) return -1; // Impossible to reach k
            if (num > k) set.add(num);
        }

        return set.size(); // Each unique > k requires one operation
    }
}
