class Solution {
    public boolean canJump(int[] nums) {
        return solve(nums,0,0);
    }
    public boolean solve(int []nums, int i, int maxreach){
        if(i >= nums.length)
            return true;
        if(i > maxreach) return false;
        maxreach = Math.max(maxreach, i + nums[i]);
        return solve(nums, i+1,maxreach);
    }
}