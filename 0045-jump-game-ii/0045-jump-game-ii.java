class Solution {
    public int jump(int[] nums) {
        int left = 0;
        int right = 0;
        int maxindex = 0;
        int n = nums.length;
        int jumps = 0;
        while(right <n-1){
            maxindex = 0;
            for(int i = left; i<=right; i++){
                maxindex = Math.max(maxindex, i+ nums[i]);
            }
            jumps++;
            left = right+1;
            right=maxindex;
        }
        return jumps;
    }
}