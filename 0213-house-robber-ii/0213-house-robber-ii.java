class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
       int prev = nums[0];
       int prev2 = 0;
       for(int i=1; i<n-1; i++){
            int take = nums[i];
            if( i > 1){
                take += prev2;
            }
            int nottake = prev;
            int curri = Math.max(take, nottake);
            prev2 = prev;
            prev = curri;
       }
       int prev1 = nums[1];
       int prev3 = 0;
       for(int i=2; i<n; i++){
            int take = nums[i];
            if( i > 1){
                take += prev3;
            }
            int nottake = prev1;
            int curri = Math.max(take, nottake);
            prev3 = prev1;
            prev1= curri;
       }
       return Math.max(prev,prev1);
    }
    
}