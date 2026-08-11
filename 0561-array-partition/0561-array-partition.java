class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int n = nums.length;
        for(int i=0; i<n-1; i+=2){
            sum += nums[i];
        }
        return sum;
    }
}