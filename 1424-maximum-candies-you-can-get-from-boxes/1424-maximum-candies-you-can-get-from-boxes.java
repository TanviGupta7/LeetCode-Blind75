

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] hasBox = new boolean[n];
        boolean[] hasKey = new boolean[n];
        boolean[] opened = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        for (int box : initialBoxes) {
            hasBox[box] = true;
            queue.offer(box);
        }

        int totalCandies = 0;

        while (!queue.isEmpty()) {
            boolean progress = false;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int box = queue.poll();

                if ((status[box] == 1 || hasKey[box]) && !opened[box]) {
                    opened[box] = true;
                    totalCandies += candies[box];
                    progress = true;

                    // Collect keys
                    for (int key : keys[box]) {
                        hasKey[key] = true;
                        if (hasBox[key] && !opened[key]) {
                            queue.offer(key);
                        }
                    }

                    // Collect contained boxes
                    for (int contained : containedBoxes[box]) {
                        hasBox[contained] = true;
                        queue.offer(contained);
                    }
                } else {
                    queue.offer(box); // Try again in next round
                }
            }

            if (!progress) break; // No new box opened this round
        }

        return totalCandies;
    }
}
