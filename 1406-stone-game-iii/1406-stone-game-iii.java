class Solution {
    int n ;
    int dp[] ;
    public String stoneGameIII(int[] stoneValue) {
         n = stoneValue.length ;
        dp = new int[n];

        Arrays.fill(dp,-1);
        int diff = solve(stoneValue,0);

        if(diff > 0)return "Alice";
        else if (diff < 0) return "Bob";
        else return "Tie" ;
    }
    int solve(int stone[],int i){
        if(i >= n) return 0;
        if(dp[i] != -1)return dp[i];
        int take = 0 ;
        int best = Integer.MIN_VALUE ;

        for(int k = 0;k < 3 && i+k < n;k++){
            take += stone[i+k];
            best = Math.max(best,take-solve(stone,i+k+1));
        }
        return dp[i] = best ;
    }
}