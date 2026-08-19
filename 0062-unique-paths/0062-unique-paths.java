class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(int[] row:dp){
        Arrays.fill(row,-1);
        }

        return solve(m,n,dp);
    }

    static int solve(int m,int n,int[][] dp){
        if(n==1 || m==1) return 1;
        if(dp[m][n]!=-1) return dp[m][n];

        dp[m][n]=solve(m-1,n,dp)+solve(m,n-1,dp);
        return dp[m][n];
    }
}