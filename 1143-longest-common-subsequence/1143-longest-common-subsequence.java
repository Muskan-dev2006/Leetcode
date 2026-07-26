class Solution {
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
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][]dp = new int[n][m];
        for(int []rows : dp){
            Arrays.fill(rows, -1);
        }
        return solve(n-1,m-1,text1,text2,dp);
    }
}