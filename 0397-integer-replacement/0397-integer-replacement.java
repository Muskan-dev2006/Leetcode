class Solution {
    public long solve(long n){
        if(n == 1){
            return 0;
        }
       
        if(n%2 == 0){
            return 1 + solve(n/2);
        }
       
        return 1 + Math.min(solve(n+1), solve(n-1));
    }
    public int integerReplacement(int n) {
        long count = 0;
        count = solve(n);
        return (int)count;
    }
}