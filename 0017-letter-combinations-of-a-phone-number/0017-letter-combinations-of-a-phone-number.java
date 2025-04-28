import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) return ans;
        pad("", digits, ans);
        return ans;
    }
    
    public void pad(String p, String up, List<String> ans) {
        if (up.isEmpty()) {
            ans.add(p);
            return;
        }
        int digit = up.charAt(0) - '0'; //'2' to 2

        int start = (digit - 2) * 3;
        if (digit > 7) start += 1; // \U0001f525 Important correction

        int letters = 3;
        if (digit == 7 || digit == 9) {
            letters = 4;
        }
        
        for (int i = 0; i < letters; i++) {
            char ch = (char)('a' + start + i);
            pad(p + ch, up.substring(1), ans);
        }
    }
}
