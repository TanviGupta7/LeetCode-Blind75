class Solution {
    public String reverseWords(String s) {
        int i, l;
        String w = "", result = "";
        char ch;
        s = s.trim();  
        s = " " + s;  
        l = s.length();

        for (i = l-1; i >= 0; i--) {  
            ch = s.charAt(i); 
            if (ch != ' ') {
                w = ch + w;  // Add reverse word
            }  else {
                if (!w.isEmpty()) {  // Only add the word if it's not empty
                    result += w + " ";  // Add the word followed by a space
                    w = "";  // Reset the word
                }
            }
        }

        return result.trim();
    }
}
