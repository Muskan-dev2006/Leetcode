class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int [][]dp = new int[m][n];
        for(int []rows : dp){
            Arrays.fill(rows, -1);
        }
        return solve(m-1, n-1,grid,dp);
    }
    public int solve(int x, int y, int [][]grid,int [][]dp){
        if(x == 0 && y==0){
            return grid[0][0];
        }
        if(x < 0){
            return Integer.MAX_VALUE;
        }
        if(y < 0){
            return Integer.MAX_VALUE;
        }
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        int up = solve(x-1, y, grid,dp);
        int left = solve(x, y-1, grid,dp);

        int ans = Math.min(up,left);

        if(ans == Integer.MAX_VALUE){
            return dp[x][y]= Integer.MAX_VALUE;
        }

        return dp[x][y] = grid[x][y] + ans;
    }
}