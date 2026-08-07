class Solution {
    public int numSquares(int n) {
        
        ArrayList<Integer>squares = new ArrayList<>();
        for(int i=1; i*i<=n; i++){
            squares.add(i*i);
        }
        int size = squares.size();
        int [][]dp = new int[size][n+1];
        for(int []rows : dp){
            Arrays.fill(rows , Integer.MAX_VALUE);
        }
        int ans = solve(squares, size-1, n,dp);
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }

    public int solve(ArrayList<Integer>squares, int i,int target, int [][]dp){
        if(target == 0){
            return 0;
        }
        if(i<0){
            return Integer.MAX_VALUE;
        }
        if(dp[i][target]!=Integer.MAX_VALUE){
            return dp[i][target];
        }
        int take = Integer.MAX_VALUE;
        if(squares.get(i)<=target){
            int res = solve(squares,i,target-squares.get(i),dp);
            if(res!=Integer.MAX_VALUE){
                take = res+1;
            }
        }
        int skip = solve(squares,i-1,target,dp);

        return dp[i][target] =  Math.min(take,skip);
    }
}