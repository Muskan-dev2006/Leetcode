class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int i=0;
        int j = n-1;
        int [][]dp = new int[n][n];
        for(int []num : dp){
            Arrays.fill(num,-1);
        }
        return n - lps(s,i,j,dp);
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