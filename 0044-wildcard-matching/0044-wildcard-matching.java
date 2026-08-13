class Solution {
    public boolean isAllStars(String s, int i){
        for(int j=0; j<=i; j++){
            if(s.charAt(j) != '*'){
                return false;
            }
            
        }
        return true;
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        int [][]dp = new int[n][m];
        for(int []nums : dp){
            Arrays.fill(nums,-1);
        }
        return solve(s,p,n-1,m-1,dp);
    }
    public boolean solve(String s, String p, int i, int j, int [][]dp){
        if(i < 0 && j<0){
            return true;
        }
        if(i >=0 && j<0){
            return false;
        }
        if( i < 0 && j>=0){
            return isAllStars(p,j);
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j] == 1;
        }

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            dp[i][j] = solve(s,p,i-1,j-1,dp) ? 1 : 0;
        }

        else if(p.charAt(j) == '*'){
            dp[i][j] = solve(s,p,i,j-1,dp) || solve(s,p,i-1,j,dp) ? 1 : 0;
        }
        else{
            dp[i][j] = 0;
        }
        return dp[i][j] == 1;
    }
}