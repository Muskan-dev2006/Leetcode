class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        boolean [][]visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]!=0 && !visited[i][j]){
                    long sum = dfs(i,j,grid,visited);
                    if(sum % k == 0){
                        count++;
                    }
                }
            }


        }
        return count;
    }
     public long dfs(int i, int j, int[][] grid,
                   boolean[][] visited) {
        visited[i][j] = true;

        long sum = grid[i][j];

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for (int d = 0; d < 4; d++) {
            int nrow = i + drow[d];
            int ncol = j + dcol[d];

            if (nrow >= 0 && nrow < grid.length &&
                ncol >= 0 && ncol < grid[0].length &&
                grid[nrow][ncol] != 0 &&
                !visited[nrow][ncol]) {

                sum += dfs(nrow, ncol, grid, visited);
            }
        }

        return sum;
    }
}