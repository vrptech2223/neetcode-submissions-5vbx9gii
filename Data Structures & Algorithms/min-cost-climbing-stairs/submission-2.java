class Solution {
    int[] cost;
    int[] dp;

    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        dp = new int[cost.length];
        Arrays.fill(dp, -1);

        return Math.min(dfs(0), dfs(1));
    }

    public int dfs(int i) {
        if (i >= cost.length) return 0;

        if (dp[i] != -1) return dp[i];

        dp[i] = cost[i] + Math.min(dfs(i + 1), dfs(i + 2));
        return dp[i];
    }
}
