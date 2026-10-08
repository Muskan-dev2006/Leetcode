class Solution {
    public int minDeletion(int[] nums) {
        int count = 0;
        int deletions = 0;
        int prev = -1;
        for(int i=0; i<nums.length; i++){
            if(count%2 == 0){
                prev = nums[i];
                count++;
            }
            else{
                if(nums[i]==prev){
                    deletions++;
                }
                else{
                    count++;
                }
            }
        }
        if(count%2 == 1){
            deletions++;
        }
        return deletions;
    }
}