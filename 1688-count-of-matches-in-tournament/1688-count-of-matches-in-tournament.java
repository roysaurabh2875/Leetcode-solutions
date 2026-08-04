class Solution {
    public int numberOfMatches(int n) {
        if(n == 1) return 0 ;
        return helper(n,0);
    }
    int helper(int n,int matches){
        if(n == 1) return matches;
        if(n % 2 == 0){
            return helper(n/2,matches+(n/2));
        }
        return helper(((n-1)/2)+1,matches+((n-1)/2));
    }
}