class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int []dp = new int[n+1];
        Arrays.fill(dp,-1);

        return solve(n-1,nums,dp);
    }
    public int solve(int i, int []nums, int []dp){
        if(i < 0){
            return 0;
        }
        if(i==0){
            return nums[0];
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int take = nums[i] + solve(i-2,nums,dp);
        int nottake = solve(i-1,nums,dp);

        dp[i] = Math.max(take,nottake);

        return dp[i];
    }
}