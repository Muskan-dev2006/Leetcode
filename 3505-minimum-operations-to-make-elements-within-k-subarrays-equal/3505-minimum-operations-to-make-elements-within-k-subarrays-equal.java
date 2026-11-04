

class Solution {

    class DualSet {

        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        long leftsize = 0, rightsize = 0;
        long leftsum = 0, rightsum = 0;

        void addLeft(int val) {
            left.put(val, left.getOrDefault(val, 0) + 1);
            leftsize++;
            leftsum += val;
        }

        void addRight(int val) {
            right.put(val, right.getOrDefault(val, 0) + 1);
            rightsize++;
            rightsum += val;
        }

        void removeLeft(int val) {
            int freq = left.get(val);

            if (freq == 1) {
                left.remove(val);
            } else {
                left.put(val, freq - 1);
            }

            leftsize--;
            leftsum -= val;
        }

        void removeRight(int val) {
            int freq = right.get(val);

            if (freq == 1) {
                right.remove(val);
            } else {
                right.put(val, freq - 1);
            }

            rightsize--;
            rightsum -= val;
        }

        void add(int val) {

            if (left.isEmpty() || val <= left.lastKey()) {
                addLeft(val);
            } else {
                addRight(val);
            }

            balance();
        }

        void remove(int val) {

            if (left.containsKey(val)) {
                removeLeft(val);
            } else {
                removeRight(val);
            }

            balance();
        }

        void balance() {

            while (leftsize > rightsize + 1) {
                int val = left.lastKey();

                removeLeft(val);
                addRight(val);
            }

            while (leftsize < rightsize) {
                int val = right.firstKey();

                removeRight(val);
                addLeft(val);
            }
        }

        long getCost() {

            int median = left.lastKey();

            long leftcost = (long) median * leftsize - leftsum;

            long rightcost = rightsum - (long) median * rightsize;

            return leftcost + rightcost;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        long[] cost = new long[n - x + 1];

        DualSet ds = new DualSet();

        // Sliding Window
        for (int i = 0; i < n; i++) {

            ds.add(nums[i]);

            if (i >= x) {
                ds.remove(nums[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = ds.getCost();
            }
        }

        // DP
        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][n + 1];

        for (int t = 0; t <= k; t++) {
            Arrays.fill(dp[t], INF);
        }

        // Base case
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int t = 1; t <= k; t++) {

            for (int i = 1; i <= n; i++) {

                // Skip current element
                dp[t][i] = dp[t][i - 1];

                // Select a window of size x
                if (i >= x && dp[t - 1][i - x] != INF) {

                    long take = dp[t - 1][i - x] + cost[i - x];

                    dp[t][i] = Math.min(dp[t][i], take);
                }
            }
        }

        return dp[k][n];
    }
}
