class Solution {
    public String removeOuterParentheses(String s) {
        //loop for : extract character
        //push into stack char i
        // check if it is an opening paranthesis push
        //if it is closing paranthsis: check if no. of opening paranthesis> closing
            //if yes- pop and print, if equal no of closing and opening it reamins in the stack
        //loop continues

        //Use a counter to track the depth of nested parentheses rather than a stack, which simplifies the logic.
        
        StringBuilder result = new StringBuilder();
        int open = 0; // Counter for open parentheses

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (open > 0) {
                    result.append(ch); // Not outermost
                }
                open++;
            } else if (ch == ')') {
                open--;
                if (open > 0) {
                    result.append(ch); // Not outermost
                }
            }
        }

        return result.toString();
    }
}