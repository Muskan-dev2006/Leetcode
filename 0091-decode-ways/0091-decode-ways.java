class Solution {
    public int numDecodings(String s) {
        int n = s.length();
       
       int []dp = new int [n]; 
       Arrays.fill(dp, -1);
        return solve(s,s.length()-1,dp);
    }
    public int solve(String s, int n, int []dp){
        if(n < 0)
        return 1;
        if (s.charAt(n) == '0') {
    if (n > 0 && (s.charAt(n - 1) == '1' || s.charAt(n - 1) == '2')) {
        return solve(s, n - 2, dp);   // only "10" or "20" are valid
    }
    return 0;
}
       if(dp[n]!= -1){
        return dp[n];
       }
        int onedigit = solve(s,n-1,dp);

        int twodigit = 0;
        if(n-1 >= 0){
            int num = (s.charAt(n-1)-'0')*10 +(s.charAt(n)-'0');
        
            if(num >=10 && num <= 26){
                twodigit = solve(s,n-2,dp);
            }
        }
        return dp[n] = onedigit + twodigit;
    }
}