class Solution {
    private void solve(String digit, String output, int i, List<String> ans, String[] mapping) {
        if (i >= digit.length()) {
            ans.add(output);
            return;
        }

        int num = digit.charAt(i) - '0';
        String value = mapping[num];

        for (int j = 0; j < value.length(); j++) {
            solve(digit, output + value.charAt(j), i + 1, ans, mapping);
        }
    }

    public List<String> letterCombinations(String digit) {
        List<String> ans = new ArrayList<>();
        if (digit.length() == 0) {
            return ans;
        }

        int i = 0;
        String output = "";
        String[] mapping = {
            "",    "",    "abc",  "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        
        solve(digit, output, i, ans, mapping);
        return ans;
    }
}