class Solution {
    public int smallestNumber(int n, int t) {
        boolean found = false ;
        int ans = 0 ;
        
        while(found != true){
            int num = n ;
            int pro = 1 ;
            while(num > 0){
                pro *= num% 10 ;
                num /= 10 ;
            }
            if(pro % t == 0){
                ans = n ;
                found = true ;
            }else {
                n++ ;
            }
        }
        return ans ;
    }
}