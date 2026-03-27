class Solution {
    public int maxVowels(String s, int k) {
        int maxCount = 0;
        int count = 0;
        
        // Step 1: initial window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        
        maxCount = count;
        
        // Step 2: sliding window
        for (int i = k; i < s.length(); i++) {
            // add new character
            if (isVowel(s.charAt(i))) {
                count++;
            }
            
            // remove old character
            if (isVowel(s.charAt(i - k))) {
                count--;
            }
            
            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || 
               c == 'o' || c == 'u';
    }
}