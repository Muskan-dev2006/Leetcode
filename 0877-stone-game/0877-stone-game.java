class Solution {
    public int solve(int []nums, int i, int j,Integer [][]dp){
        if(i == j) return nums[i];
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int option1 = nums[i] - solve(nums,i+1,j,dp);
        int option2 = nums[j] - solve(nums,i,j-1,dp);
        return dp[i][j] = Math.max(option1, option2);
    }
    public boolean stoneGame(int[] nums) {
        int n = nums.length;
        Integer [][]dp = new Integer[n][n];

        return solve(nums,0,n-1,dp) > 0;

    }
}