class Solution {
    public int lastStoneWeightII(int[] stones) {
         int n = stones.length;
        int total = 0;

        for (int x : stones)
            total += x;

        boolean[][] dp =
                new boolean[n][total + 1];

        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        dp[0][stones[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int target = 1;
                 target <= total; target++) {

                boolean notTake =
                        dp[i - 1][target];

                boolean take = false;

                if (stones[i] <= target)
                    take =
                      dp[i - 1]
                        [target - stones[i]];

                dp[i][target] =
                        take || notTake;
            }
        }

        for (int s1 = total / 2;
             s1 >= 0;
             s1--) {

            if (dp[n - 1][s1]) {
                return total - 2 * s1;
            }
        }

        return 0;
    }
}