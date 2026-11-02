class Solution {
    public int minMoves2(int[] nums) {
      int n = nums.length;
        Arrays.sort(nums);
        int median = nums[n/2];
        int op = 0;
        for(int j=0; j<n; j++){
            op += Math.abs(nums[j] - median);
        }
        return op;
    }
}