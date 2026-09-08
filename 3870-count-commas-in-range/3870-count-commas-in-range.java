class Solution {
    public int countCommas(int n) {
        if(n < 1000) return 0;
        int commas = 0 ;
        commas += (n - 999);
        return commas ;
    }
}