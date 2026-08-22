class Solution {
    public boolean checkDivisibility(int n) {
        int sum =0;
        int pro =1;
        int num = n;
        while(num >0){
            int digit = num% 10;
            sum += digit ;
            pro *= digit;
            num /= 10;
        }
        return (n % (sum+pro)==0) ;
    }
}