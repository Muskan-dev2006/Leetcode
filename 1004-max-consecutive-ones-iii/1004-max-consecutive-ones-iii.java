class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int zerocount = 0;
        int l = 0;
        int maxlen = 0;
        int n = nums.length;
        for(int r=0; r<n; r++){
            if(nums[r] == 0){
                zerocount++;
            }
            while(zerocount > k){
                if(nums[l] == 0){
                    zerocount--;
                }
                l++;
            }
            maxlen = Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}