class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]).append(i > 0 ? " " : "");
        }
        return result.toString();
    }
}
    

        /* Approach 1 beats 5%
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

    2- Approach 2- beats 5%
       s += " ";
	Stack<String> st = new Stack<String>();
	int i;
	String str = "";
	for (i = 0;i < s.length();i++)
	{
		if (s.charAt(i) == ' ')
		{ 
             if (!str.isEmpty()) {
			st.push(str);
			str = "";
		}
        }
		else
		{
			str += s.charAt(i);
		}
	}
	String ans = "";
	while (st.size() != 1)
	{
		ans += st.peek() + " ";
		st.pop();
	}
	ans += st.peek(); // The last word should'nt have a space after it
    return ans.trim();
    }
}
Approach 3- beats 5%
 s = s.trim().replaceAll("\\s+", " ");

        int left = 0;
        int right = s.length() - 1;

        String temp = "";  // To store the current word
        String ans = "";   // To store the final result

        // Iterate through the string to process each word
        while (left <= right) {
            char ch = s.charAt(left);
            
            // If character is not a space, add to the current word (temp)
            if (ch != ' ') {
                temp += ch;
            }
            // If character is a space, add the current word to the result (ans)
            else if (ch == ' ') {
                if (!ans.equals("")) {
                    ans = temp + " " + ans;  // Add the word with a space
                } else {
                    ans = temp;  // For the first word, just assign to ans
                }
                temp = "";  // Reset the current word
            }
            left++;
        }

        // If there is any remaining word in temp, add it to the result
        if (!temp.equals("")) {
            if (!ans.equals("")) {
                ans = temp + " " + ans;
            } else {
                ans = temp;
            }
        }

        return ans.trim();  // Return the final result with words reversed*/

