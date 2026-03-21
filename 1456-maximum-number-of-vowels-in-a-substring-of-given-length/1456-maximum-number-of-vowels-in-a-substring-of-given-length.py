class Solution:
    def maxVowels(self, s, k):
        
        vowels = set('aeiou')
        
        # Step 1: first window
        count = 0
        for i in range(k):
            if s[i] in vowels:
                count += 1
        
        max_count = count
        
        # Step 2: slide window
        for i in range(k, len(s)):
            
            # add new character
            if s[i] in vowels:
                count += 1
            
            # remove old character
            if s[i-k] in vowels:
                count -= 1
            
            max_count = max(max_count, count)
        
        return max_count