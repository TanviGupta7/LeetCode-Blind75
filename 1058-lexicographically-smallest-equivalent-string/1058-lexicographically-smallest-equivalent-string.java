class Solution {
    int[] parent = new int[26]; // 'a' to 'z'

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Initialize: each character is its own parent
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Union characters from s1 and s2
        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        // Build the result string
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            sb.append((char)(find(c - 'a') + 'a'));
        }

        return sb.toString();
    }

    // Find with path compression
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union: always attach the smaller char as root
    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            if (px < py) {
                parent[py] = px;
            } else {
                parent[px] = py;
            }
        }
    }
}
