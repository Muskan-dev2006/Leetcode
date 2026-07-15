class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][]dp = new int[m][n];
        for(int []rows : dp){
            Arrays.fill(rows, -1);
        }
        return solve(m-1, n-1,obstacleGrid, dp);
          
    }
    public int solve(int x, int y, int [][]matrix, int [][]dp){
        if(x == 0 && y==0 && matrix[x][y]!=1){
            return 1;
        }
        if(x < 0){
            return 0;
        }
        if(y < 0){
            return 0;
        }
        if(matrix[x][y] == 1){
            return 0;
        }
        if(dp[x][y]!=-1){
            return dp[x][y];
        }

        int up = solve(x-1,y,matrix,dp);
        int left = solve(x,y-1,matrix,dp);

        return dp[x][y] = up + left;
    }
}