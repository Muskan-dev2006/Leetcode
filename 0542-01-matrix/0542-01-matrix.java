class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int [][]vis = new int [n][m];

        int [][]dis = new int[n][m];

        Queue<int []>q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0){
                    q.add(new int []{i,j,0});
                    vis[i][j] = 1;
                }
                else{
                    vis[i][j] = 0;

                }
            }
        }
        int []delrow = {-1,0,1,0};
        int []delcol = {0,1,0,-1};

        while(!q.isEmpty()){
            int []cell = q.poll();

        int row = cell[0];
        int col = cell[1];

        int steps = cell[2];

        dis[row][col] = steps;

            for(int i=0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add(new int[] {nrow,ncol, steps+1});
                }
            }
        }
        
        return dis;
    }
}