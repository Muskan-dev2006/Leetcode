class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;

        int total = 0;
        int count = 0;

        Queue<int []>q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]!=0){
                    total ++;
                }
                if(grid[i][j] == 2){
                    q.add(new int [] {i,j});
                }
            }
        }
        int []dx  = {0,0,1,-1};
        int []dy = {1,-1,0,0};


        int days = 0;
        while(!q.isEmpty()){
            int k = q.size();
            count += k;
            for(int j=0; j<k; j++){
                    int []pos = q.poll();
            int x = pos[0];
            int y = pos[1];

            for(int i=0; i<4; i++){
                int srcx = x + dx[i];
                int srcy = y+ dy[i];


                if(srcx < 0 || srcx >= m || srcy < 0 || srcy >= n || grid[srcx][srcy]!=1){
                    continue;
                }

                grid[srcx][srcy] = 2;
                q.add(new int [] {srcx, srcy});


            }
             
            }
            if(!q.isEmpty()) days++;
            

        }

        return total == count ? days :  -1;
    }
}