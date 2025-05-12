import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int digit : digits) {
            count[digit]++;
        }

        List<Integer> result = new ArrayList<>();

        // Generate all 3-digit numbers from 100 to 998
        for (int num = 100; num <= 999; num += 2) { // Only even numbers
            int d1 = num / 100;
            int d2 = (num / 10) % 10;
            int d3 = num % 10;

            // Check if we have enough digits to form this number
            count[d1]--;
            count[d2]--;
            count[d3]--;

            if (count[d1] >= 0 && count[d2] >= 0 && count[d3] >= 0) {
                result.add(num);
            }

            // Restore the count
            count[d1]++;
            count[d2]++;
            count[d3]++;
        }

        // Convert to int[]
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}
