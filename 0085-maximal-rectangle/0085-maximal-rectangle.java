class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int cols = matrix[0].length;
        int []heights = new int[cols];

        int maxArea = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j< cols; j++){
                if(matrix[i][j] == '1'){
                    heights[j]++;
                }
                else{
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangle(heights));
        }
        return maxArea;
    }
    public int largestRectangle(int []heights){
        Stack<Integer>st = new Stack<>();
        int maxArea = 0;
        int area = 0;
        for(int i=0; i<=heights.length; i++){
            int currentheight;
            if(i == heights.length ){
                currentheight = 0;
            }
            else{
                currentheight = heights[i];
            }
            while(!st.isEmpty() && currentheight < heights[st.peek()]){
                int height = heights[st.pop()];
                int width;
                if(st.isEmpty()){
                    width = i;
                }
                else{
                    width = i-st.peek()-1;
                }
                area = height*width;
                maxArea = Math.max(area,maxArea);
            }
            st.push(i);
        }
        return maxArea;
    }
}
