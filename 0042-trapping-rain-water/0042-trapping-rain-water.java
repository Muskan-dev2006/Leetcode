class Solution {
    public int trap(int[] heights) {
        int n = heights.length;
        int l = 0;
        int r = n-1;
        int leftmax = heights[l];
        int rightmax = heights[r];
        int sol = 0;
        while(l<r){
            if(leftmax <= rightmax){
                l++;
                leftmax = Math.max(leftmax,heights[l]);
                sol += leftmax-heights[l];
            }
            else{
                r--;
                rightmax = Math.max(rightmax,heights[r]);
                sol += rightmax-heights[r];
            }
        }
        return sol;
    }
}