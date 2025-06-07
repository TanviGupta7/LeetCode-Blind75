class Solution {
    public String robotWithString(String s) {
        int[] freq = new int[26]; // Frequency of characters remaining in s
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        Stack<Character> stack = new Stack<>(); // Represents string t
        StringBuilder result = new StringBuilder(); // Final written string p
        char minChar = 'a'; // Current smallest character in remaining s

        for (char ch : s.toCharArray()) {
            stack.push(ch); // Perform first operation (move to t)
            freq[ch - 'a']--; // Decrease frequency as it's removed from s

            // Update minChar to the next available smallest character
            while (minChar <= 'z' && freq[minChar - 'a'] == 0) {
                minChar++;
            }

            // Perform second operation as long as top of t <= smallest left in s
            while (!stack.isEmpty() && stack.peek() <= minChar) {
                result.append(stack.pop()); // Write to paper
            }
        }

        // Write any remaining characters in t
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
