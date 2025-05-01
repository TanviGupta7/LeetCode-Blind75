class Solution {
    public boolean isPalindrome(String s) {
        return check(s, 0, s.length() - 1);
    }

    private boolean check(String s, int left, int right) {
        // Base case: when pointers cross
        if (left >= right) return true;

        // Skip non-alphanumeric from left
        if (!Character.isLetterOrDigit(s.charAt(left))) {
            return check(s, left + 1, right);
        }

        // Skip non-alphanumeric from right
        if (!Character.isLetterOrDigit(s.charAt(right))) {
            return check(s, left, right - 1);
        }

        // Compare characters (case-insensitive)
        if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
            return false;
        }

        // Recursive step: move inward
        return check(s, left + 1, right - 1);
    }
}


/* Works- without recursion
int left = 0, right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left), r = s.charAt(right);

            if (!Character.isLetterOrDigit(l)) {
                left++;
            } else if (!Character.isLetterOrDigit(r)) {
                right--;
            } else {
                if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;

/* 1- doesnt work
int i=(int)s.charAt(0);
      if(i>=s.length()/2) return true;
      if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false; 
      i++; // this doesnt pass the  updated value to recursion hence have to use helper function
      return isPalindrome(s); 
int left=0,right=s.length()-1; */
    
        /*2- doesnt work
        while(left<right){
            char l=s.charAt(left), r=s.charAt(right);
            if(!Character.isLetterOrDigit(l)) 
            ++left;
            else if(!Character.isLetterOrDigit(r)) 
            --right;
            else if(Character.toLowerCase(l)!=Character.toLowerCase(r)) 
            return false;
            else{
                left++;
                right--;
            }
        }
        return true;*/