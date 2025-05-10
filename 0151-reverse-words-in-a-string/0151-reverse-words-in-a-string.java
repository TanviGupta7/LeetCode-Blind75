class Solution {
    public String reverseWords(String s) {
        int i, l;
        String w = "", result = "";
        char ch;
        
        s = s.trim();  // Remove leading and trailing spaces
        s = " " + s;   // Add a space at the beginning for easy word detection
        l = s.length();

        // Iterate backwards through the string
        for (i = l-1; i >= 0; i--) {  // Notice the change: Use 'l' instead of 'l-1'
            ch = s.charAt(i);  // Get the current character
            if (ch != ' ') {
                w = ch + w;  // Add the character to the word
            } else {
                if (!w.isEmpty()) {  // Only add the word if it's not empty
                    result += w + " ";  // Add the word followed by a space
                    w = "";  // Reset the word
                }
            }
        }

        // Return the result after trimming any trailing space
        return result.trim();
    }
}
