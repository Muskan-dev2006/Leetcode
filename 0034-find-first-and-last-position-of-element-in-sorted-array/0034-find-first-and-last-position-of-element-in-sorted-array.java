class Solution {
    public int findfirst(int []nums, int target){
        int s = 0;
        int e = nums.length-1;
        int ans = -1;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target){
                ans = mid;
                e = mid-1;
            }
            else if(nums[mid] < target){
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        return ans;
    }
     public int findlast(int []nums, int target){
        int s = 0;
        int e = nums.length-1;
        int ans = -1;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target){
                ans = mid;
                s = mid+1;
            }
            else if(nums[mid] < target){
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int a = findfirst(nums,target);
        int b = findlast(nums,target);

        return new int[]{a,b};
    }
}