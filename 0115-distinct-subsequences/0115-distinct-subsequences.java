class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int [][]dp = new int[n][m];
        for(int []rows : dp){
            Arrays.fill(rows, -1);
        }
        return solve(0,0,s,t,dp);
    }

    public int solve(int i, int j, String s, String t, int [][]dp){
        if(j == t.length()){
            return 1;
        }
        if(i == s.length()){
            return 0;
        }
        if(dp[i][j]!= -1){
            return dp[i][j];
        }

        if(s.charAt(i) == t.charAt(j)){
            int take = solve(i+1,j+1,s,t,dp);
            int nottake = solve(i+1, j, s, t, dp);

            dp[i][j] = take + nottake;
        }
        else{
            dp[i][j] = solve(i+1,j,s,t,dp);
        }

        return dp[i][j];
    }
}