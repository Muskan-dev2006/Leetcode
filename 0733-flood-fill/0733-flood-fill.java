class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        int orignalcolor = image[sr][sc];
        
        if(orignalcolor == color){
            return image;
        }

        Queue<int []>q = new LinkedList<>();

        q.add(new int []{sr,sc});
        image[sr][sc] = color;

        int []dx = {0,0,1,-1};
        int []dy = {1,-1,0,0};

        while(!q.isEmpty()){
            int []pos = q.poll();

            int x = pos[0];
            int y = pos[1];

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx>=m || ny>=n){
                    continue;
                }

                if(image[nx][ny] != orignalcolor){
                    continue;
                }

                image[nx][ny] = color;

                q.add(new int[]{nx,ny});
            }
        }

        return image;
    }
}