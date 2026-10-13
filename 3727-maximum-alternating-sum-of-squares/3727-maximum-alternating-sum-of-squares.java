class Solution {
    public long maxAlternatingSum(int[] nums) {
        long psum = 0L;
        long nsum = 0L;
        int n = nums.length;
        int []ans = new int[n];

        for(int i=0; i<n; i++){
            ans[i] = nums[i]*nums[i];
        }
        Arrays.sort(ans);
            for(int i=0; i<n/2;i++){
                nsum += ans[i];
            }
            for(int j=n/2; j<n; j++){
                psum += ans[j];
            }
        
        return psum - nsum;
    }
}