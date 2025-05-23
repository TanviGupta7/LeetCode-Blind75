/*class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long[][] memo = new long[nums.length][2];
        for (long[] row : memo) {
            Arrays.fill(row, -1);
        }
        return maxSumOfNodes(0, 1, nums, k, memo);
    }

    private long maxSumOfNodes(int index, int isEven, int[] nums, int k,
            long[][] memo) {
        if (index == nums.length) {
            // If the operation is performed on an odd number of elements return
            // INT_MIN
            return isEven == 1 ? 0 : Integer.MIN_VALUE;
        }
        if (memo[index][isEven] != -1) {
            return memo[index][isEven];
        }
        // No operation performed on the element
        long noXorDone = nums[index] + maxSumOfNodes(index + 1, isEven, nums, k, memo);
        // XOR operation is performed on the element
        long xorDone = (nums[index] ^ k) +
                maxSumOfNodes(index + 1, isEven ^ 1, nums, k, memo);

        // Memoize and return the result
        return memo[index][isEven] = Math.max(xorDone, noXorDone);
    }
} */
import java.util.*;

class Solution {
    public long maximumValueSum(int[] v, int k, int[][] edges) {
        long total = 0;
        for (int val : v) {
            total += val;
        }

        long totalDiff = 0;
        int positiveCount = 0;
        long minAbsDiff = Integer.MAX_VALUE;

        for (int val : v) {
            long diff = (val ^ k) - val;
            if (diff > 0) {
                totalDiff += diff;
                positiveCount++;
            }
            minAbsDiff = Math.min(minAbsDiff, Math.abs(diff));
        }

        if (positiveCount % 2 == 1) {
            totalDiff -= minAbsDiff;
        }

        return total + totalDiff;
    }
}