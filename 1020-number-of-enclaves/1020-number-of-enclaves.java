class Solution {
    public void dfs(int r, int c, int [][]grid){
        int m = grid.length;
        int n = grid[0].length;

        if(r < 0 || r >=m || c < 0 || c >= n || grid[r][c]!=1) return;

        grid[r][c] = 0;

        dfs(r-1,c,grid);
        dfs(r+1,c,grid);
        dfs(r,c-1,grid);
        dfs(r,c+1,grid);
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for(int i=0; i<m; i++){
            if(grid[i][0] == 1){
                dfs(i,0,grid);
            }
            if(grid[i][n-1] == 1){
                dfs(i,n-1,grid);
            }
        }

        for(int j=0; j<n; j++){
            if(grid[0][j] == 1){
                dfs(0,j,grid);
            }
            if(grid[m-1][j] == 1){
                dfs(m-1,j,grid);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}