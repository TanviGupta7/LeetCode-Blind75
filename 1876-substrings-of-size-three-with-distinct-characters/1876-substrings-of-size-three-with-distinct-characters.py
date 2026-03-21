class Solution:
    def countGoodSubstrings(self, s):
        
        count = 0
        
        for i in range(len(s) - 2):
            
            # take 3 letters
            window = s[i:i+3]
            
            # check if all different
            if len(set(window)) == 3:
                count += 1
        
        return count