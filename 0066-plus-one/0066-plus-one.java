class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if(digits[n-1]==9){
            int []ans = new int[n+1];
            int carry = 1;
            for(int i=n-1; i>=0; i--){
                int sol= digits[i] + carry;
                ans[i+1] = sol%10;
                carry = sol/10;
            }
            if(carry!=0){
                ans[0] = carry;
            }
            return ans;
        }
        digits[n-1] = digits[n-1] + 1;
        return digits;
    }
}