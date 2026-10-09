class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int n = s.length();
        int insertions = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch=='('){
                open++;
            }
            else{
               if(i+1<n && s.charAt(i+1)==')'){
                i++;
               }
               else{
                insertions++;
               }

               if(open > 0){
                open--;
               }
               else{
                insertions++;
               }
            }

        }
        
        insertions += 2*open;

        return insertions;

        
    }
}