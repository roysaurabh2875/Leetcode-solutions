class Solution {
    public boolean winnerSquareGame(int n) {
        boolean dp [] = new boolean[n+1];

        dp[0] = false ;

        for(int j = 1; j <= n;j++) {
            for (int i = 1; i * i <= j; i++) {
            int squ = i*i ;
            if(!dp[j-squ]){
                dp[j] = true ; 
                break ;
            }
        }
    }
    return dp[n] ;
    }
}