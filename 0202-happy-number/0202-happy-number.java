class Solution {
    public boolean isHappy(int n) {
        int slow = n ;
        int fast = n ;

        while(true){
            slow = sumOfSquare(slow);
            fast = sumOfSquare(sumOfSquare(fast));

            if(fast == 1) return true ;
            if(slow == fast) return false ;
        }

    
    }
    int sumOfSquare(int n){
        int sum = 0;
        while(n > 0){
            sum += Math.pow(n % 10 , 2 );
            n /=  10;
        }
        return sum ;
    }
}