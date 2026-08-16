class Solution {
    public boolean stoneGameIX(int[] stones) {
        int zeros = 0 ;
        int ones = 0;
        int twos = 0;
        for(int i = 0;i < stones.length ;i++){
            int r = stones[i] % 3 ;
            if(r == 0) zeros++ ;
            else if(r == 1) ones++ ;
            else if(r == 2) twos++ ;
        }
        if(zeros % 2 == 0) return ones > 0 && twos > 0 ;
        return Math.abs(ones-twos) > 2 ;
    }
}