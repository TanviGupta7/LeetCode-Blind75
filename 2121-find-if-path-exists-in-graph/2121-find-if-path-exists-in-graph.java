class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i; // each node is its own parent

        for (int[] edge : edges) {
            union(edge[0], edge[1], parent);
        }

        return find(source, parent) == find(destination, parent);
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x)
            parent[x] = find(parent[x], parent); // path compression
        return parent[x];
    }

    private void union(int u, int v, int[] parent) {
        int pu = find(u, parent);
        int pv = find(v, parent);
        if (pu != pv)
            parent[pu] = pv;
    }
}
