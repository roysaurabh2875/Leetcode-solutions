class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length ;
        Integer memo[][] = new Integer[n][n];
        return dfs(piles,0,n-1,memo)  >= 0 ;
    }
    int dfs(int piles[],int left,int right,Integer memo[][]){
        if(left == right) return piles[left] ;
        if(memo[left][right]!= null) return memo[left][right] ;

        int pleft = piles[left] - dfs(piles,left+1,right,memo);
        int pright = piles[right] - dfs(piles,left,right-1,memo);

        memo[left][right] = Math.max(pleft,pright) ;
        return memo[left][right] ;
    }
}