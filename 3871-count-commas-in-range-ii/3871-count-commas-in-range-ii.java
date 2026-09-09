class Solution {
    public long countCommas(long n) {
        long commas = 0;
        int k = 1 ;
        while(true){
            long lower = (long) Math.pow(10,3*k);
            if(n < lower) break ;
            long upper = (long) Math.pow(10,3*(k+1))-1 ;
            long high = Math.min(n,upper);
            commas += (high - lower + 1)*k;
            k++ ;
        }
        return commas ;
    }
}