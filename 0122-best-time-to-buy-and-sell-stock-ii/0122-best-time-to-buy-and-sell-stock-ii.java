class Solution {
    public int maxProfit(int[] nums) {
        int i=0;
        int n = nums.length;
        int profit = 0;
        for(int j=i+1; j<n; j++){
            if(nums[i] < nums[j]){
                profit += nums[j] - nums[i];
            }
            i++;
        }
        return profit;
    }
}