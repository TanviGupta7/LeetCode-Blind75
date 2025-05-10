class Solution {
    public String reverseWords(String s) {
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
        /*
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

        return result.trim(); */
    
