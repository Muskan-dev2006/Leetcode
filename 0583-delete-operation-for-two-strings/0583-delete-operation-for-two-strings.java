class Solution {
    public int minDistance(String word1, String word2) {
         int n = word1.length();
        int m = word2.length();

        int[][]dp = new int[n][m];
        for(int []rows : dp){
            Arrays.fill(rows, -1);
        }
        int ans = (n - solve(n-1,m-1,word1,word2,dp) ) + (m - solve(n-1,m-1,word1,word2,dp));
        return ans;
    }
    public int solve(int i, int j, String str1, String str2, int [][]dp){
        if(i < 0 || j <0) return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans = 0;
        if(str1.charAt(i) == str2.charAt(j)){
           ans = 1 + solve(i-1, j-1,str1,str2,dp);
        }
        else{
            ans = Math.max(solve(i,j-1,str1,str2,dp),solve(i-1,j,str1,str2,dp));
        }
        return dp[i][j] = ans;
    }
}