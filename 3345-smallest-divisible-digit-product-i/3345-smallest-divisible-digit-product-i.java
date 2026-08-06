class Solution {
    public int p(int num){
        int prod = 1;
        while(num !=0){
            int dig = num%10;
            prod*=dig;
            num /=10;
        }
        return prod;
    }
    public int smallestNumber(int n, int t) {
        int num = n;
        int ans = 0;
        for(int i=n; i<=100; i++){
            int a = p(i);
            if(a%t == 0){
                ans = i;
                break;
            }
        }
        return ans;
    }
}