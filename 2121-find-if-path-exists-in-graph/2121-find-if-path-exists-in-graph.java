class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // Step 1: Create a parent array to represent each node's parent
        int[] parent = new int[n];

        // Step 2: Initially, each node is its own parent (i.e., its own set)
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // Node i is the root of its own set
        }

        // Step 3: Union step — go through each edge and merge the sets
        for (int[] edge : edges) {
            int u = edge[0];  // first node in the edge
            int v = edge[1];  // second node in the edge
            union(u, v, parent);  // connect their sets
        }

        // Step 4: After all unions, check if source and destination have the same parent
        return find(source, parent) == find(destination, parent);
    }

    // \U0001f50d Find operation: returns the root parent of a node
    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            // Path compression step: flatten the tree by pointing node directly to its root
            parent[x] = find(parent[x], parent);
        }
        return parent[x]; // The root parent (or representative) of node x
    }

    // \U0001f517 Union operation: connects two nodes by merging their sets
    private void union(int u, int v, int[] parent) {
        int pu = find(u, parent); // Find the root of u
        int pv = find(v, parent); // Find the root of v

        if (pu != pv) {
            // If roots are different, connect them
            // You can connect pv to pu or pu to pv — both are valid (no rank optimization here)
            parent[pu] = pv;
        }
    }
}
