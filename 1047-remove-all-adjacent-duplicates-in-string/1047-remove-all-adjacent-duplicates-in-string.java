class Solution {
    public String removeDuplicates(String s) {
        Stack<Character>st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && st.peek()==ch){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}