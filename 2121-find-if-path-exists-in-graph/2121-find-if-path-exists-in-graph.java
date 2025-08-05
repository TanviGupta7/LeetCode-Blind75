class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Step 1: Initialize parent and rank arrays
        int[] parent = new int[n]; // parent[i] = parent of node i
        int[] rank = new int[n];   // rank[i] = depth of the tree rooted at i

        // Step 2: Initially, each node is its own parent (self root)
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0; // All trees start with rank 0
        }

        // Step 3: Union operation for all edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            union(u, v, parent, rank); // Connect the two nodes
        }

        // Step 4: Check if source and destination have the same root
        return find(source, parent) == find(destination, parent);
    }

    // Path Compression: Recursively find the root and compress the path
    private int find(int node, int[] parent) {
        if (parent[node] != node) {
            // Recurse to find root, then set current node's parent to root
            parent[node] = find(parent[node], parent);
        }
        return parent[node]; // Return the root
    }

    // Union by Rank: Attach smaller tree under the root of the bigger tree
    private void union(int u, int v, int[] parent, int[] rank) {
        int rootU = find(u, parent); // Find root of u
        int rootV = find(v, parent); // Find root of v

        if (rootU == rootV) return; // Already connected, do nothing

        // Attach lower rank tree under higher rank tree
        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV; // rootV becomes parent
        } else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU; // rootU becomes parent
        } else {
            parent[rootV] = rootU; // Either one can become parent
            rank[rootU]++;         // Increase rank of new root
        }
    }
}
