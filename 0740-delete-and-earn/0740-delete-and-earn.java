class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;

        for(int num: nums){
            max = Math.max(max, num);
        }
        int []points = new int[max+1];
        for(int num : nums){
            points[num] += num;
        }
        
        int prev1 = 0;
        int prev2 = points[1];
        int curri = 0;
        for(int i = 2; i<=max;i++){
            curri = Math.max(points[i]+prev1, prev2);
            prev1 = prev2;
            prev2 = curri;
        }
        return prev2;
    }

}