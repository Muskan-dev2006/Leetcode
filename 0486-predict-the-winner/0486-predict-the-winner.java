class Solution {
    public int solve(int []nums, int i, int j){
        if(i>j)return 0;
        if(i==j) return nums[i];
        int option1 = nums[i] + Math.min(solve(nums,i+2,j),solve(nums,i+1,j-1));
        int option2 = nums[j] + Math.min(solve(nums,i,j-2),solve(nums,i+1,j-1));
        return Math.max(option1, option2);
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int k=0;
        int j = n-1;
        int p1 = solve(nums,k,j);
        int p2 = 0;
        int sum=0;
        for(int i=0; i<nums.length;i++){
            sum += nums[i];
        }
        p2 = sum-p1;
        if(p1>=p2){
            return true;
        }
        else{
            return false;
        }
    }
}