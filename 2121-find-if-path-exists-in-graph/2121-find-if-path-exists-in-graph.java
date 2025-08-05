import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Step 1: Create adjacency list using your style
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // ✅ Fixed syntax

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>()); // initialize inner lists
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v); // ✅ corrected u.add(v) → get(u).add(v)
            adj.get(v).add(u);
        }

        // Step 2: DFS traversal using your pattern
        boolean[] vis = new boolean[n]; // ✅ Should be of size n (not edges.length)

        return dfs(source, destination, adj, vis); // use helper DFS function
    }

    // Your logic for DFS
    private boolean dfs(int current, int destination, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        if (current == destination) return true;
        vis[current] = true;

        for (int neighbor : adj.get(current)) {
            if (!vis[neighbor]) {
                if (dfs(neighbor, destination, adj, vis)) {
                    return true;
                }
            }
        }

        return false;
    }
}
