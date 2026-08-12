class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int i = 0;
        int j = len-1;
        int [][]dp = new int[len][len];
        for(int []rows : dp){
            Arrays.fill(rows,-1);
        }
        return lps(s,i,j,dp);
    }
    public int lps(String s, int i, int j,int [][]dp){
        if(i == j){
            return 1;
        }
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
           
            return dp[i][j] =  2 + lps(s,i+1,j-1,dp);
        }
        return dp[i][j] = Math.max(lps(s,i+1,j,dp),lps(s,i,j-1,dp));
    }
}