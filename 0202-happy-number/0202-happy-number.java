class Solution {
    public boolean isHappy(int n) {
        return helper(n) == 1 ;
    }
    int helper(int n){
        if(Math.pow(n,2) < 9 || n == 4) return n ;

        int sum = 0 ;
        while(n >0){
            sum += Math.pow(n%10,2);
            n /= 10 ;
        }
        return helper(sum);
    }
}