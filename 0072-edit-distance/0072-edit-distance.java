class Solution {
    public int solve(int i, int j,String str1, String str2,int [][]dp) {
         if(i== -1){
            return j+1;
        }
        if(j==-1){
            return i+1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(str1.charAt(i)==str2.charAt(j)){
            return solve(i-1,j-1,str1,str2,dp);
        }
            int insert =  solve(i,j-1,str1,str2,dp);
            int replace = solve(i-1,j-1, str1, str2,dp);
            int delete =  solve(i-1,j,str1,str2,dp);
            int min = Math.min(insert,Math.min(replace,delete))+1;
            return dp[i][j] = min;
    }
    public int minDistance(String word1, String word2) {
        int i=word1.length();
        int j = word2.length();
        int[][]dp = new int [i][j];
        for(int []rows : dp){
            Arrays.fill(rows, -1);
        }
        int ans = solve(i-1,j-1, word1, word2,dp);
        return ans;
    }
}