class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
      return solve(nums, k) - solve(nums, k-1);
    }
    public int solve(int []nums, int k){
        if(k < 0) return 0;
        int l = 0;
        int count = 0;
        int sum = 0;
        for(int r=0; r<nums.length; r++){
            sum += nums[r];
            while(sum > k){
                sum -= nums[l];
                l++;
            }
            count += r-l+1;
        }
        return count;
    }
}