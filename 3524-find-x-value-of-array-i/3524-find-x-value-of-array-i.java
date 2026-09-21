class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] res = new long[k];
        long[] dp = new long[k];

        for(int num:nums){
            long[] next = new long[k];
            int a = num % k ;
            next[a]++;

            for(int r = 0;r<k;r++){
                if(dp[r] != 0){
                    int nr = (int)((long)r*a%k);
                    next[nr] += dp[r];
                }
            }
            for(int r = 0;r < k;r++){
                res[r] += next[r];
            }
            dp = next ;
        }
        return res;
    }
}