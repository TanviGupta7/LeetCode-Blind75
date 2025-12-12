class Solution {
    public String longestCommonPrefix(String[] strs) {
     // Step 1: If array is empty or null, no prefix possible
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Step 2: Take the first string as reference
        String first = strs[0];

        // Step 3: Loop through each character of the first string
        for (int i = 0; i < first.length(); i++) {

            // Current character to match in all strings
            char ch = first.charAt(i);

            // Step 4: Compare this character with the same position
            // in all remaining strings
            for (int j = 1; j < strs.length; j++) {

                // Case 1: Current string is shorter than index i
                // Case 2: Characters do not match
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {

                    // Prefix ends just before mismatch
                    return first.substring(0, i);
                }
            }
        }

        // Step 5: If all characters of first string matched,
        // then the entire first string is the common prefix
        return first;

    }
}