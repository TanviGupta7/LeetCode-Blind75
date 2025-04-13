class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                // Remove the last character if star is found
                sb.deleteCharAt(sb.length() - 1);
            } else {
                // Add character to result
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
