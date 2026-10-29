class Solution {
    public int longestValidParentheses(String s) {
        int maxlen = 0;
        Stack<Integer>st = new Stack<>();
        int n = s.length();
        st.push(-1);
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }
            else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }
                else{
                    maxlen = Math.max(maxlen,i-st.peek());
                }
            }
        }
        return maxlen;
    }
}