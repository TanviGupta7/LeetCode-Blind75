import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) {
            return ans;
        }

        String[] mapping = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(digits, new StringBuilder(), 0, ans, mapping);
        return ans;
    }

    private void backtrack(String digits, StringBuilder output, int index, List<String> ans, String[] mapping) {
        if (index >= digits.length()) {
            ans.add(output.toString());
            return;
        }

        int num = digits.charAt(index) - '0';
        String letters = mapping[num];

        for (int j = 0; j < letters.length(); j++) {
            output.append(letters.charAt(j));
            backtrack(digits, output, index + 1, ans, mapping);
            output.deleteCharAt(output.length() - 1); // backtrack
        }
    }
}
