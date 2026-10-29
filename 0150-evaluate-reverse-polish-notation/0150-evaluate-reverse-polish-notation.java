class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>st = new Stack<>();
        int n = tokens.length;
        for(int i=0; i<n; i++){
            String ch = tokens[i];

            if(ch.equals("+")){
                int top1 = st.pop();
                int top2 = st.pop();
                st.push(top1+top2);
            }
            else if(ch.equals("-")){
                int top1 = st.pop();
                int top2 = st.pop();
                st.push(top2-top1);
            }
            else if(ch.equals("*")){
                int top1 = st.pop();
                int top2 = st.pop();
                st.push(top2*top1);
            }
            else if(ch.equals("/")){
                int top1 = st.pop();
                int top2 = st.pop();
                st.push(top2/top1);
            }
            else{
                st.push(Integer.parseInt(ch));
            }
        }
        return st.pop();
    }
}