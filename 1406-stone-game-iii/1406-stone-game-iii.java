class Solution {
    public String stoneGameIII(int[] arr) {
        int n = arr.length;
        int []dp = new int[n];
        Arrays.fill(dp,Integer.MIN_VALUE);

        int ans = solve(arr,n,0,dp);
        if(ans > 0){
            return "Alice";
        }
        else if(ans < 0){
            return "Bob";
        }
        return "Tie";
    }

    public int solve(int []arr, int n, int i,int []dp){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=Integer.MIN_VALUE){
            return dp[i];
        }
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for(int k=0; k<3 && i+k < n; k++){
            sum += arr[i+k];
            ans = Math.max(ans,sum - solve(arr,n,i+k+1,dp));
        }
        return dp[i] = ans;
    }
}