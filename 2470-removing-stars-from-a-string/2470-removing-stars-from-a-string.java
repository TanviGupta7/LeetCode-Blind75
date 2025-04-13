class Solution {
    public String removeStars(String s) {
        String result = ""; // To store the final answer

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '*') {
                // Remove the last character if result is not empty
                if (!result.isEmpty()) {
                    result = result.substring(0, result.length() - 1);
                }
            } else {
                // Append character to result
                result += ch;
            }
        }

        return result;
    }
}
