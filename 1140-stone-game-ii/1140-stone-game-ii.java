class Solution {
    int n ;
    int dp[][] ;
    int suffix [];
    public int stoneGameII(int[] piles) {
        n =piles.length ;

        dp = new int[n][n+1];
        suffix = new int[n];

        suffix[n-1]=piles[n-1];
        for(int i =n-2; i >= 0;i--){
            suffix[i] = piles[i] + suffix[i+1];
        }

        return solve(0,1);
    }
    int solve(int i,int m){
        if(i >= n){
            return 0 ;
        }
        if(2*m >= n-i){
            return suffix[i];
        }
        if(dp[i][m] != 0){
            return dp[i][m];
        }
        int maxscore = 0 ;
        for(int x = 1;x <= 2*m;x++){
            int opp = solve(i+x,Math.max(m,x));
            int curr = suffix[i] - opp ;
            maxscore = Math.max(maxscore,curr);
        }
        return dp[i][m] = maxscore ;
    }
}