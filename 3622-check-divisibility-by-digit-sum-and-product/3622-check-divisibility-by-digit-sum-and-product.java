class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;
        int num = n;
        while(num!=0){
            int dig = num%10;
            sum += dig;
            prod *= dig;
            num/=10;
        }
        int ne = sum + prod;
        return n%ne == 0;
    }
}