class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer>st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch=='('){
                st.push(i);
            }
            else if(ch==')'){
                if(st.isEmpty()){
                    sb.setCharAt(i,'*');
                }
                else{
                    st.pop();
                }
            }
            
        }

        while(!st.isEmpty()){
            sb.setCharAt(st.pop(),'*');
        }
        StringBuilder res = new StringBuilder();
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i)!='*'){
                res.append(sb.charAt(i));
            }
        }
        return res.toString();
    }
}