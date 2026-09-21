class Solution {
    public int dfs(int row, int col, int [][]grid,boolean [][]vis){
        int area = 1;
        vis[row][col] = true;

        int []drow = {-1, 0, 1, 0};
        int []dcol = {0,1,0,-1};


        for(int i=0; i<4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(nrow >= 0 && nrow < grid.length && ncol >=0 && ncol < grid[0].length && grid[nrow][ncol] == 1 && !vis[nrow][ncol]){
                area += dfs(nrow,ncol,grid,vis);
            }
        }

            return area;

    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean vis[][] = new boolean[m][n];

        int maxArea = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                if(grid[i][j] == 1 && !vis[i][j])
                {
                    int area = dfs(i,j,grid,vis);
                    maxArea = Math.max(area,maxArea);
                }
            }

        }
        return maxArea;
    }
}