class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapS[c1] != mapT[c2]) {
                return false;
            }

            // Mark the characters with a unique ID (i + 1 to avoid default 0)
            mapS[c1] = i + 1;
            mapT[c2] = i + 1;
        }

        return true;
    }
}
