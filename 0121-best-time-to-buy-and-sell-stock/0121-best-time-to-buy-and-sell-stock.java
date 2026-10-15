class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        for(int i=0; i<n-1; i++){
            int j = i+1;
            while(j<n && prices[j] > prices[i]){
                profit = Math.max(profit,prices[j]-prices[i]);
                j++;
            }
        }
        return profit;
    }
}