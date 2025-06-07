class Solution {
    public String robotWithString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char min = 'a';

        for (char c : s.toCharArray()) {
            stack.push(c);
            freq[c - 'a']--;

            while (min <= 'z' && freq[min - 'a'] == 0) min++;

            while (!stack.isEmpty() && stack.peek() <= min) {
                res.append(stack.pop());
            }
        }

        while (!stack.isEmpty()) res.append(stack.pop());
        return res.toString();
    }
}
