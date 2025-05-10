class Solution {
    public int strStr(String haystack, String needle) {
       int n = haystack.length();
        int m = needle.length();

        if (m == 0) return 0;

        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }

        return -1; 
    }
}
// Approach 2 beats 100%: return haystack.indexOf(needle); 
/* Approach 3 using LPS 
class Solution {
    public int strStr(String haystack, String needle) {
        // Edge case: if needle is empty, return 0
        if (needle.isEmpty()) {
            return 0;
        }

        int m = needle.length();
        int n = haystack.length();

        // Create the LPS (Longest Prefix Suffix) array
        int[] lps = new int[m];
        computeLPSArray(needle, m, lps);

        int i = 0; // Index for haystack
        int j = 0; // Index for needle

        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                // Match found, return the starting index
                return i - j;
            } else if (i < n && haystack.charAt(i) != needle.charAt(j)) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        // If no match is found
        return -1;
    }

    private void computeLPSArray(String needle, int m, int[] lps) {
        int len = 0; // Length of the previous longest prefix suffix
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        while (i < m) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
*/
