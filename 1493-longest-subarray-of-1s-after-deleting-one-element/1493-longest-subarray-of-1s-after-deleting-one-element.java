class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int l =0;
        int maxlen = 0;
        int zcount = 0;
        for(int i=0; i<n;i++){
            if(nums[i] == 0){
                zcount++;
            }
            while(zcount > 1){
                if(nums[l] == 0){
                    zcount--;
                }
                l++;
            }
            maxlen = Math.max(maxlen,i-l+1);

        }
        return maxlen-1;

    }
}