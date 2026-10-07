class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer>st = new Stack<>();

        int maxArea = 0;
        for(int i=0; i<=heights.length; i++){
            int currheight;
            if(i == heights.length){
                currheight = 0;
            }
            else{
                currheight = heights[i];
            }

            while(!st.isEmpty() && currheight < heights[st.peek()]){
                int height = heights[st.pop()];
                int width;
                if(st.isEmpty()){
                    width = i;
                }
                else{
                    width = i-st.peek()-1;
                }
                maxArea = Math.max(maxArea, height*width);
            }
            st.push(i);
        }
        return maxArea;
    }
}