import java.util.*;

class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int totalRabbits = 0;

        // Count how many rabbits gave each answer
        for (int ans : answers) {
            countMap.put(ans, countMap.getOrDefault(ans, 0) + 1);
        }

        // Process each group of answers
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int k = entry.getKey();         // rabbit's answer
            int count = entry.getValue();   // number of rabbits who gave that answer

            int groupSize = k + 1;
            int numberOfGroups = (int) Math.ceil((double) count / groupSize);

            totalRabbits += numberOfGroups * groupSize;
        }

        return totalRabbits;
    }
}
