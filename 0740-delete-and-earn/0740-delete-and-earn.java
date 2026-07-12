class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;

        for(int num: nums){
            max = Math.max(max, num);
        }
        int []points = new int[max+1];
        for(int num : nums){
            points[num] += num;
        }
        
        return solve(max, points);
    }

    public int solve(int i, int []points){
        int []dp = new int[i + 1];
        dp[0] = 0;
        dp[1] = points[1];
        for(int k=2; k<=i; k++){
            int take = points[k] + dp[k-2];
            int nottake = dp[k-1];
            dp[k] = Math.max(take, nottake);
        }
        return dp[i];
    }
}