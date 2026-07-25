class Solution {
    public int[][] construct2DArray(int[] ans, int m, int n) {
        int [][]grid = new int[m][n];
        if(ans.length != m*n){
           return new int[][]{};
        }
        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                grid[i][j] = ans[i*n+j];
            }
        }
        return grid;
    }
}