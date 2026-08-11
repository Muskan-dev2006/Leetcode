class Solution {
    public boolean lemonadeChange(int[] nums) {
        int n = nums.length;
        int count = 0;
        int ten = 0;
        for(int i=0; i<n;i++){
            if(nums[i] == 5){
                count++;
            }
            else if(nums[i] == 10){
                if(count == 0){
                    return false;

                }
                count--;
                ten++;
            }
            else{
                if(count >0 && ten > 0){
                    count--;
                    ten--;
                }
                else if(count >=3 ){
                    count -=3;
                }
                else{
                    return false;
                }

            }

        }
        return true;
    }
}