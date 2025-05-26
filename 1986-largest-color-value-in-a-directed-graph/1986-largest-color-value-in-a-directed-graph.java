import java.util.*;

public class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];
        int[][] dp = new int[n][26]; // 26 for lowercase English letters

        // Initialize graph
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph and in-degree
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            inDegree[v]++;
        }

        // Queue for nodes with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        int maxColorVal = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;

            int colorIdx = colors.charAt(node) - 'a';
            dp[node][colorIdx]++;

            maxColorVal = Math.max(maxColorVal, dp[node][colorIdx]);

            for (int neighbor : graph.get(node)) {
                for (int i = 0; i < 26; i++) {
                    dp[neighbor][i] = Math.max(dp[neighbor][i], dp[node][i]);
                }
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return visited == n ? maxColorVal : -1; // Cycle check
    }
}
