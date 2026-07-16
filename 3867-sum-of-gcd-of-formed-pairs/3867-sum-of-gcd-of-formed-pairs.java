class Solution {
    public long gcd(long num1, long num2){
        if(num2 == 0){
            return num1;
        }
        return gcd(num2, num1%num2);
    }
    public long gcdSum(int[] nums) {
        long prefix[] = new long[nums.length];
        int mx = 0;
       
        for(int i=0; i<nums.length;i++){
            mx = Math.max(nums[i],mx);
            prefix[i] = gcd(nums[i],mx);
        }
         Arrays.sort(prefix);

        int i = 0;
        int j = nums.length - 1;
        long sum = 0;
        while( i < j){
            sum += gcd(prefix[i], prefix[j]);
            i++;
            j--;
        }
        return sum;
    }
}