class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        boolean [][]vis = new boolean[n][m];

        Set<List<String>>set = new HashSet<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(grid[i][j] == '1' && !vis[i][j]){
                    count++;
                    dfs(i,j,grid,vis);
                }
            }

        }
        return count;

    }

    public void dfs(int row, int col, char [][]grid, boolean[][]vis){
        vis[row][col] = true;

        int []drow = {-1, 0, 1, 0};
        int []dcol = {0,1,0,-1};


        for(int i=0; i<4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(nrow >= 0 && nrow < grid.length && ncol >=0 && ncol < grid[0].length && grid[nrow][ncol] == '1' && !vis[nrow][ncol]){
                dfs(nrow,ncol, grid,vis);
            }
        }


    }
}