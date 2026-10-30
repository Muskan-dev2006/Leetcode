class Solution {
    public int uniquePaths(int m, int n) {
        int desx = m-1;
        int desy = n-1;

        int [][]dp = new int[m][n];
        for(int []rows : dp){
            Arrays.fill(rows,-1);
        }
        return solve(desx,desy,dp);
    }
    public int solve(int x, int y, int [][]dp){
        if(x == 0 && y==0){
            return 1;
        }
        if(x < 0 || y<0){
            return 0;
        }
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        int left = solve(x,y-1,dp);
        int up = solve(x-1,y,dp);


        dp[x][y] = left + up;
        return dp[x][y];
    }
}