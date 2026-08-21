class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long low = 1;
        long high = (long) Arrays.stream(coins).min().getAsInt() * k;

        while(low < high){
            long mid = low + (high-low)/2;
            if(count(mid,coins) >= k){
                high = mid ;
            }else {
                low = mid+1;
            }
        }
        return low ;
    }
    long gcd(long a,long b){
        while(b != 0){
            long temp = a % b ;
            a = b ;
            b = temp ;
        }
        return a ;
    }
    long lcm(long a,long b){
        return a / gcd(a,b)*b ;
    }
    long count(long x,int[] coins){
        long ans = 0 ;
        int n = coins.length ;
        for(int mask = 1 ; mask < (1 << n);mask++){
            long multiple = 1 ;
            int bit = 0 ;
            for(int i = 0;i < n;i++){
                if((mask & (1 << i)) != 0){
                    bit++;
                    multiple = lcm(multiple,coins[i]);
                    if(multiple > x){
                        break ;
                    }
                }
            }
            if(multiple > x){
                continue ;
            }
            long value = x / multiple ;
            if(bit % 2 == 1){
                ans += value ;
            }else {
                ans -= value ;
            }
        }
        return ans ;
    }
}