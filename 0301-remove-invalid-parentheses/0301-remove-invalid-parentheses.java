class Solution {
    Set<String>ans = new HashSet<>();
    int minRemove;
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;

        for(char c : s.toCharArray()){
            if(c=='('){
                left++;
            }
            else if(c == ')'){
                if(left > 0){
                    left--;
                }
                else{
                    right++;
                }
            }
        }
        minRemove = left + right;

        dfs(s,0,0,0,new StringBuilder());

        return new ArrayList<>(ans);
    }

    public void dfs(String s , int index, int open, int removed, StringBuilder current){
        if(index == s.length()){
            if(open == 0 && removed == minRemove){
                ans.add(current.toString());
            }
            return;
        }

        if(removed > minRemove){
            return;
        }

        char ch = s.charAt(index);
        dfs(s,index+1,open,removed + 1, current);

        if(ch == '('){
            current.append(ch);
            dfs(s,index+1,open+1,removed,current);
            current.deleteCharAt(current.length()-1);
        }
        else if(ch == ')'){
            if(open > 0){
                current.append(ch);
                dfs(s, index+1,open-1,removed,current);
                current.deleteCharAt(current.length()-1);

            }
        }
        else{
            current.append(ch);
            dfs(s,index+1,open, removed,current);
            current.deleteCharAt(current.length()-1);
        }

    }
}