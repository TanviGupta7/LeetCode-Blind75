import java.util.*;

class Solution {
    public int minimumOperations(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);

        int operations = 0;

        while (!allDistinct(list)) {
            // Remove first 3 elements (or all if less than 3)
            int removeCount = Math.min(3, list.size());
            for (int i = 0; i < removeCount; i++) {
                list.remove(0);
            }
            operations++;
        }

        return operations;
    }

    // Helper function to check if list has all distinct elements
    private boolean allDistinct(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        return set.size() == list.size();
    }
}
