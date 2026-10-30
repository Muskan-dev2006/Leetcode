class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int []dp1 = new int[n+1];
        int []dp2 = new int[n+2];

        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        int take = solve(n-2,nums,0,dp1);
        int nottake = solve(n-1,nums,1,dp2);

        return Math.max(take,nottake);
    }
    public int solve(int i ,int []nums, int start, int []dp){
        if(i < start){
            return 0;
        }
        if(i==start){
            return nums[start];
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int take = nums[i] + solve(i-2, nums,start,dp);
        int nottake = solve(i-1,nums,start,dp);

        dp[i] = Math.max(take,nottake);

        return dp[i];
    }
}