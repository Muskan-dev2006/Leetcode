class Solution {
    
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int [][]dp = new int [n][amount + 1];
        for(int []rows : dp){
            Arrays.fill(rows, -1);
        }
        return solve(coins,n-1,amount,dp);
       
    }
    public int solve(int []coins, int i, int amount, int [][]dp){
        if(amount == 0){
            return 1;
        }
        if(i < 0){
            return 0;
        }
        if(dp[i][amount]!= -1) return dp[i][amount];
        int take = 0;
        if(coins[i] <= amount){
            take = solve(coins, i, amount - coins[i],dp);
        }
        int skip = solve(coins, i-1, amount,dp);

        return dp[i][amount] = take + skip;
        
    }
}