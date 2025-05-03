import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        // Step 1: Find a potential candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: Verify the candidate
        count = 0;
        for (int num : nums) {
            if (num == candidate) count++;
        }

        if (count > nums.length / 2) {
            return candidate;
        }

        return -1;
    }
}
