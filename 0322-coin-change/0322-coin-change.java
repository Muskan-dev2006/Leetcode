class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [][]dp = new int [n][amount + 1];
        for(int []rows : dp){
            Arrays.fill(rows, -1);
        }
        int ans = solve(coins,coins.length-1,amount,dp);
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
    public int solve(int []coins, int i, int amount,int [][]dp){
        if(amount == 0){
            return 0;
        }
        if(i < 0){
            return Integer.MAX_VALUE;
        }
        if(dp[i][amount]!= -1){
            return dp[i][amount];
        }
        int take = Integer.MAX_VALUE;
        if(coins[i] <= amount){
            int res = solve(coins,i,amount-coins[i], dp);
            if(res!=Integer.MAX_VALUE){
                take = res+1;
            }
        }
        int skip = solve(coins,i-1,amount,dp);
        return dp[i][amount] = Math.min(take,skip);
    }
}