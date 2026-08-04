import java.math.BigInteger;

class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ;i++){
            char ch = s.charAt(i);
            sb.append(ch-'a'+1);
        }
        BigInteger res = new BigInteger(sb.toString());
        for(int i = 0 ; i < k;i++){
            int sum = 0 ;
            while(res.compareTo(BigInteger.ZERO) > 0){
                sum += res.mod(BigInteger.TEN).intValue();
                res = res.divide(BigInteger.TEN) ;
            }
            res = BigInteger.valueOf(sum) ;
        }
        return res.intValue() ;
    }
}