class Solution {
    public int maxDepth(String s) {
        Stack<Character>st = new Stack<>();

        int maxcount = 0;
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                st.push(ch);
                count++;
                maxcount = Math.max(count,maxcount);
            }
            else if(ch ==')' && !st.isEmpty()){
                st.pop();
                count--;
            }
        }
        

        return maxcount;
        }
}