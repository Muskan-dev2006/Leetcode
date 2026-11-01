class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        int n = nums.length;
        for(int i=0; i<n; i++){
            min = Math.min(min,nums[i]);
        }
        int op = 0;
        for(int j=0; j<n; j++){
            op += nums[j] - min;
        }
        return op;

    }
}