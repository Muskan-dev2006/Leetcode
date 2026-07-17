class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        int n = nums.length;
        for(int i=0; i<n;i++){
            target += nums[i];
        }
        if(target%2!=0){
            return false;
        }
        target = target/2;
        Boolean [][]dp = new Boolean[n][target+1];
        return solve(nums,n-1,target,dp);
    }
    public boolean solve(int []nums, int i, int target,Boolean [][]dp){
        if(target == 0){
            return true;
        }
        if(i == 0){
            return false;
        }
        if(dp[i][target] != null){
            return nums[0] == target;
        }
        boolean skip = solve(nums,i-1,target,dp);
        boolean take = false;

        if(target >= nums[i]){
            take = solve(nums,i-1,target-nums[i],dp);
        }
        

        return dp[i][target] = take || skip;
    }
}