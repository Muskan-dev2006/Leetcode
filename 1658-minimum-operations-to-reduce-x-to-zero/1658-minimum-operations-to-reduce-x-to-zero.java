class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int total = 0;
        for(int i=0; i<n; i++){
            total += nums[i];
        }
        int target = total-x;
        int maxlen = -1;
        int sum=0;
        int left = 0;
        for(int right=0;right<n;right++){
            sum += nums[right];
            while(left<=right && sum>target){
                sum-= nums[left];
                left++;
            }
            if(sum==target){
                maxlen = Math.max(maxlen,right-left+1); 
            }
        }
        return maxlen == -1? -1:n-maxlen;

    }
}

