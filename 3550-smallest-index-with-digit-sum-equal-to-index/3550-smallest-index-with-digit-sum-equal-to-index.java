class Solution {
    public int smallestIndex(int[] nums) {
        int min =  Integer.MAX_VALUE;
        int n = nums.length;

        for(int i=0; i<n; i++){
            int num = nums[i];
            int sum = 0;
            while(num!=0){
                int dig = num%10;
                sum += dig;
                num/=10;
            }

            if(sum == i){
                min = Math.min(min, i);
            }
        }
        return  min == Integer.MAX_VALUE ? -1 : min;
    }
}