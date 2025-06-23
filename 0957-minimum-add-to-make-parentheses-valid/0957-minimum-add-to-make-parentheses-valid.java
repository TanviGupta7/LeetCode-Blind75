class Solution {
    public int minAddToMakeValid(String s) {
        int c1=0,c2=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
            c1++;
            else if(s.charAt(i)==')'){
                if(c1>0)
                c1--;
                else
                c2++;
            }
        }
        return c2+c1;
    }
}










        /*
        Stack<Character> st=new Stack<Character>();
        int c=0,c1=0;
        if(s.isEmpty()==true)
        return 0;
        for(int i=0; i<s.length();i++){
            char ch=s.charAt(i);

            if(ch=='('){
                st.push(ch);
            }

    
            else if(!st.isEmpty() && st.peek()=='('){
                    st.pop();
            }
            else
            st.push(ch);
        }
        return st.size();
        
    }
}*/